import sun.util.resources.cldr.mfe.CalendarData_mfe_MU;

public class Driver {
    public static void main(String[] args) {
        //test classe persona
        Persona p1 = new Persona("Giuseppe");
        Persona p2 = new Persona("Giacomo");
        Persona p3 = new Persona("Giacomo");
        Persona p4 = new Persona("Giuseppe");

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p4));

        System.out.println("**************************************");

        //test superclasse veicolo
        Veicolo v1 = new Veicolo("bmw", 6, p1);
        Veicolo v2 = new Veicolo("mercedes", 4, p2);
        Veicolo v3 = new Veicolo("ferrari", 8, p2);
        Veicolo v4 = new Veicolo("bmw", 4, p3);
        Veicolo v5 = new Veicolo("mercedes", 12, p4);
        Veicolo v6 = new Veicolo("ferrari", 12, p1);
        Veicolo v7 = new Veicolo("ferrari", 12, p1);

        System.out.println(v1.equals(v2));
        System.out.println(v2.equals(v3));
        System.out.println(v3.equals(v4));
        System.out.println(v4.equals(v5));
        System.out.println(v5.equals(v6));
        System.out.println(v6.equals(v7));
        System.out.println(v7.equals(v1));

        System.out.println("**************************************");

        //test sottoclasse camion
        Camion c1 = new Camion("mercedes", 12, p1, 2000.0, 2000.0);
        Camion c2 = new Camion("mercedes", 12, p1, 2000.0, 2000.0);
        Camion c3 = new Camion("bmw", 12, p2, 1000.0, 1500.0);
        System.out.println(c1.equals(c2));
        System.out.println(c2.equals(c3));

    }
}
