import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadFile {
    private String sport;
    private int action;
    private String descrizione;
    private int giorno, mese, anno;
    private int ora, minuto;
    private int minutoStartSet;
    private Scanner inputStream = null;
    private Partita partita = null;

    public boolean openFile(String nomeFile){
        Scanner inputFile = null;
        try{
            inputFile = new Scanner(new File(nomeFile));
        }
        catch(FileNotFoundException e){
            System.out.println("File non trovato!");
            return false;
        }
        inputStream = inputFile;
        return true;
    }

    public boolean updateFromFile(){
        if (inputStream == null){
            return false;
        }
        if (!(inputStream.hasNextLine())) {
            closeFile();
            return false;
        }
        String riga = inputStream.nextLine();

        StringTokenizer token = new StringTokenizer(riga, "\t");
        String cod = token.nextToken();
        descrizione = token.nextToken();
        String dataOra = token.nextToken();

        StringTokenizer tokenDataOra = new StringTokenizer(dataOra, " ");
        String data = tokenDataOra.nextToken();
        String strOra = tokenDataOra.nextToken();

        StringTokenizer tokenData = new StringTokenizer(data, "/");
        giorno = Integer.parseInt(tokenData.nextToken());
        mese = Integer.parseInt(tokenData.nextToken());
        anno = Integer.parseInt(tokenData.nextToken());

        StringTokenizer tokenOra = new StringTokenizer(strOra, ":");
        ora = Integer.parseInt(tokenOra.nextToken());
        minuto = Integer.parseInt(tokenOra.nextToken());

        StringTokenizer tokenCod = new StringTokenizer(cod, "-");
        sport = tokenCod.nextToken();
        action = Integer.parseInt(tokenCod.nextToken());

        if (partita == null){
            if (sport.equals("C")){
                partita = new PartitaCalcio("Casa", "Ospite");
            } else if (sport.equals("V")) {
                partita = new PartitaVolley("Casa", "Ospite");
            } else {
                System.out.println("Errore!!!");
            }
        }

        System.out.println("******************");

        //verifica se il codice corrisponde a un'azione
        if(!(selectAction())){
            updateFromFile();
        }

        System.out.println(sport + action);
        System.out.println(descrizione);

        System.out.println(partita.toString());

        return true;
    }

    public Scanner getInputStream() {
        return inputStream;
    }

    public boolean closeFile(){
        inputStream.close();
        return true;
    }

    private boolean selectAction(){
        if (sport.equals("C")){
            switch (action){
                case 0:
                    partita.startMatch();
                    setMinutoStartSet();
                    System.out.println("Minuto di gioco: " + getMinutoSet());
                    return true;
                case 1:
                    partita.stopSet();
                    System.out.println("Minuto di gioco: " + getMinutoSet());
                    return true;
                case 2:
                    partita.startSet();
                    setMinutoStartSet();
                    System.out.println("Minuto di gioco: " + getMinutoSet());
                    return true;
                case 4:
                    partita.puntoCasa();
                    System.out.println("Minuto di gioco: " + getMinutoSet());
                    return true;
                case 5:
                    partita.puntoOspite();
                    System.out.println("Minuto di gioco: " + getMinutoSet());
                    return true;
                case 98:
                    partita.comment();
                    System.out.println("Minuto di gioco: " + getMinutoSet());
                    return true;
                case 99:
                    partita.stopMatch();
                    System.out.println("Minuto di gioco: " + getMinutoSet());
                    return true;
                default:
                    System.out.println("ILLEGALE!!");
                    return false;
            }
        }

        if (sport.equals("V")){
            switch (action){
                case 0:
                    //System.out.println("Funziona: " + partitaVolley.startMatch());
                    partita.startMatch();
                    return true;
                case 1:
                    partita.startSet();
                    return true;
                case 2:
                    partita.stopSet();
                    return true;
                case 3:
                    partita.puntoCasa();
                    return true;
                case 4:
                    partita.puntoOspite();
                    return true;
                case 5:
                    partita.addTimeOutCasa();
                    return true;
                case 6:
                    partita.addTimeOutOspite();
                    return true;
                case 98:
                    partita.comment();
                    return true;
                case 99:
                    partita.stopMatch();
                    return true;
                default:
                    System.out.println("ILLEGALE!!");
                    return false;
            }
        }

        return false;
    }

    private void setMinutoStartSet(){
         minutoStartSet = minuto + 60 * ora;
    }

    public int getMinutoSet(){
        return (minuto + 60 * ora) - minutoStartSet;
    }

    public Partita getPartita(){
        return partita;
    }

    public String getDescrizione(){
        return descrizione;
    }
}
