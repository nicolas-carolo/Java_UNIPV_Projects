import java.util.HashSet;

public class Struttura {
    private TypeStrutture tipoStruttura;
    private HashSet<Patologia> listaPatologie;
    private Fisioterapista fisioterapista;

    public Struttura(TypeStrutture tipoStruttura) {
        this.tipoStruttura = tipoStruttura;
        listaPatologie = new HashSet<Patologia>();
    }

    public boolean addFisioterapista(Fisioterapista f){
        if (fisioterapista == null){
            this.fisioterapista = f;
            return true;
        } else{
            return false;
        }
    }

    public boolean addPatologia(Patologia p){
        if(listaPatologie.add(p)){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public String toString() {
        String descrizione = tipoStruttura + "\n";
        for (Patologia p : listaPatologie) {
            descrizione = descrizione + p.toString() +"\t";
        }
        descrizione = descrizione + "\n" + "Fisioterapista: " + fisioterapista.getNome() + " " + fisioterapista.getCognome() + "\n";
        return  descrizione;
    }

    public boolean isCured(TypePatologie p){
        for (Patologia patologia : listaPatologie) {
            if (patologia.getTipoPatologia().equals(p)){
                return true;
            }
        }
        return false;
    }

    public TypeStrutture getTipoStruttura() {
        return tipoStruttura;
    }

    public Fisioterapista getFisioterapista() {
        return fisioterapista;
    }
}
