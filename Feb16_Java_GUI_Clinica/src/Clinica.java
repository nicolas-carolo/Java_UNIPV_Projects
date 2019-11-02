import java.io.FileNotFoundException;
import java.util.HashSet;

public class Clinica {
    private String nomeClinica;
    private HashSet<Struttura> listaStrutture;
    private int firstDayOfWork;
    private int lastDayOfWork;
    private int orarioApertura;
    private int orarioChiusura;
    private Agenda agenda;

    public Clinica(String nomeClinica, int firstDay, int lastDay, int orarioApertura, int orarioChiusura) {
        this.nomeClinica = nomeClinica;
        this.listaStrutture = new HashSet<Struttura>();
        this.firstDayOfWork = firstDay;
        this.lastDayOfWork = lastDay;
        this.orarioApertura = orarioApertura;
        this.orarioChiusura = orarioChiusura;
        this.agenda = new Agenda(this);
    }

    public boolean addStruttura(Struttura s){
        if(listaStrutture.add(s)){
            return true;
        } else{
            return false;
        }
    }

    public String toString(){
        String descrizione = nomeClinica + "\nAperto dal giorno " + firstDayOfWork + " al giorno " + lastDayOfWork +
                "\nOrario: " + orarioApertura + "-" + orarioChiusura + "\nStrutture disponibili:\n";
        for (Struttura s: listaStrutture) {
            descrizione = descrizione + s.toString() + "\n";
        }
        return descrizione;
    }

    public Struttura isCuredIn(TypePatologie p){
        for (Struttura sl : listaStrutture) {
            if (sl.isCured(p)){
                return sl;
            }
        }
        return null;
    }

    public HashSet<Struttura> getListaStrutture() {
        return listaStrutture;
    }

    public int getFirstDayOfWork() {
        return firstDayOfWork;
    }

    public int getLastDayOfWork() {
        return lastDayOfWork;
    }

    public int getOrarioApertura() {
        return orarioApertura;
    }

    public int getOrarioChiusura() {
        return orarioChiusura;
    }

    public boolean addFromFile(String nomeFile) throws FileNotFoundException {
        agenda.addFromFile(nomeFile);
        return true;
    }

    public void printPrenotazioni(){
        System.out.println(agenda.toString());
    }

    public void printListaPazienti(){
        System.out.println(agenda.listaPazienti());
    }

    public String avviaPrenotazioneGui(String cognome, String nome, String strPatologia, String strGiorno){
        return agenda.avviaPrenotazioneGui(cognome, nome, strPatologia, strGiorno);
    }

    public String getLastPrenotazione(){
        return agenda.getLastPrenotazione();
    }
}
