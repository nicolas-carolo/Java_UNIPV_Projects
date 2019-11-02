import javax.swing.*;

public class TestGui extends JFrame{
    public static void main(String[] args) {
        TabelloneGUI tabelloneCalcio = new TabelloneGUI("Calcio", TabelloneType.CALCIO,"/Users/nicolas/Documents/unipv/java/partite/calcio.txt", "Juventus", "Roma");
        tabelloneCalcio.setVisible(true);
        TabelloneGUI tabelloneVolley = new TabelloneGUI("Volley", TabelloneType.VOLLEY,"/Users/nicolas/Documents/unipv/java/partite/volley.txt", "A", "B");
        tabelloneVolley.setVisible(true);
    }
}
