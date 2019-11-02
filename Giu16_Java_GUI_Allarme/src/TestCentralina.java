import javax.swing.*;

public class TestCentralina extends JFrame {
    public static void main(String[] args) {
        //PUNTO1
        Centralina centralina = new Centralina("3330011222");

        //PUNTO 2
        SensoreB sensoreGas = new SensoreB("Sensore gas", "Fuga di gas");
        SensoreA sensoreTemp = new SensoreA("Termometro", 0, 40, "gradi");
        centralina.addSensore(sensoreGas);
        centralina.addSensore(sensoreTemp);

        //PUNTO 3
        System.out.println(centralina.toString());

        //PUNTO 4
        System.out.println(centralina.isEnabled());

        //PUNTO 5-6
        int i;
        for (i = 0; i < 2; i++){
            centralina.readSensors();
        }

        //PUNTO 7
        centralina.printRegistroAllarmi();

        //INTERFACCIA GRAFICA
        CentralinaGUI centralinaGUI = new CentralinaGUI();
        centralinaGUI.setVisible(true);
    }
}
