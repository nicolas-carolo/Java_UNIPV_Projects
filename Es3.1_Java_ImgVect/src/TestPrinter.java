public class TestPrinter {
    public static void main(String[] args) {
        System.out.println("CREA STAMPANTE HP");
        InkJetPrinter hp = new InkJetPrinter();

        System.out.println("\nMOSTRA IL LIVELLO COLORI DI HP");
        hp.showCartridgesLevel();

        //crea l'immagine vettoriale v1
        ImgVect v1 = new ImgVect(10);
        v1.newForma(new Quadrato(Colore.BLACK, 3));
        v1.newForma(new Rettangolo(Colore.BLACK, 2, 3));
        v1.newForma(new Rettangolo(Colore.YELLOW, 2, 3));

        System.out.println("");

        //esegue la stampa di v1
        hp.stampa(v1);

        System.out.println("\nSOSTITUZIONE CARTUCCIA DEL GIALLO");
        hp.changeCartridges(Colore.YELLOW);

        System.out.println("\nMOSTRA IL LIVELLO COLORI DI HP");
        hp.showCartridgesLevel();

        //crea l'immagine vettoriale v2
        ImgVect v2 = new ImgVect(10);
        v2.newForma(new Quadrato(Colore.BLACK, 100));

        //esegue la stampa di v2
        hp.stampa(v2);
    }
}
