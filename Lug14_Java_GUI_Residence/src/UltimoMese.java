public class UltimoMese extends Servizio {
    public UltimoMese(Camera c) {
        if (c instanceof CameraSemplice){
            this.canone = 100;
        } else{
            this.canone = 200;
        }
    }
}
