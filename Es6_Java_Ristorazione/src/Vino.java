public class Vino extends Alimento {
    protected String tipo;
    protected String colore;
    protected double gradazione;

    public Vino(String nome, double gradazione, String tipo, String colore) {
        super(nome);
        this.gradazione = gradazione;
        this.tipo = tipo;
        this.colore = colore;
    }

    public boolean equals(Vino v){
        if ((this.nome.equals(v.nome)) && (this.tipo.equals(v.tipo)) && (this.colore.equals(v.colore)) && (this.gradazione == v.gradazione)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "nome: " + this.nome + "\ntipo: " + this.tipo + "\ncolore: " + this.colore + "\ngradazione: " + this.gradazione;
    }
}
