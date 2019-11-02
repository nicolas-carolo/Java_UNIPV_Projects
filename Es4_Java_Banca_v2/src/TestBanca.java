public class TestBanca {
    public static void main(String[] args) {
        //crea una nuova banca di nome bpm
        Banca bpm = new Banca("bpm", "ITBPM");
        //crea tre nuovi conti in bpm (uno per ogni tipologia
        bpm.newConto("ABCDEF96", TipoConto.CORRENTE);
        bpm.newConto("YGYUES92", TipoConto.WEB);
        bpm.newConto("MNOPQR45", TipoConto.DEPOSITO);
        //stampa le informazioni su alcuni conti
        bpm.printInfoConto("ITBPMYGYUES922");
        bpm.printInfoConto("ITBPMABCDEF961");
        //esegue un'operazione di versamento su un conto
        bpm.operazione("ITBPMABCDEF961", 20);
        //stampa le informazioni sul primo conto aperto
        bpm.printInfoConto("ITBPMABCDEF961");
        //esegue un'operazione di versamento su un conto web e verifica che
        //non è possibile in quanto non è stata ancora cambiata la password di default
        bpm.operazione("ITBPMYGYUES922", 40);
        //stampa le informazioni sul secondo conto aperto
        bpm.printInfoConto("ITBPMYGYUES922");
        bpm.printInfoConto("ITBPMMNOPQR453");
        bpm.operazione("ITBPMMNOPQR453", 440);
        bpm.printInfoConto("ITBPMMNOPQR453");
        //esegue un'operazione di prelievo sul conto deposito...
        bpm.operazione("ITBPMMNOPQR453", -40);
        System.out.println("");
        //...e verifico che l'operazione sia stata impedita
        bpm.printInfoConto("ITBPMMNOPQR453");
        //provo un login su un conto web
        bpm.login("ITBPMYGYUES922", "changeme");
        //cambio la password di default
        bpm.changePwd("ITBPMYGYUES922", "changeme", "nuovapwd");
        //provo a loggarmi con la vecchia password e verifico che non funzioni
        bpm.login("ITBPMYGYUES922", "changeme");
        //mi loggo con la nuova password
        bpm.login("ITBPMYGYUES922", "nuovapwd");
        //verifico che sia impossibile loggarsi in un conto di tipo diverso da conto web
        bpm.login("ITBPMABCDEF961", "changeme");

        System.out.println("\nTEST CONTO WEB");
        bpm.newConto("WEBABC12", TipoConto.WEB);
        bpm.login("ITBPMWEBABC124","adf");
        bpm.login("ITBPMWEBABC124","changeme");
        bpm.operazione("ITBPMWEBABC124", 1000);
        bpm.operazione("ITBPMWEBABC124", -500);
        bpm.changePwd("ITBPMWEBABC124", "changeme", "nuova");
        bpm.operazione("ITBPMWEBABC124", 1000);
        bpm.operazione("ITBPMWEBABC124", -500);
        System.out.println("");
        bpm.printInfoConto("ITBPMWEBABC124");
        bpm.operazione("ITBPMWEBABC124", -600);
        bpm.printInfoConto("ITBPMWEBABC124");

        System.out.println("\nPUNTO DELLA SITUAZIONE\n");
        bpm.printInfoConto("ITBPMABCDEF961");
        bpm.printInfoConto("ITBPMYGYUES922");
        bpm.printInfoConto("ITBPMMNOPQR453");

        //eseguo alcuni test sugli accountable
        System.out.println("\nACCOUNTABLE");
        //aggiungo un abbonamento Sky ad un conto corrente su cui non ci sono soldi
        bpm.addAccountable("ITBPMABCDEF961",new AbbonamentoSky(70.0, AccountableType.ADDEBITO));
        //aggiungo uno stipendio ad un conto web
        bpm.addAccountable("ITBPMYGYUES922", new Stipendio(1000.0, AccountableType.ACCREDITO));
        bpm.addAccountable("ITBPMYGYUES922", new Stipendio(1.0, AccountableType.ADDEBITO));
        //aggiungo uno stipendio ad un conto deposito
        bpm.addAccountable("ITBPMMNOPQR453", new Stipendio(500.0, AccountableType.ACCREDITO));
        //aggiungo un abbonamento Sky ad un conto deposito e otterrò un messaggio di errore
        bpm.addAccountable("ITBPMMNOPQR453", new AbbonamentoSky(50, AccountableType.ADDEBITO));
        System.out.println("\nFINE MESE");
        bpm.fineMese();
    }
}
