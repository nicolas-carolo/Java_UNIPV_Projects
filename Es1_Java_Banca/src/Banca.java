public class Banca {
    private String nome, radiceIban;
    private int numMax;
    private int contiAttivi;
    private Conto[] conto;

    public String getNome() {
        return nome;
    }

    public Banca(String nome, int numMax) {
        this.nome = nome;
        this.numMax = numMax;
        this.conto = new Conto[numMax];
        contiAttivi = 0;
        radiceIban = "IT00000" + nome + "000";

    }

    public int newConto(String Iban, String Cf) {
        if (contiAttivi < numMax) {
            String totIban = radiceIban + Iban;
            conto[contiAttivi] = new Conto(totIban, Cf);
            conto[contiAttivi].setSaldo(0.0);
            contiAttivi++;
            return contiAttivi;
        } else {
            return -1;
        }
    }

    public double totaleSaldi() {
        double totale = 0;
        int i;
        for(i = 0; i < contiAttivi; i++) {
            totale = totale + conto[i].getSaldo();
        }
        return totale;
    }

    public double operazione(double somma, String Cf) {
        int i = 0;
        while(!(Cf.equals(conto[i].getCf()))) {
            i++;
            if (i > numMax) {
                return -1.0;
            }
        }

        if (somma < 0) {
            //preleva
            somma = -1 * somma;
            conto[i].preleva(somma);
        } else {
            //deposita
            conto[i].deposita(somma);
        }

        return conto[i].getSaldo();
    }

    public Conto getConto(String Iban) {
        int i = 0;
        String totIban = radiceIban + Iban;
        while(!(totIban.equals(conto[i].getIban()))) {
            i++;
        }
        return conto[i];
    }

    public void getListConto() {
        int i;
        for (i = 0; i < contiAttivi; i++) {
            String totIban = radiceIban + conto[i].getIban();
            System.out.println("IBAN: " + totIban);
            System.out.println("Cf: " + conto[i].getCf());
            System.out.println("Saldo: " + conto[i].getSaldo());
        }
    }
}
