import javax.swing.*;
import calcolatriceModel.Calcolatrice;

public class Test extends JFrame {
    public static void main(String[] args) {
        Calcolatrice calcolatrice = new Calcolatrice();
        CalcGUI calcolatriceGUI = new CalcGUI(calcolatrice);
        calcolatriceGUI.setVisible(true);
    }
}
