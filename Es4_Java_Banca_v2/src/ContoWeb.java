public class ContoWeb extends ContoCorrente {
    private String pwd;
    private final String PWD_DEFAULT = "changeme";

    public ContoWeb(String cf, String iban) {
        super(cf, iban);
        this.pwd = PWD_DEFAULT;
        tc = TipoConto.WEB;
    }

    public boolean login(String word){
        if (!(checkPwd())){
            return false;
        }
        if (word.equals(pwd)) {
            System.out.println("Iban " + iban + ": Accesso eseguito!");
            return true;
        } else {
            System.out.println("Iban " + iban + ": Password errata. Accesso negato!");
            return  false;
        }
    }
    public boolean changePwd(String newPwd){
        //permette di cambiare la password associata ad un conto di tipo web
        pwd = newPwd;
        System.out.println("Iban " + iban + ": Password cambiata correttamente!");
        return true;
    }

    public boolean preleva(double prelievo){
        //esegue il prelievo solo se ci sono soldi a sufficienza e la password è diversa da quella di default
        if (prelievo <= saldo && checkPwd()) {
            saldo = saldo - prelievo;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposita(double versamento) {
        //esegue un versamento solo se la password è diversa da quella di default
        if (checkPwd()) {
            saldo = saldo + versamento;
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPwd(){
        //verifica che la password sia diversa da quella di default
        if (pwd.equals(PWD_DEFAULT)) {
            System.out.println("Iban " + iban + ": Cambiare la password prima di eseguire qualsiasi operazione!");
            return false;
        } else {
            return true;
        }
    }

    public String getPwd() {
        return pwd;
    }
}
