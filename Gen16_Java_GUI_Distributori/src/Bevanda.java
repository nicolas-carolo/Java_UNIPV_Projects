public class Bevanda extends Prodotto {
    private double polvere; //espressa in grammi

    public Bevanda(String cod, String nome, double prezzo, double polvere) {
        super(cod, nome, prezzo);
        this.polvere = polvere;
    }

    public String toString(){
        return "codice: " + cod + "\nnome: " + nome + "\nprezzo: " + prezzo + "\nliofilizzato: " + polvere;
    }

    public double getPolvere(){
        return polvere;
    }
}
