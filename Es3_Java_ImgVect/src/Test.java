import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println("EREDITARIETA'");
        //crea forme
        Forma q1 = new Quadrato(Colore.BLACK, 2.0);
        System.out.println(q1);
        Forma c1 = new Cerchio(Colore.YELLOW, 3.0);
        System.out.println(c1);
        Forma r1 = new Rettangolo(Colore.RED, 4.0, 3.0);
        System.out.println(r1);

       //esegue alcuni calcoli
        System.out.println(q1.perimetro());
        System.out.println(q1.area());
        System.out.println(c1.perimetro());
        System.out.println(c1.area());
        System.out.println(r1.perimetro());
        System.out.println(r1.area());

        System.out.println("POLIMORFISMO");

        ImgVect v = new ImgVect(10);
        v.newForma(new Quadrato(Colore.BLACK, 3));
        v.newForma(new Rettangolo(Colore.BLACK, 2, 3));
        v.newForma(new Rettangolo(Colore.YELLOW, 2, 3));
        System.out.println("area totale:" + v.areaImmagine());
        System.out.println("area totale nera:" + v.areaImmagineColore(Colore.BLACK));
        System.out.println("info: " + v.toString());

        System.out.println("INTERFACCE");

        ImgVect v2 = new ImgVect(5);
        v2.newForma(new Quadrato(Colore.YELLOW, 10));
        v2.newForma(new Quadrato(Colore.YELLOW, 1));
        v2.newForma(new Quadrato(Colore.YELLOW, 2));

        ImgVect v3 = new ImgVect(5);
        v3.newForma(new Cerchio(Colore.YELLOW, 10));
        v3.newForma(new Cerchio(Colore.YELLOW, 200));
        v3.newForma(new Cerchio(Colore.YELLOW, 1));

        Arrays.sort(v2.getImmagine(), 0, v2.getNumForme());
        System.out.println(v2.toString());

        Arrays.sort(v3.getImmagine(), 0, v3.getNumForme());
        System.out.println(v3.toString());

    }
}
