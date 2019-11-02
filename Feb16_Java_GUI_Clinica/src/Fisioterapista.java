public class Fisioterapista {
    private String nome;
    private String cognome;
    private String cod;

    public Fisioterapista(String nome, String cognome, String cod) {
        this.nome = nome;
        this.cognome = cognome;
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}
