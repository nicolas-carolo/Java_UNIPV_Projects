public class Test {
    public static void main(String[] args) {
        Ristorante tavolaAmica = new Ristorante("Tavola Amica");
        //tavolaAmica.add(new Carne("coscia di pollo", "pollo", "coscia"), 7);
        //tavolaAmica.printMenu();

        Menu provaMenu = new Menu();
        Alimento coscia = new Carne("coscia di pollo", "pollo", "coscia");
        ElementoMenu primoPiatto = new ElementoMenu(coscia, 5.0);
        provaMenu.add(primoPiatto);
        //System.out.println(primoPiatto.toString());

        Alimento pinot = new Vino("pinot", 12.0, "frizzante", "bianco");
        ElementoMenu drink = new ElementoMenu(pinot, 8.0);
        //System.out.println("\n" + drink.toString());
        provaMenu.add(drink);
        //provaMenu.printMenu();

        System.out.println("UNO");

        tavolaAmica.add(pinot, 7);
        tavolaAmica.add(coscia, 5);
        tavolaAmica.printMenu();

        System.out.println("DUE");

        tavolaAmica.remove(coscia, 5);
        tavolaAmica.printMenu();

        System.out.println("TRE");

        tavolaAmica.remove(pinot, 8);
        tavolaAmica.printMenu();

        System.out.println("QUATTRO");

        tavolaAmica.add(coscia, 5);
        tavolaAmica.add(coscia, 6);
        tavolaAmica.printMenu();

        System.out.println("CINQUE");

        tavolaAmica.remove(coscia, 5);
        tavolaAmica.printMenu();

        System.out.println("PROVA FILE RISTORANTE");
        Ristorante platano = new Ristorante("Platano");
        platano.addFromFile("/Users/nicolas/Desktop/menu1.txt");
        platano.printMenu();

        System.out.println("PROVA FILE RISTORANTE BIO");
        Ristorante ristoBio = new RistoranteBio("RistoBio");
        ristoBio.addFromFile("/Users/nicolas/Desktop/menu1.txt");
        ristoBio.printMenu();

        System.out.println("PROVA FILE ENOTECA");
        Enoteca vinaccio = new Enoteca("Vinaccio");
        vinaccio.addFromFile("/Users/nicolas/Desktop/menu1.txt");
        vinaccio.printMenu();

        System.out.println("PROVA FILE ENOTECA BIO");
        EnotecaBio soloVinoBio = new EnotecaBio("Solo Vino Bio");
        soloVinoBio.addFromFile("/Users/nicolas/Desktop/menu1.txt");
        soloVinoBio.printMenu();
    }
}
