import java.util.HashMap;

public abstract class Camera {
    final int COSTOFISSO = 100;
    protected int id;
    protected int capienza;
    protected double metratura;
    protected String intestatario;
    protected int numeroOccupanti = 0;
    protected HashMap<TypeServizio, Servizio> mappaServizi = new HashMap<TypeServizio, Servizio>();
    protected HashMap<Integer, Double> mappaCanoniMensili = new HashMap<Integer, Double>();

    public abstract String toString();

    public Camera(int id, int capienza, double metratura) {
    }

    public double getCostoServizi(){
        double costoServizi = 0;
        for (TypeServizio ts : mappaServizi.keySet()) {
            costoServizi = costoServizi + mappaServizi.get(ts).canone;
        }
        return costoServizi;
    }

    public double getCostoTotale(){
        double totale = 100;
        if (this instanceof CameraSemplice){
            totale = totale + metratura * 8;
        } else{
            totale = totale + metratura * 10;
        }
        totale = totale + this.getCostoServizi();
        return totale;
    }

    public void setLastElementMappaCanoniMensili(Integer key, Double value){
        this.mappaCanoniMensili.put(key, value);
    }

    public int getSizeMappaCanoniMensili(){
        return this.mappaCanoniMensili.size();
    }
}
