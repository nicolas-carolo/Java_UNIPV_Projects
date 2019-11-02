import javax.swing.*;
import java.io.FileNotFoundException;

public class TestClinica extends JFrame {
    public static void main(String[] args) {
        //PUNTO 1
        Clinica clinica = new Clinica("Maugeri", 1, 5, 8, 17);

        //PUNTO 2
        Struttura palestra = new Struttura(TypeStrutture.PALESTRA);
        Struttura piscina = new Struttura(TypeStrutture.PISCINA);
        Struttura terme = new Struttura(TypeStrutture.TERME);
        Struttura salaMassaggi = new Struttura(TypeStrutture.SALAMASSAGGI);

        //assegna le patologie alle strutture
        palestra.addPatologia(new Patologia(TypePatologie.PATO1));
        palestra.addPatologia(new Patologia(TypePatologie.PATO2));
        palestra.addPatologia(new Patologia(TypePatologie.PATO3));
        piscina.addPatologia(new Patologia(TypePatologie.PATO4));
        piscina.addPatologia(new Patologia(TypePatologie.PATO5));
        terme.addPatologia(new Patologia(TypePatologie.PATO6));
        terme.addPatologia(new Patologia(TypePatologie.PATO7));
        terme.addPatologia(new Patologia(TypePatologie.PATO8));
        salaMassaggi.addPatologia(new Patologia(TypePatologie.PATO9));
        salaMassaggi.addPatologia(new Patologia(TypePatologie.PATO0));


        //PUNTO 3
        clinica.addStruttura(palestra);
        clinica.addStruttura(piscina);
        clinica.addStruttura(terme);
        clinica.addStruttura(salaMassaggi);

        //PUNTO 4
        Fisioterapista andreaRossi = new Fisioterapista("Andrea", "Rossi", "ANDROS1");
        Fisioterapista giulioBianchi = new Fisioterapista("Giulio", "Bianchi", "GIUBIA2");
        Fisioterapista pippoGialli = new Fisioterapista("Pippo", "Gialli", "PIPGIA3");
        Fisioterapista antonioRe = new Fisioterapista("Antonio", "Re", "ANTREX4");

        //PUNTO 5
        palestra.addFisioterapista(andreaRossi);
        piscina.addFisioterapista(giulioBianchi);
        terme.addFisioterapista(pippoGialli);
        salaMassaggi.addFisioterapista(antonioRe);

        //PUNTO 6
        System.out.println(clinica.toString());

        //PUNTO 7-8-9
        try {
            clinica.addFromFile("/home/nicolas/Documenti/unipv/java/feb_16/prenotazioni.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //PUNTO 10
        clinica.printListaPazienti();

        //INTERFACCIA GRAFICA
        GuiPrenotazione guiPrenotazione = new GuiPrenotazione(clinica);
        guiPrenotazione.setVisible(true);
    }
}
