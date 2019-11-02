public class AriaCondizionata extends Servizio {

    public AriaCondizionata(Camera c) {
        if (c instanceof CameraSemplice){
            this.canone = 20;
        } else{
            this.canone = 30;
        }
    }
}
