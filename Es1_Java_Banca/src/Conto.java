public class Conto {
    private String Iban, Cf;
    private Double Saldo;

    public Conto(String iban, String cf) {
        Iban = iban;
        Cf = cf;
    }

    public boolean preleva(double prelievo) {
        //prelievo
        if (prelievo <= Saldo) {
            Saldo = Saldo - prelievo;
            return true;
        } else {
            return false;
        }
    }

    public void setIban(String iban) {
        Iban = iban;
    }

    public void setCf(String cf) {
        Cf = cf;
    }

    public void setSaldo(Double saldo) {
        Saldo = saldo;
    }

    public String getIban() {
        return Iban;
    }

    public String getCf() {
        return Cf;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public boolean deposita(double versamento) {
        //versamento
        Saldo = Saldo + versamento;
        return true;
    }
}

