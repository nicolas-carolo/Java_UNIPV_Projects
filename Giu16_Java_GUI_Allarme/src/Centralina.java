import java.util.ArrayList;

public class Centralina {
    final int MAXNUMSENSORI = 5;
    final int MAXNUMREGISTRO = 10;
    private SensoreA[] portaA = new SensoreA[MAXNUMSENSORI];
    private SensoreB[] portaB = new SensoreB[MAXNUMSENSORI];
    private int numeroA = 0;
    private int numeroB = 0;
    private String numeroTelefono = "";
    private ArrayList<String> registroAllarmi;

    public Centralina(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
        this.registroAllarmi = new ArrayList<String>(10);
    }

    public boolean addSensore(Sensore s){
        if ((s instanceof SensoreA) && (numeroA < MAXNUMSENSORI)){
            numeroA++;
            portaA[numeroA - 1] = (SensoreA)s;
            portaA[numeroA - 1].setNumeroPorta(numeroA);
            return true;
        } else if ((s instanceof SensoreB) && (numeroB < MAXNUMSENSORI)){
            numeroB++;
            portaB[numeroB - 1] = (SensoreB)s;
            portaB[numeroB - 1].setNumeroPorta(numeroB);
            return true;
        } else{
            System.out.println("Impossibile associare il sensore alla centralina!");
            return false;
        }
    }

    public boolean readSensors(){
       int i;
       int inputSensore;

       if (!(this.isEnabled())){
           System.out.println("Centralina non abilitata!");
           return false;
       }

       for (i = 0; i < numeroA; i++){
           inputSensore = portaA[i].generaEvento();
           if (inputSensore < portaA[i].getMinValue() || inputSensore > portaA[i].getMaxValue()){
               System.out.println(portaA[i].smsAllarme() + inputSensore);
               registroAllarmi.add(portaA[i].smsAllarme() + inputSensore);
           }
       }
        for (i = 0; i < numeroB; i++){
            inputSensore = portaB[i].generaEvento();
            if (inputSensore == 1){
                System.out.println(portaB[i].smsAllarme());
                registroAllarmi.add(portaB[i].smsAllarme());
            }
        }
        return true;
    }

    public boolean isEnabled(){
        if ((!(numeroTelefono.equals(""))) && ((numeroA > 0) || (numeroB > 0))){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public String toString() {
        String toPrint = "";
        int i;
        for (i = 0; i < numeroA; i++){
            toPrint = toPrint + portaA[i].toString() + "\n";
        }
        for (i = 0; i < numeroB; i++){
            toPrint = toPrint + portaB[i].toString() + "\n";
        }
        return toPrint;
    }

    public String printRegistroAllarmi(){
        String strRet = "";
        if (registroAllarmi.size() <= MAXNUMREGISTRO){
            for (String allarme : registroAllarmi) {
                System.out.println(allarme);
                strRet = strRet + allarme + "\n";
            }
        } else {
            int i;
            int iStart = registroAllarmi.size() - MAXNUMREGISTRO;
            for (i = iStart; i < registroAllarmi.size(); i++){
                System.out.println(registroAllarmi.get(i));
                strRet = strRet + registroAllarmi.get(i) + "\n";
            }
        }
        return strRet;
    }
}
