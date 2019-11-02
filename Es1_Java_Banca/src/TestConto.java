public class TestConto {
    public static void main(String[] args) {
        //Conto c1 = new Conto("12345A", "PIPPO");
        //Conto c2 = new Conto("12345B", "PLUTO");
        //Conto c3 = new Conto("12345C", "PAPERINO");
        //Conto c4 = new Conto("12345D", "TOPOLINO");
        //Conto c5 = new Conto("12345E", "QUI");

        //crea una banca che puo' ospitare fino a 5 conti correnti
        Banca b1 = new Banca("Banca1", 5);

        //crea dei cotni in b1
        System.out.println(b1.newConto("12345", "ABCDEF12"));
        System.out.println(b1.newConto("67890", "GHIJKL34"));
        System.out.println(b1.newConto("54637", "ABCDFS12"));
        System.out.println(b1.newConto("93712", "GHIJGF17"));
        System.out.println(b1.newConto("25362", "ABCDFF52"));

        //stampa il saldo totale dei conti di b1
        System.out.println("Saldo totale = " + b1.totaleSaldi());

        //esegue delle operazioni di versamento su dei conti di b1
        System.out.println("Saldo = " + b1.operazione(500.0,"ABCDEF12"));
        System.out.println("Saldo = " + b1.operazione(540.0,"ABCDFS12"));
        System.out.println("Saldo = " + b1.operazione(100.1,"GHIJGF17"));

        //stampa il saldo totale dei conti di b1
        System.out.println("Saldo totale = " + b1.totaleSaldi());

        System.out.println("IBAN: " + b1.getConto("12345").getIban());
        System.out.println("Cf: " + b1.getConto("12345").getCf());
        System.out.println("Saldo: " + b1.getConto("12345").getSaldo());

        //crea una banca b2 che puo' ospitare fino a 10 conti correnti
        Banca b2 = new Banca("Banca2", 10);

        //crea alcuni conti in b2
        System.out.println(b2.newConto("12345", "ABCDEF12"));
        System.out.println(b2.newConto("67890", "GHIJKL34"));
        System.out.println(b2.newConto("54637", "ABCDFS12"));
        System.out.println(b2.newConto("93712", "GHIJGF17"));
        System.out.println(b2.newConto("25362", "ABCDFF52"));
        System.out.println(b2.newConto("52673", "GHIJGFH2"));
        System.out.println(b2.newConto("72362", "BCCDFF52"));

        //stampa il saldo totale dei conti di b2
        System.out.println("Saldo totale = " + b2.totaleSaldi());

        //esegue alcune operazioni di prelievo e versamento
        System.out.println("Saldo = " + b2.operazione(500.0,"ABCDFF52"));
        System.out.println("Saldo = " + b2.operazione(540.0,"GHIJKL34"));
        System.out.println("Saldo = " + b2.operazione(100.1,"ABCDEF12"));
        System.out.println("Saldo = " + b2.operazione(-140.1,"GHIJKL34"));

        //stampa il saldo totale dei conti di b2
        System.out.println("Saldo totale = " + b2.totaleSaldi());

        //chiama la funzione per mostrare un elenco dei conti aperti in b2 con le relative informazioni
        b2.getListConto();

    }
}
