import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Agenda {
    private HashMap<String, Cura> listaAppuntamenti;
    private Clinica clinica;
    private String lastPrenotazione;

    public Agenda(Clinica c) {
        this.listaAppuntamenti = new HashMap<String, Cura>();
        this.clinica = c;
    }

    public boolean addFromFile(String nomeFile){
        Scanner inpuntStream;
        String cognome;
        String nome;
        String keyPrenotazione;
        TypePatologie patologia;
        int giornoPreferito;
        try{
            inpuntStream = new Scanner(new File(nomeFile));
        } catch (FileNotFoundException e){
            return false;
        }
        while (inpuntStream.hasNextLine()){
            giornoPreferito = 0;
            String riga = inpuntStream.nextLine();
            StringTokenizer dataToken = new StringTokenizer(riga, "\t");
            cognome = dataToken.nextToken();
            nome = dataToken.nextToken();
            try{
                patologia = TypePatologie.valueOf(dataToken.nextToken());
                if (dataToken.hasMoreTokens()){
                    giornoPreferito = Integer.parseInt(dataToken.nextToken());
                }
                Struttura struttura = assegnaStruttura(patologia);
                if (struttura != null){
                    keyPrenotazione = prenotazione(struttura, giornoPreferito);
                    if (keyPrenotazione != null){
                        effettuaPrenotazione(keyPrenotazione, cognome, nome, new Patologia(patologia), struttura);
                    } else{
                        System.out.println(cognome + " " + nome + ": tutto esaurito!");
                    }
                }
            } catch (IllegalArgumentException e){
                System.out.println(cognome + " " + nome + ": questa patologia non è curata in questa clinica!");
            }
        }
        inpuntStream.close();
        return true;
    }

    private Struttura assegnaStruttura(TypePatologie p){
        Struttura struttura = clinica.isCuredIn(p);
        if (!(struttura == null)){
            return struttura;
        }
        return null;
    }

    private String prenotazione(Struttura s, int giornoPreferito){
        if (giornoPreferito == 0){
            return checkPrenotazioneEveryDay(s);
        } else {
            return checkPrenotazioneDay(s, giornoPreferito);
        }
    }

    private String checkPrenotazioneEveryDay(Struttura s){
        int i;  //giorno
        int j;  //ora
        Cura c = null;
        String strRichiesta = "";
        for (i = clinica.getFirstDayOfWork(); i <= clinica.getLastDayOfWork(); i++){
            for (j = clinica.getOrarioApertura(); j < clinica.getOrarioChiusura(); j++){
                strRichiesta = s.getTipoStruttura() + "_" + i + "_" + j;
                c = listaAppuntamenti.get(strRichiesta);
                if (c == null){
                    return strRichiesta;
                }
            }
        }
        return null;
    }

    private String checkPrenotazioneDay(Struttura s, int giornoPreferito){
        int j;  //ora
        Cura c = null;
        String strRichiesta = "";

        if (giornoPreferito < clinica.getFirstDayOfWork() || giornoPreferito > clinica.getLastDayOfWork()){
            System.out.println("Nel giorno " + giornoPreferito + " la clinica è chiusa");
            return null;
        }

        for (j = clinica.getOrarioApertura(); j < clinica.getOrarioChiusura(); j++){
            strRichiesta = s.getTipoStruttura() + "_" + giornoPreferito + "_" + j;
            c = listaAppuntamenti.get(strRichiesta);
            if (c == null){
                return strRichiesta;
            }
        }
        return null;
    }

    private String effettuaPrenotazione(String keyPrenotazione, String cognome, String nome, Patologia patologia, Struttura struttura){
        Fisioterapista fisioterapista = struttura.getFisioterapista();
        StringTokenizer keyPrenotazioneToken = new StringTokenizer(keyPrenotazione, "_");
        keyPrenotazioneToken.nextToken();
        int giorno = Integer.parseInt(keyPrenotazioneToken.nextToken());
        int ora = Integer.parseInt(keyPrenotazioneToken.nextToken());
        Cura c = new Cura(cognome, nome, patologia, struttura, giorno, ora, fisioterapista);
        listaAppuntamenti.put(keyPrenotazione, c);
        System.out.println("Prenotazione effettuata:");
        System.out.println(c.toString() + "\n");
        lastPrenotazione = c.toString();
        return "Prenotazione effettuata!";
    }

    public String toString(){
        String appuntamenti = "";
        for (String key : listaAppuntamenti.keySet()) {
            appuntamenti = appuntamenti + listaAppuntamenti.get(key).toString() + "\n\n";
        }
        return appuntamenti;
    }

    public String listaPazienti(){
        String pazienti = "";
        HashSet<String> listaPazienti = new HashSet<String>();
        for (String key : listaAppuntamenti.keySet()) {
            listaPazienti.add(listaAppuntamenti.get(key).infoPaziente());
        }
        for (String info : listaPazienti) {
            pazienti = pazienti + info + "\n";
        }
        return pazienti;
    }

    public String avviaPrenotazioneGui(String cognome, String nome, String strPatologia, String strGiorno){
        TypePatologie patologia;
        Struttura struttura;
        String keyPrenotazione;
        int giornoPreferito;
        try{
            giornoPreferito = Integer.parseInt(strGiorno);
        } catch (NumberFormatException nfe){
            giornoPreferito = 0;
        }

        try{
            patologia = TypePatologie.valueOf(strPatologia);
            struttura = assegnaStruttura(patologia);
            if (struttura != null){
                keyPrenotazione = prenotazione(struttura, giornoPreferito);
                if (keyPrenotazione != null){
                 return effettuaPrenotazione(keyPrenotazione, cognome, nome, new Patologia(patologia), struttura);
                } else{
                 System.out.println(cognome + " " + nome + ": tutto esaurito!");
                 return cognome + " " + nome + ": tutto esaurito!";
                }
          }
        } catch (IllegalArgumentException e){
            System.out.println(cognome + " " + nome + ": questa patologia non è curata in questa clinica!");
            return cognome + " " + nome + ": questa patologia non è curata in questa clinica!";
        }
        return "Prenotazione non valida!";
    }

    public String getLastPrenotazione() {
        return lastPrenotazione;
    }
}
