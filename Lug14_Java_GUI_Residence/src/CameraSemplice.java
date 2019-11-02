public class CameraSemplice extends Camera {
    public CameraSemplice(int id, int capienza, double metratura) {
        super(id, capienza, metratura);
        this.id = id;
        this.capienza = capienza;
        this.metratura = metratura;
    }

    @Override
    public String toString() {
        if (numeroOccupanti == 0){
            return "id: " + id + "\tcapienza: " + capienza + "\tmetratura: " + metratura + "\tstato: libera";
        } else {
            return "id: " + id + "\tcapienza: " + capienza + "\tmetratura: " + metratura + "\tintestatario: "
                    + intestatario + "\tnumero occupanti: " + numeroOccupanti;
        }
    }
}
