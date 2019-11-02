public class Pulizie extends Servizio {

    public Pulizie(Camera c) {
        this.canone = 1 * c.metratura + 5 * c.numeroOccupanti;
        if (c instanceof Studio){
            this.canone = this.canone + 10;
        }
    }
}
