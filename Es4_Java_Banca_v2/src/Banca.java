import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class Banca {
    private String nomeBanca;
    private String NomeBanca, radiceIban;
    private final int NUM_MAX = 10;
    private int contiAttivi;
    //Chiave = iban, Valore = Conto
    private Map<String, Conto> mapConti;

    public Banca(String nomeBanca, String radiceIban) {
        this.nomeBanca = nomeBanca;
        this.radiceIban = radiceIban;
        this.contiAttivi = 0;
        this.mapConti = new HashMap<String, Conto>(NUM_MAX);
    }

    public void newConto(String cf, TipoConto tc) {
        String iban = radiceIban + cf + (contiAttivi + 1);
        Conto c = null;
        switch (tc) {

            case CORRENTE:
                c  = new ContoCorrente(cf, iban);
                break;
            case WEB:
                c = new ContoWeb(cf, iban);
                break;
            case DEPOSITO:
                c = new ContoDeposito(cf, iban);
                break;
        }

        mapConti.put(iban, c);

        contiAttivi++;
    }

    public void printInfoConto(String iban){
        //stampa le informazioni relative al conto corrispondente all'iban passato come parametro
        System.out.println(mapConti.get(iban) + "\n");
    }

    public int operazione(String iban, double somma){
        Conto c = null;
        c = mapConti.get(iban);
        //verifica che c sia istanziato correttamente e che sia un elemento della mappa
        if (!(c instanceof Conto)){
            System.out.println("Conto non trovato!");
            return -1;
        }
        //effettua un prelievo o un deposito a seconda che il valore passato sia negativo o positivo
        if (somma < 0) {
            somma = -somma;
            c.preleva(somma);
            return 0;
        }
        if (somma > 0){
            c.deposita(somma);
        }
        return 0;
    }

    public boolean login(String iban, String password){
        //funzione di login
        //c viene inizializzato con l'elemento della mappa referenziato da iban
        Conto c = mapConti.get(iban);
        //se c non è un conto di tipo web, restituisce un errore...
        if (!(c instanceof ContoWeb)){
            System.out.println("Iban " + iban + ": Non si tratta di un conto web!");
            return false;
        }
        //...altrimenti fa un tentativo di login
        ContoWeb cw = (ContoWeb)c;
        if (password == cw.getPwd()){
            System.out.println("Iban " + iban + ": Accesso consentito!");
            return true;
        }
            System.out.println("Iban " + iban + ": Accesso negato!");
        return false;
    }

    public boolean changePwd(String iban, String password, String newPwd){
        //c viene inizializzato con l'elemento della mappa referenziato da iban
        Conto c = mapConti.get(iban);
        //se c non è un conto di tipo web, restituisce un errore...
        if (!(c instanceof ContoWeb)){
            System.out.println("Iban " + iban + ": Non si tratta di un conto web!");
            return false;
        }
        //eseguo un cast di c da Conto a ContoWeb
        ContoWeb cw = (ContoWeb)c;
        //...altrimenti, se la password attuale passata come parametro e la password attuale corrispondono...
        if (password == cw.getPwd()){
            //...cambia la password con la nuova passata come parametro
            cw.changePwd(newPwd);
            return true;
        }
        //...se la password attuale inserita dall'utente è errata, restituisce un messaggio di errore
        System.out.println("Iban " + iban + ": Password attuale errata!");
        return false;
    }

    public boolean addAccountable(String iban, Accountable acc){
        //funzione per l'aggiunta di un accountable
        Conto c = null;
        //inizializza c con l'elemento della mappa referenziato da iban
        c = mapConti.get(iban);
        //se l'elemento cercato è inesistente restituisce un errore
        if (c == null){
            System.out.println("Iban " + iban + ": Conto non esistente!");
            return false;
        }
        //se il conto è di tipo deposito impedice di eseguire degli addebiti, ma consente gli accrediti
        if (!(c.addAccountable(acc))){
            System.out.println("Iban " + c.iban + ": Impossibile prelevare soldi da un conto deposito!");
        }
        return true;
    }

    public void fineMese(){
        //chiama la funzione fineMese associata a tutti i conti correnti
        for (Conto var : mapConti.values()){
            var.fineMese();
        }
    }
}
