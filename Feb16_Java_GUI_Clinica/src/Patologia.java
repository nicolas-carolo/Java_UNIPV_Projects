public class Patologia {
    private TypePatologie tipoPatologia;

    public Patologia(TypePatologie tipoPatologia) {
        this.tipoPatologia = tipoPatologia;
    }

    @Override
    public String toString() {
        return tipoPatologia.toString();
    }

    public TypePatologie getTipoPatologia() {
        return tipoPatologia;
    }
}
