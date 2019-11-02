public class Carne extends Alimento{
    protected String animale;
    protected String pezzo;

    public Carne(String nome, String animale, String pezzo) {
        super(nome);
        this.animale = animale;
        this.pezzo = pezzo;
    }

    public boolean equals(Carne c){
        if ((this.nome.equals(c.nome)) && (this.animale.equals(c.animale)) && (this.pezzo.equals(c.pezzo))){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "nome: " + this.nome + "\nanimale: " + this.animale + "\npezzo: " + this.pezzo;
    }
}
