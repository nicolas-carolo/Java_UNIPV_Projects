import javax.swing.*;

public class TestResidence extends JFrame {
    public static void main(String[] args) throws OccupantiOutOfBoundsExeption, NotFreeCameraExeption {
        Residence residence = new Residence("/Users/nicolas/Documents/unipv/java/residence/struttura1.txt");
        residence.printCamere();
        residence.nuovoContratto(1, "Topolino", 1);
        residence.nuovoContratto(1, "Topolina", 4);
        residence.nuovoContratto(2, "Pippo", 3);
        residence.nuovoContratto(2, "Pippo", 2);
        residence.printCamere();
        residence.modificaNumeroOccupanti(1, 2);
        residence.printCamere();
        residence.modificaNumeroOccupanti(1,3);
        residence.addService(1, TypeServizio.ARIACONDIZIONATA);
        residence.removeService(1, TypeServizio.WIFI);
        residence.addService(1, TypeServizio.ARIACONDIZIONATA);
        residence.addService(2, TypeServizio.WIFI);
        residence.getCostoCamera(1);
        residence.newMonth();
        residence.addService(1, TypeServizio.PULIZIE);
        residence.newMonth();
        residence.newMonth();
        residence.printRegistroCanoni(1);
        residence.printRegistroCanoni(2);
        CostoCameraGUI costoCameraGUI = new CostoCameraGUI(residence);
        costoCameraGUI.setVisible(true);
    }
}
