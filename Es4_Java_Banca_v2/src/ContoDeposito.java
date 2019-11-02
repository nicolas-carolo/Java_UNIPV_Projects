public class ContoDeposito extends Conto {
    public ContoDeposito(String cf, String iban) {
        super(cf, iban);
        tc = TipoConto.DEPOSITO;
    }

    public boolean preleva(double prelievo){
        //impedisce di eseguire un prelievo
        System.out.println("Iban " + iban + ": Impossibile eseguire un prelievo poiché si tratta di un conto deposito!");
        return false;
    }

    public boolean deposita(double versamento){
        //esegue un versamento
        saldo = saldo + versamento;
        return true;
    }

    public double getSaldo(){
        return saldo;
    }
}
