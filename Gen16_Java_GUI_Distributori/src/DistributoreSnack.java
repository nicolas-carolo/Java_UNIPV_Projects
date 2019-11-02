import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DistributoreSnack extends Distributore {
    private HashMap<String, Cassetto> listaSnack;

    public DistributoreSnack(String nomeFile) {
        this.listaSnack = new HashMap<String, Cassetto>();
        addSnackFromFile(nomeFile);
    }

    public void ricaricaDistributore(){
        listaSnack.forEach((key, value) -> {
            Cassetto c = listaSnack.get(key);
            c.riempiCassetto();
        });
    }

    public ArrayList<String> printListaProdotti(){
        ArrayList<String> arrayString = new ArrayList<String>();
        listaSnack.forEach((key, value) -> {
            Cassetto c = listaSnack.get(key);
            arrayString.add(c.toString());
        });
        return arrayString;
    }

    public ArrayList<String> printListaProdottiEsauriti(){
        ArrayList<String> arrayString = new ArrayList<String>();
        listaSnack.forEach((key, value) -> {
            Cassetto c = listaSnack.get(key);
            if (c.getQuantita() == 0){
                arrayString.add(c.toString());
            }
        });
        return arrayString;
    }

    public ArrayList<String> printListaProdottiDisponibili(){
        ArrayList<String> arrayString = new ArrayList<String>();
        listaSnack.forEach((key, value) -> {
            Cassetto c = listaSnack.get(key);
            if (c.getQuantita() > 0){
                arrayString.add(c.toString());
            }
        });
        return arrayString;
    }

    public boolean acquistaProdotto(String cod){
        //calcolaBudget();
        //String cod = getCodiceProdotto();
        Cassetto c = listaSnack.get(cod);
        if (c == null){
            avviso = cod + ": prodotto inesistente!";
            restituisciBudget();
            return false;
        }

        if (budget >= c.getPrezzoProdotto()){
            if (!(c.prelevaSnack())){
                avviso = c.getSnack().cod + ": prodotto esaurito! Ritira le monete!";
                restituisciBudget();
                return false;
            }
            incasso = incasso + budget;
            budget = 0;
            avviso = "Erogo: " + cod;
            return true;
        } else {
            avviso = "Credito insufficiente per acquistare " + c.getSnack().cod + "! Ritira le monete!";
            restituisciBudget();
            return false;
        }
    }

    private boolean addSnackFromFile(String nomeFile){
        Scanner inputStream;
        try {
            inputStream = new Scanner(new File(nomeFile));
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
            return false;
        }

        while (inputStream.hasNextLine()){
            String riga = inputStream.nextLine();
            StringTokenizer token = new StringTokenizer(riga,"\t");
            String cod = token.nextToken();
            String nome = token.nextToken();
            double prezzo = Double.parseDouble(token.nextToken());
            Snack s = new Snack(cod, nome, prezzo);
            Cassetto c = new Cassetto(s);
            listaSnack.put(cod, c);
        }
        inputStream.close();
        return true;
    }
}
