public class ContoCorrente extends Conto {
    public ContoCorrente(String cf, String iban) {
        super(cf, iban);
        tc = TipoConto.CORRENTE;
    }

    public boolean preleva(double prelievo){
        //esegue il prelievo
        if (prelievo <= saldo) {
            saldo = saldo - prelievo;
            return true;
        } else {
            return false;
        }
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
