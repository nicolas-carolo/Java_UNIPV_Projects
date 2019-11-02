public class CarneBio extends Carne implements Biologico{
    protected String codiceIdentificativo;

    public CarneBio(String nome, String animale, String pezzo, String codiceIndentificativo) {
        super(nome, animale, pezzo);
        this.codiceIdentificativo = codiceIndentificativo;
    }

    public boolean isBio(Alimento a){
        if(a instanceof CarneBio){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "nome: " + this.nome + "\nanimale: " + this.animale + "\npezzo: " + this.pezzo +"\ncodice identificativo: " + this.codiceIdentificativo;
    }
}
