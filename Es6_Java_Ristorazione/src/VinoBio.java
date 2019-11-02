public class VinoBio extends Vino implements Biologico{
    protected String codiceIdentificativo;

    public VinoBio(String nome, double gradazione, String tipo, String colore, String codiceIdentificativo) {
        super(nome, gradazione, tipo, colore);
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public boolean isBio(Alimento a){
        if(a instanceof VinoBio){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "nome: " + this.nome + "\ntipo: " + this.tipo + "\ncolore: " + this.colore + "\ngradazione: " + this.gradazione + "\ncodice identificativo: " + this.codiceIdentificativo;
    }
}
