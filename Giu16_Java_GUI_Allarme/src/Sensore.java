public abstract class Sensore {
    protected String nomeSensore;
    protected int numeroPorta;

    public Sensore(String nomeSensore) {
        this.nomeSensore = nomeSensore;
    }

    public void setNumeroPorta(int numeroPorta){
        this.numeroPorta = numeroPorta;
    }

    public abstract int generaEvento();
}