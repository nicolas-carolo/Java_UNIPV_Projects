import java.util.ArrayList;

public abstract class Conto implements Operazioni {
    protected String cf;
    protected String iban;
    protected double saldo;
    protected TipoConto tc;
    private final int NUM_MAX = 10;
    private ArrayList<Accountable> arrayAccountable;


    public Conto(String cf, String iban) {
        this.cf = cf;
        this.iban = iban;
        this.saldo = 0;
        this.tc = null;
        this.arrayAccountable = new ArrayList<>(NUM_MAX);
    }

    public boolean addAccountable(Accountable acc){
        if ((this instanceof ContoDeposito) && (acc.accountable == AccountableType.ADDEBITO)) {
            return false;
        } else {
            arrayAccountable.add(acc);
            return true;
        }
    }

    public void fineMese(){
        double somma = 0;
        for(Accountable var : arrayAccountable){
            if (var.accountable == AccountableType.ACCREDITO) {
                somma = somma + var.importo;
            } else {
                somma = somma - var.importo;
            }
        }

        if (saldo + somma < 0){
            System.out.println("Iban " + iban + ": Il credito è insufficiente per portare a termine le transazioni!\n");
            //return false;
        } else {
            this.saldo = this.saldo + somma;
            System.out.println(this.toString());
            System.out.println("");
            //return true;
        }
    }

    @Override
    public String toString(){
            return "CF: " + cf +"\nIBAN: " + iban + "\nSaldo: " + saldo + "\nTipo di conto: " + tc;
    }
}
