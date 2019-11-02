import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DistributoreBevande extends Distributore {
    private double liofilizzato;    //in grammi
    private HashMap<String, Bevanda> listaBevande;

    public void ricaricaDistributore(){
        liofilizzato = 500;
    }

    public DistributoreBevande(String nomeFile) {
        this.liofilizzato = 500;
        this.listaBevande = new HashMap<String, Bevanda>();
        addBevandeFromFile(nomeFile);
    }

    public ArrayList<String> printListaProdotti(){
        ArrayList<String> arrayString = new ArrayList<String>();
        listaBevande.forEach((key, value) -> {
            Bevanda b = listaBevande.get(key);
            arrayString.add(b.toString());
        });
        return arrayString;
    }

    public ArrayList<String> printListaProdottiEsauriti(){
        ArrayList<String> arrayString = new ArrayList<String>();
        listaBevande.forEach((key, value) -> {
            Bevanda b = listaBevande.get(key);
            if (b.getPolvere() > liofilizzato){
                arrayString.add(b.toString());
            }
        });
        return arrayString;
    }

    public ArrayList<String> printListaProdottiDisponibili(){
        ArrayList<String> arrayString = new ArrayList<String>();
        listaBevande.forEach((key, value) -> {
            Bevanda b = listaBevande.get(key);
            if (b.getPolvere() <= liofilizzato){
                arrayString.add(b.toString());
            }
        });
        return arrayString;
    }

    public boolean acquistaProdotto(String cod){
        //calcolaBudget();
        //String cod = getCodiceProdotto();
        Bevanda b;
        b = listaBevande.get(cod);
        if (b == null){
            avviso = cod + ": prodotto inesistente!";
            restituisciBudget();
            return false;
        }
        if (budget >= b.prezzo){
            if (b.getPolvere() > liofilizzato){
                avviso = "Liofilizzato insufficiente per erogare " + b.cod + "! Ritira le monete";
                restituisciBudget();
                return false;
            }
            liofilizzato = liofilizzato - b.getPolvere();
            incasso = incasso + budget;
            budget = 0;
            avviso = "Erogo " + cod;
            return true;
        } else {
            avviso = "Credito insufficiente per acquistare " + b.cod + "! Ritira le monete!";
            restituisciBudget();
            return false;
        }
    }

    private boolean addBevandeFromFile(String nomeFile){
        Scanner inputStream;
        try {
            inputStream = new Scanner(new File(nomeFile));
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
            return false;
        }

        while (inputStream.hasNextLine()){
            String riga = inputStream.nextLine();
            StringTokenizer token = new StringTokenizer(riga, "\t");
            String cod = token.nextToken();
            double polvere = Double.parseDouble(token.nextToken());
            String nome = token.nextToken();
            double prezzo = Double.parseDouble(token.nextToken());
            Bevanda b = new Bevanda(cod, nome, prezzo, polvere);
            listaBevande.put(cod, b);
        }
        inputStream.close();
        return true;
    }

    public double getLiofilizzato() {
        return liofilizzato;
    }
}
