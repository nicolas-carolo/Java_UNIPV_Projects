public abstract class Prodotto {
    protected String cod;
    protected String nome;
    protected double prezzo;

    public Prodotto(String cod, String nome, double prezzo) {
        this.cod = cod;
        this.nome = nome;
        this.prezzo = prezzo;
    }
}
