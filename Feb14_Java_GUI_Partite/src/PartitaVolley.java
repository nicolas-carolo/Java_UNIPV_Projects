public class PartitaVolley extends Partita {
    private int setWinCasa;
    private int setWinOspite;
    private int timeOutCasa;
    private int timeOutOspite;

    public PartitaVolley(String nomeCasa, String nomeOspite) {
        super(nomeCasa, nomeOspite);
        this.setWinCasa = 0;
        this.setWinOspite = 0;
        this.timeOutCasa = 0;
        this.timeOutOspite = 0;
    }

    public boolean startMatch(){
        //V-00
        if ((setInProgress == 0) && (!(isInProgress))){
            //setInProgress = 1;
            isInProgress = true;
            isInPause = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean stopMatch(){
        //V-99
        if ((isInPause) && (isInProgress)){
            isInPause = false;
            isInProgress = false;
            //setWinnerSet();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean stopSet() {
        //V-02
        if (!(isInPause)){
            isInPause = true;
            setWinnerSet();
            return true;
        } else {
            return false;
        }
    }

    public boolean startSet(){
        //V-01
        if ((isInProgress) && (isInPause)){
            setInProgress++;
            isInPause = false;
            punteggioCasa = 0;
            punteggioOspite = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean addTimeOutCasa(){
        //V-05
        if ((isInProgress) && (!(isInPause))){
            timeOutCasa++;
            return true;
        } else {
            return false;
        }
    }

    public boolean addTimeOutOspite(){
        //V-06
        if ((isInProgress) && (!(isInPause))){
            timeOutOspite++;
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return "Casa: " + nomeCasa + "\t" + punteggioCasa + "\nOspite: " + nomeOspite + "\t" + punteggioOspite + "\nSet: "
                + setInProgress + "\nSet vinti, Time-out casa: " + setWinCasa + "\t" + timeOutCasa
                + "\nSet vinti, Time-out ospite: " + setWinOspite + "\t" + timeOutOspite + "\nIn corso: " + isInProgress
                + "\nIn pausa: " + isInPause;
    }

    private void setWinnerSet(){
        if (this.punteggioCasa > this.punteggioOspite){
            this.setWinCasa++;
        }
        if (this.punteggioCasa < this.punteggioOspite) {
            this.setWinOspite++;
        }
    }

    public int getSetWinCasa() {
        return setWinCasa;
    }

    public int getSetWinOspite() {
        return setWinOspite;
    }

    public int getTimeOutCasa() {
        return timeOutCasa;
    }

    public int getTimeOutOspite() {
        return timeOutOspite;
    }
}
