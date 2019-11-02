public class InkJetPrinter {
    private final int MAXLEVEL = 1000;
    private final int NUMCOLOR = 4;
    private int[] cartridge = new int[NUMCOLOR];

    public InkJetPrinter() {
        //chiamata alla funzione di inizializzazione delle cartucce
        this.initCartridges();
    }

    private void initCartridges(){
        //inizializza le cartucce al valore iniziale MAXLEVEL
        for (Colore var : Colore.values()) {
            this.cartridge[var.ordinal()] = MAXLEVEL;
        }
    }

    public void changeCartridges(Colore color) {
        //esegue il cambio della cartuccia del colore specificato nel parametro passato alla funzione
        cartridge[color.ordinal()] = MAXLEVEL;
        System.out.println(color.name() + " caricato!");
    }

    public void showCartridgesLevel() {
        //mostra il livello delle cartucce
        System.out.println("Livello colori:");
        for (Colore var : Colore.values()) {
            System.out.println(var.name() + " = " + cartridge[var.ordinal()]);
        }
    }

    public boolean checkCartridgesLevel(ImgVect immagine) {
        //verifica che sia possibile procedere con la stampa dell'immagine specificata nel parametro della funzione
        int[] prevColor = new int[NUMCOLOR];
        for (Colore var : Colore.values()) {
            prevColor[var.ordinal()] = cartridge[var.ordinal()];
        }

        for (Colore var : Colore.values()) {
            prevColor[var.ordinal()] = this.cartridge[var.ordinal()] - (int)immagine.areaImmagineColore(Colore.valueOf(var.name()));
        }

        if (prevColor[0] < 0 || prevColor[1] < 0 || prevColor[2] < 0 || prevColor[3] < 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public void stampa(ImgVect immagine){
        //stampa l'immagine vettoriale specificata nel parametro della funzione di stampa
        if (this.checkCartridgesLevel(immagine)) {
            for (Colore var : Colore.values()) {
                this.cartridge[var.ordinal()] = this.cartridge[var.ordinal()] - (int)immagine.areaImmagineColore(Colore.valueOf(var.name()));
            }
            System.out.println("Stampa in corso...\nStampa eseguita!");
            this.showCartridgesLevel();
        } else {
            System.out.println("Colori insufficienti per eseguire la stampa!");
        }

    }

}
