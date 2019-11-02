public class TestGUI {
    public static void main(String[] args) {
        OperatoreUI operatoreBevandeUI = new OperatoreUI(TypeDistributore.BEVANDE, "/home/nicolas/Documenti/UNIPV/java/gen_16/bevande.txt");
        operatoreBevandeUI.setVisible(true);
        OperatoreUI operatoreSnacksUI = new OperatoreUI(TypeDistributore.SNACK, "/home/nicolas/Documenti/UNIPV/java/gen_16/snack.txt");
        operatoreSnacksUI.setVisible(true);
    }
}
