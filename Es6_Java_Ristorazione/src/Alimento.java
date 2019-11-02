public abstract class Alimento {
    protected String nome;

    public abstract String toString();

    public Alimento(String nome) {
        this.nome = nome;
    }
}
