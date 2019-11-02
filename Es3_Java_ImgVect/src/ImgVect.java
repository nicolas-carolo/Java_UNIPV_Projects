public class ImgVect {
    private int maxForme;
    private int numForme;
    private Forma immagine[];

    public ImgVect(int maxForme) {
        this.maxForme = maxForme;
        this.numForme = 0;
        this.immagine = new Forma[maxForme];
    }

    public Boolean newForma(Forma f){
            if (numForme < maxForme) {
                immagine[numForme] = f;
                numForme++;
                return true;
            } else {
                return false;
            }
    }

    public double areaImmagine(){
        double areaTot = 0;
        int i;
        for(i = 0; i < numForme; i++){
            areaTot = areaTot + immagine[i].area();
        }
        return areaTot;
    }

    public double areaImmagineColore(Colore c){
        double areaTot = 0;
        int i;
        for(i = 0; i < numForme; i++){
            if (immagine[i].getColor() == c) {
                areaTot = areaTot + immagine[i].area();
            }
        }
        return areaTot;
    }

    @Override
    public String toString() {
        int i;
        String strFinale = "";
        for(i = 0; i < numForme; i++){
           strFinale = strFinale + immagine[i].toString();
        }
        return strFinale;
    }

    public Forma[] getImmagine() {
        return immagine;
    }

    public int getNumForme() {
        return numForme;
    }
}
