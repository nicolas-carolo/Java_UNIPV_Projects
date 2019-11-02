import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //crea le forme v1, v2, v3 che formeranno vettoreImmagini
        ImgVect v1 = new ImgVect(10);
        v1.newForma(new Quadrato(Colore.BLACK, 3));
        v1.newForma(new Rettangolo(Colore.BLACK, 2, 3));
        v1.newForma(new Rettangolo(Colore.YELLOW, 2, 3));

        ImgVect v2 = new ImgVect(5);
        v2.newForma(new Quadrato(Colore.YELLOW, 10));
        v2.newForma(new Quadrato(Colore.YELLOW, 1));
        v2.newForma(new Quadrato(Colore.YELLOW, 2));

        ImgVect v3 = new ImgVect(5);
        v3.newForma(new Cerchio(Colore.YELLOW, 10));
        v3.newForma(new Cerchio(Colore.YELLOW, 200));
        v3.newForma(new Cerchio(Colore.YELLOW, 1));

        //crea e inizializza vettoreImmagini
        ImgVect[] vettoreImmagini = new ImgVect[3];
        vettoreImmagini[0] = v1;
        vettoreImmagini[1] = v2;
        vettoreImmagini[2] = v3;

        //esegue l'ordinamento per aree totali crescenti delle immagini vettoriali
        Arrays.sort(vettoreImmagini, 0, (vettoreImmagini.length - 1));
        for (ImgVect var: vettoreImmagini) {
            System.out.println(var.toString() + "area totale = " + var.areaImmagine() + "\n");
        }

    }
}
