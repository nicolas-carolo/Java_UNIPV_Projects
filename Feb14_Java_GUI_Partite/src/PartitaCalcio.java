public class PartitaCalcio extends Partita {

    public PartitaCalcio(String nomeCasa, String nomeOspite) {
        super(nomeCasa, nomeOspite);
    }

    public boolean startMatch(){
        //C-00
        if ((setInProgress == 0) && (!(isInProgress))){
            setInProgress = 1;
            isInProgress = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean stopMatch(){
        //C-99
        if (isInProgress){
            isInProgress = false;
            isInPause = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean stopSet() {
        //C-01
        if (!(isInPause) && (setInProgress == 1)){
           isInPause = true;
           return true;
        } else {
            return false;
        }
    }

    public boolean startSet(){
        //C-02
        if ((setInProgress == 1) && (isInPause)){
            setInProgress = 2;
            isInPause = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean addTimeOutCasa(){
        //(non implementata)
        return false;
    }

    public boolean addTimeOutOspite(){
        //(non implementata)
        return false;
    }

    public String toString(){
        return "Casa: " + nomeCasa + "\t" + punteggioCasa + "\nOspite: " + nomeOspite + "\t" + punteggioOspite
                + "\nTempo: " + setInProgress + "\nIn corso: " + isInProgress + "\nIn pausa: " + isInPause;
    }

}