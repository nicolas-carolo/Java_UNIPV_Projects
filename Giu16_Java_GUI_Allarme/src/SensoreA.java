import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
public class SensoreA extends Sensore {
    private String grandezzaFisica;
    private int minValue;
    private int maxValue;
    private int maxCasuale;

    public SensoreA(String nomeSensore, int minValue, int maxValue, String grandezzaFisica) {
        super(nomeSensore);
        if (maxValue < minValue){
           this.maxValue = minValue;
           this.minValue = maxValue;
        } else{
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        this.grandezzaFisica = grandezzaFisica;
        this.maxCasuale = (int)(maxValue * 1.30);
    }

    @Override
    public int generaEvento() {
        return new Random().nextInt(maxCasuale);
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public String smsAllarme(){
        GregorianCalendar gc = new GregorianCalendar();
        int anno = gc.get(Calendar.YEAR);
        int mese = gc.get(Calendar.MONTH) + 1;
        int giorno = gc.get(Calendar.DATE);
        String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

        return nomeSensore + " " + giorno + "/" + mese + "/" + anno + " " + time + ":\tValori normali: " + " MIN: " + minValue + " MAX: " + maxValue + "\tValore registrato: ";
    }

    @Override
    public String toString() {
        return "nome sensore: " + nomeSensore + "\tnumero porta: A" + numeroPorta + "\tgrandezza fisica: "
                + grandezzaFisica + "\tvalore min: " + minValue + "\tvalore max: " + maxValue;
    }
}