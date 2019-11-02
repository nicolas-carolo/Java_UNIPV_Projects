public abstract class Accountable {
    protected AccountableType accountable;
    protected double importo;

    public Accountable(double importo, AccountableType accountable) {
        this.accountable = accountable;
        this.importo = importo;
        //il segno di importo viene stabilito dal valore di accountable e non dal segno di importo passato dall'utente
        if (this.importo < 0) {
            this.importo = -importo;
        } else {
            this.importo = importo;
        }
    }
}
