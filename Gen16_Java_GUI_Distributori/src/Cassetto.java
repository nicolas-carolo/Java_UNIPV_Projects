public class Cassetto {
    private Snack snack;
    private int quantita;
    private double prezzoProdotto;

    public Cassetto(Snack snack) {
        this.snack = snack;
        this.quantita = 20;
        this.prezzoProdotto = snack.prezzo;
    }

    public void riempiCassetto(){
        quantita = 20;
    }

    public boolean prelevaSnack(){
        if (quantita > 0){
            quantita--;
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return "codice snack: " + snack.cod + "\nnome snack: " + snack.nome + "\nquantità: " + quantita + "\nprezzo: "
                + prezzoProdotto;
    }

    public int getQuantita(){
        return quantita;
    }

    public double getPrezzoProdotto(){
        return prezzoProdotto;
    }

    public Snack getSnack() {
        return snack;
    }
}
