public class Camion extends Veicolo {
    private double carico;
    private double caricoRimorchio;

    public Camion(String nome, int nCilindri, Persona proprietario, double carico, double caricoRimorchio) {
        super(nome, nCilindri, proprietario);
        this.carico = carico;
        this.caricoRimorchio = caricoRimorchio;
    }

    public double getCarico() {
        return carico;
    }

    public double getCaricoRimorchio() {
        return caricoRimorchio;
    }

    public boolean equals(Camion c) {
        if (this.carico == c.carico && this.caricoRimorchio == c.caricoRimorchio) {
            return true;
        }

        return false;
    }
}
