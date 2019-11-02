public abstract class Partita {
    protected String nomeCasa;
    protected int punteggioCasa;
    protected String nomeOspite;
    protected int punteggioOspite;
    protected int setInProgress;
    protected boolean isInProgress;
    protected boolean isInPause;

    public abstract boolean stopSet();
    public abstract boolean startSet();
    public abstract String toString();
    public abstract boolean stopMatch();
    public abstract boolean startMatch();
    public abstract boolean addTimeOutCasa();
    public abstract boolean addTimeOutOspite();

    public Partita(String nomeCasa, String nomeOspite) {
        this.nomeCasa = nomeCasa;
        this.punteggioCasa = 0;
        this.nomeOspite = nomeOspite;
        this.punteggioOspite = 0;
        this.setInProgress = 0;
        this.isInProgress = false;
        this.isInPause = false;
    }



    public boolean puntoCasa(){
        //C-04 o V-03
        if ((isInProgress) && (!(isInPause)) && (setInProgress > 0)){
            punteggioCasa++;
            return true;
        } else {
            return false;
        }
    }

    public boolean puntoOspite(){
        //C-05 o V-04
        if ((isInProgress) && (!(isInPause)) && (setInProgress > 0)){
            punteggioOspite++;
            return true;
        } else {
            return false;
        }
    }

    public String comment(){
        //C-98 o V-98
        String commento = "Stringa letta da file";
        return commento;
    }
}
