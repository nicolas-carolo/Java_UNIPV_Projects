public class TestPartita {
    public static void main(String[] args) {
//        Partita milanoCalcio = new PartitaCalcio("Inter", "Milan");
//        System.out.println(milanoCalcio.toString());
        PartitaVolley bustoVolley = new PartitaVolley("Busto", "Pavia");
//        milanoCalcio.startMatch();
//        milanoCalcio.puntoCasa();
//        milanoCalcio.puntoOspite();
//        milanoCalcio.puntoOspite();
//        milanoCalcio.puntoCasa();
//        //System.out.println("invalid start set: " + milanoCalcio.startSet());
//        System.out.println("valid stop set: " + milanoCalcio.stopSet());
//        //System.out.println("valid start set: " + milanoCalcio.startSet());
//        //System.out.println("invalid 2 stop set: " + milanoCalcio.stopSet());
//        //System.out.println("invalid 3 start set: " + milanoCalcio.startSet());
//        System.out.println(milanoCalcio.comment());
//        System.out.println(milanoCalcio.stopMatch());
//        System.out.println(milanoCalcio.toString());
//        //System.out.println("invalid start set: " + milanoCalcio.startSet());

        bustoVolley.startMatch();
        bustoVolley.addTimeOutOspite();
        bustoVolley.addTimeOutCasa();
        System.out.println(bustoVolley.toString());
        bustoVolley.startSet();
        bustoVolley.puntoOspite();
        System.out.println(bustoVolley.toString());
        bustoVolley.addTimeOutCasa();
        bustoVolley.addTimeOutOspite();
        System.out.println(bustoVolley.toString());
        bustoVolley.stopSet();
        bustoVolley.puntoCasa();
        System.out.println(bustoVolley.toString());
        bustoVolley.startSet();
        bustoVolley.puntoCasa();
        bustoVolley.stopSet();
        bustoVolley.stopMatch();
        System.out.println(bustoVolley.toString());
    }
}
