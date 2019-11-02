public class ImgVect implements Comparable<ImgVect>{
    private int maxForme;
    private int numForme;
    private Forma immagine[];

    public ImgVect(int maxForme) {
        this.maxForme = maxForme;
        this.numForme = 0;
        this.immagine = new Forma[maxForme];
    }

    public Boolean newForma(Forma f){
        //crea una nuova forma
        if (numForme < maxForme) {
            immagine[numForme] = f;
            numForme++;
            return true;
        } else {
            return false;
        }
    }

    public double areaImmagine(){
        //calcola l'area totale dell'immagine vettoriale
        double areaTot = 0;
        int i;
        for(i = 0; i < numForme; i++){
            areaTot = areaTot + immagine[i].area();
        }
        return areaTot;
    }

    public double areaImmagineColore(Colore c){
        //calcola l'area totale delle figure di un determinato colore
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

    public int compareTo(ImgVect v){
        //funzione di comparazione delle forme di un immagine per ordinamento in ordine crescente
        if (this.areaImmagine() < v.areaImmagine()) {
            return -1;
        } else if (this.areaImmagine() > v.areaImmagine()) {
            return  1;
        }
        return 0;
    }
}
