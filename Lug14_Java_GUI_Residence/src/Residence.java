import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Residence {
    private HashMap<Integer, Camera> mappaCamere;
    private String toGUI = "";

    public Residence(String nomeFile) {
        mappaCamere = new HashMap<Integer, Camera>();
        addFromFile(nomeFile);
    }

    private boolean addFromFile(String nomeFile){
        Scanner inputStream;
        String riga;
        int id;
        String type;
        double metratura;
        int capienza;

        try{
            inputStream = new Scanner(new File(nomeFile));
        } catch (FileNotFoundException e){
            System.out.println("File non trovato!");
            return false;
        }
        while (inputStream.hasNextLine()){
            riga = inputStream.nextLine();
            StringTokenizer tokenRiga = new StringTokenizer(riga, "\t");
            id = Integer.parseInt(tokenRiga.nextToken());
            type = tokenRiga.nextToken();
            metratura = Double.parseDouble(tokenRiga.nextToken());
            capienza = Integer.parseInt(tokenRiga.nextToken());
            //System.out.println(id + " " + type + " " + metratura + " " + capienza);
            if (type.equals("A")){
                Studio s = new Studio(id, capienza, metratura);
                mappaCamere.put(id, s);
            } else{
                CameraSemplice cs = new CameraSemplice(id, capienza, metratura);
                mappaCamere.put(id, cs);
            }
        }
        return true;
    }

    public void printCamere(){
        for (Integer key : mappaCamere.keySet()) {
            System.out.println(mappaCamere.get(key).toString());
        }
    }

    public void nuovoContratto(int id, String cliente, int numeroOccupanti) throws NotFreeCameraExeption, OccupantiOutOfBoundsExeption {
        Camera c = mappaCamere.get(id);
        try{
            if (c.numeroOccupanti > 0){
                NotFreeCameraExeption ntce = new NotFreeCameraExeption();
                throw ntce;
            } else {
                c.intestatario = cliente;
                if (numeroOccupanti <= c.capienza){
                    c.numeroOccupanti = numeroOccupanti;
                    System.out.println("id " + id + ": Camera assegnata correttamente!");
                } else {
                    OccupantiOutOfBoundsExeption oe = new OccupantiOutOfBoundsExeption();
                    throw oe;
                }
            }
        } catch (NotFreeCameraExeption ntce){
            System.out.println("id " + id + ": Impossibile procedere con il contratto. La camera è già occupata!");
        } catch (OccupantiOutOfBoundsExeption oe){
            System.out.println("id " + id + ": Impossibile procedere con il contratto. Capienza massima superata!");
        }
    }

    public void modificaNumeroOccupanti(int id, int numeroOccupanti) throws OccupantiOutOfBoundsExeption{
        Camera c = mappaCamere.get(id);
        try{
            if (numeroOccupanti <= c.capienza){
                c.numeroOccupanti = numeroOccupanti;
                System.out.println("id " + id + ": Numero di occupanti modificato correttamente!");
            } else {
                OccupantiOutOfBoundsExeption oe = new OccupantiOutOfBoundsExeption();
                throw oe;
            }
        } catch (OccupantiOutOfBoundsExeption oe){
            System.out.println("id " + id + ": Impossibile aumentare il numero di occupanti. Capienza massima superata!");
        }
    }

    public boolean addService(int id, TypeServizio ts){
        Camera c = null;
        c = mappaCamere.get(id);
        if ((c == null) || (c.numeroOccupanti == 0)){
            System.out.println("id " + id + ": Camera inesistente o non abitata");
            return false;
        }
        Servizio s;
        switch (ts){
            case ARIACONDIZIONATA:
                s = new AriaCondizionata(c);
                break;
            case PULIZIE:
                s = new Pulizie(c);
                break;
            case TELEFONO:
                s = new Telefono();
                break;
            case TVSATELLITARE:
                s = new TVSatellitare();
                break;
            case ULTIMOMESE:
                s = new UltimoMese(c);
                break;
            case WIFI:
                s = new WiFi(c);
                break;
            default:
                System.out.println("Servizio inesistente!");
                return false;
        }
        if (!(c.mappaServizi.containsKey(ts))) {
            c.mappaServizi.put(ts, s);
            System.out.println("id " + id + ": Servizio aggiunto correttamente!");
            return true;
        }
        System.out.println("id " + id + ": Servizio già presente!");
        return false;
    }

    public boolean removeService(int id, TypeServizio ts){
        Camera c;
        c = mappaCamere.get(id);
        if ((c == null) || (c.numeroOccupanti == 0)){
            System.out.println("id " + id + ": Camera inesistente o non abitata");
            return false;
        }
        Servizio s;
        switch (ts){
            case ARIACONDIZIONATA:
                s = new AriaCondizionata(c);
                break;
            case PULIZIE:
                s = new Pulizie(c);
                break;
            case TELEFONO:
                s = new Telefono();
                break;
            case TVSATELLITARE:
                s = new TVSatellitare();
                break;
            case ULTIMOMESE:
                s = new UltimoMese(c);
                break;
            case WIFI:
                s = new WiFi(c);
                break;
            default:
                System.out.println("Servizio inesistente!");
                return false;
        }
        if (c.mappaServizi.containsKey(ts)){
            c.mappaServizi.remove(ts);
            System.out.println("id " + id + ": Servizio rimosso correttamente!");
            return true;
        } else{
            System.out.println("id " + id + ": Servizio inesistente!");
            return false;
        }
    }

    public boolean getCostoCamera(int id){
        Camera c = null;
        c = mappaCamere.get(id);
        if ((c == null) || (c.numeroOccupanti == 0)){
            System.out.println("id " + id + ": Camera inesistente o non abitata");
            return false;
        }
        System.out.println("id " + id + ": costo totale = " + c.getCostoTotale());
        toGUI = Double.toString(c.getCostoTotale());
        c.getCostoTotale();
        return true;
    }

    public void newMonth(){
        for (Integer key: mappaCamere.keySet()) {
            if (mappaCamere.get(key).numeroOccupanti > 0){
                Integer mese = mappaCamere.get(key).getSizeMappaCanoniMensili();
                Double canone = mappaCamere.get(key).getCostoTotale();
                mappaCamere.get(key).setLastElementMappaCanoniMensili(mese, canone);
            }
        }
    }

    public void printRegistroCanoni(int id){
        Camera c = mappaCamere.get(id);
        if(c.numeroOccupanti > 0){
            System.out.println("Registro canoni mensili di id: " + id);
            for (Integer mese : c.mappaCanoniMensili.keySet()) {
                System.out.println("mese: " + (mese + 1) + "\tcanone: " + c.mappaCanoniMensili.get(mese));
            }
        }
    }

    public String getCostoCameraGUI(int id){
        if (getCostoCamera(id)){
            return toGUI;
        }
        return "N.D.";
    }
}
