import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
public class SensoreB extends Sensore {
    private String eventoAnomalo;

    public SensoreB(String nomeSensore, String eventoAnomalo) {
        super(nomeSensore);
        this.eventoAnomalo = eventoAnomalo;
    }

    @Override
    public int generaEvento() {
        return new Random().nextInt(2);
    }

    public String smsAllarme() {
        GregorianCalendar gc = new GregorianCalendar();
        int anno = gc.get(Calendar.YEAR);
        int mese = gc.get(Calendar.MONTH) + 1;
        int giorno = gc.get(Calendar.DATE);

        String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

        return nomeSensore + " " + giorno + "/" + mese + "/" + anno + " " + time + ":\t" + eventoAnomalo;
    }

    @Override
    public String toString() {
        return "nome sensore: " + nomeSensore + "\tnumero porta: B" + numeroPorta;
    }
}