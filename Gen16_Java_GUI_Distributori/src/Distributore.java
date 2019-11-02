import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Distributore {
    protected double incasso;
    protected double budget;
    protected String avviso = "";

    public abstract void ricaricaDistributore();
    public abstract ArrayList<String> printListaProdotti();
    public abstract ArrayList<String> printListaProdottiEsauriti();
    public abstract ArrayList<String> printListaProdottiDisponibili();
    public abstract boolean acquistaProdotto(String cod);

    public double getIncasso(){
        return incasso;
    }

    public void svuotaMonete(){
        incasso = 0;
    }

    public void restituisciBudget(){
        budget = 0;
    }

    public Distributore() {
        this.incasso = 0;
        this.budget = 0;
    }

    public void ritiraIncassi(){
        incasso = 0;
    }

}
