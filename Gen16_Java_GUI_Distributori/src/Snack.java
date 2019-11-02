public class Snack extends Prodotto {
    public Snack(String cod, String nome, double prezzo) {
        super(cod, nome, prezzo);
    }

    @Override
    public String toString() {
        return "codice: " + cod + "\nnome: " + nome + "\nprezzo: " + prezzo;
    }
}
