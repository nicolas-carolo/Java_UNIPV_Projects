import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.TextStyle;
import java.util.ArrayList;

public class OperatoreUI extends JFrame {
    final int WIDTH = 1024;
    final int HEIGHT = 600;
    private TypeDistributore typeUI;
    private Distributore distributore;

    private JTextArea textList = new JTextArea();
    private JPanel panelButton = new JPanel();
    private JButton buttonListaProdotti = new JButton("Lista prodotti");
    private JButton buttonListaProdottiDisponibili = new JButton("Prodotti disponibili");
    private JButton buttonListaProdottiEsauriti = new JButton("Prodotti esauriti");
    private JTextArea textState = new JTextArea("");
    private JButton buttonRifornisci = new JButton("Rifornisci");
    private JButton buttonRitiraIncassi = new JButton("Ritira incassi");
    private JButton buttonSuccessivo = new JButton("Successivo");
    private JButton buttonPrecedente = new JButton("Precedente");

    private ArrayList<String> arrayProdotti = new ArrayList<String>();
    private int indexArrayProdotti = 0;

    public OperatoreUI(TypeDistributore td, String nomeFile) {
        super();
        setTitle("Operatore");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        this.typeUI = td;
        setLayout(new GridLayout(2,1));

        initComponents();
        initData(nomeFile);
    }

    private void initComponents(){
        textList.setEditable(true);
        textList.setLineWrap(true);
        textList.setWrapStyleWord(true);
        textList.setFont(new Font("Arial Black", Font.BOLD, 18));
        add(textList);
        panelButton.setLayout(new GridLayout(2, 4, 10, 10));
        buttonPrecedente.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelButton.add(buttonPrecedente);
        buttonSuccessivo.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelButton.add(buttonSuccessivo);
        buttonRitiraIncassi.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelButton.add(buttonRitiraIncassi);
        textState.setEditable(false);
        textState.setLineWrap(true);
        textState.setFont(new Font("Arial Black", Font.BOLD, 16));
        textState.setBackground(Color.LIGHT_GRAY);
        panelButton.add(textState);
        buttonListaProdotti.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelButton.add(buttonListaProdotti);
        buttonListaProdottiDisponibili.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelButton.add(buttonListaProdottiDisponibili);
        buttonListaProdottiEsauriti.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelButton.add(buttonListaProdottiEsauriti);
        buttonRifornisci.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelButton.add(buttonRifornisci);
        add(panelButton);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Container pannello = getContentPane();
                if ((ae.getActionCommand().equals("Successivo")) && (indexArrayProdotti < (arrayProdotti.size() - 1))){
                    indexArrayProdotti++;
                    textList.setText(arrayProdotti.get(indexArrayProdotti));
                }

                if ((ae.getActionCommand().equals("Precedente")) && (indexArrayProdotti > 0)){
                    indexArrayProdotti--;
                    textList.setText(arrayProdotti.get(indexArrayProdotti));
                }

                if (ae.getActionCommand().equals("Ritira incassi")){
                    ritiraIncassi();
                }

                if (ae.getActionCommand().equals("Prodotti esauriti")){
                    prodottiEsauriti();
                }

                if (ae.getActionCommand().equals("Prodotti disponibili")){
                    prodottiDisponibili();
                }

                if (ae.getActionCommand().equals("Lista prodotti")){
                   listaProdotti();
                }

                if (ae.getActionCommand().equals("Rifornisci")){
                    rifornisci();
                }
            }
        };

        buttonSuccessivo.addActionListener(al);
        buttonPrecedente.addActionListener(al);
        buttonRitiraIncassi.addActionListener(al);
        buttonListaProdottiEsauriti.addActionListener(al);
        buttonListaProdottiDisponibili.addActionListener(al);
        buttonListaProdotti.addActionListener(al);
        buttonRifornisci.addActionListener(al);
    }

    private boolean initData(String nomeFile){
        switch (typeUI){
            case BEVANDE:
                DistributoreBevande db = new DistributoreBevande(nomeFile);
                arrayProdotti = db.printListaProdotti();
                textList.setText(arrayProdotti.get(indexArrayProdotti));
                textState.setText("Incasso: €" + Double.toString(db.getIncasso()) + "\nLiofilizzato: " + db.getLiofilizzato() + "g");
                distributore = (Distributore)db;
                break;
            case SNACK:
                DistributoreSnack ds = new DistributoreSnack(nomeFile);
                arrayProdotti = ds.printListaProdotti();
                textList.setText(arrayProdotti.get(indexArrayProdotti));
                textState.setText("Incasso: €" + Double.toString(ds.getIncasso()));
                distributore = (Distributore)ds;
                break;
        }
        ClienteUI clienteUI = new ClienteUI(distributore, typeUI);
        clienteUI.setVisible(true);
        return true;
    }

    private boolean prodottiEsauriti(){
        indexArrayProdotti = 0;
        switch (typeUI){
            case BEVANDE:
                DistributoreBevande db = (DistributoreBevande)distributore;
                arrayProdotti = db.printListaProdottiEsauriti();
                textState.setText("Incasso: €" + Double.toString(db.getIncasso()) + "\nLiofilizzato: " + db.getLiofilizzato() + "g");
                break;
            case SNACK:
                DistributoreSnack ds = (DistributoreSnack)distributore;
                arrayProdotti = ds.printListaProdottiEsauriti();
                textState.setText("Incasso: €" + Double.toString(distributore.getIncasso()));
                break;
            default:
                return false;
        }
        if (arrayProdotti.size() != 0){
            textList.setText(arrayProdotti.get(indexArrayProdotti));
        } else {
            textList.setText("Nessun prodotto esaurito");
        }
        return true;
    }

    private boolean prodottiDisponibili(){
        indexArrayProdotti = 0;
        switch (typeUI){
            case BEVANDE:
                DistributoreBevande db = (DistributoreBevande)distributore;
                arrayProdotti = db.printListaProdottiDisponibili();
                textState.setText("Incasso: €" + Double.toString(db.getIncasso()) + "\nLiofilizzato: " + db.getLiofilizzato() + "g");
                break;
            case SNACK:
                DistributoreSnack ds = (DistributoreSnack)distributore;
                arrayProdotti = ds.printListaProdottiDisponibili();
                textState.setText("Incasso: €" + Double.toString(distributore.getIncasso()));
                break;
            default:
                return false;
        }
        if (arrayProdotti.size() != 0){
            textList.setText(arrayProdotti.get(indexArrayProdotti));
        } else {
            textList.setText("Nessun prodotto disponibile!");
        }
        return true;
    }

    private boolean listaProdotti(){
        indexArrayProdotti = 0;
        switch (typeUI){
            case BEVANDE:
                DistributoreBevande db = (DistributoreBevande)distributore;
                arrayProdotti = db.printListaProdotti();
                textState.setText("Incasso: €" + Double.toString(db.getIncasso()) + "\nLiofilizzato: " + db.getLiofilizzato() + "g");
                break;
            case SNACK:
                DistributoreSnack ds = (DistributoreSnack)distributore;
                arrayProdotti = ds.printListaProdotti();
                textState.setText("Incasso: €" + Double.toString(distributore.getIncasso()));
                break;
            default:
                return false;
        }
        if (arrayProdotti.size() != 0){
            textList.setText(arrayProdotti.get(indexArrayProdotti));
        } else {
            textList.setText("Distributore completamente vuoto");
        }
        return true;
    }

    private boolean rifornisci(){
        indexArrayProdotti = 0;
        switch (typeUI){
            case BEVANDE:
                DistributoreBevande db = (DistributoreBevande)distributore;
                db.ricaricaDistributore();
                arrayProdotti = db.printListaProdotti();
                textState.setText("Incasso: €" + Double.toString(db.getIncasso()) + "\nLiofilizzato: " + db.getLiofilizzato() + "g");
                break;
            case SNACK:
                DistributoreSnack ds = (DistributoreSnack)distributore;
                ds.ricaricaDistributore();
                arrayProdotti = ds.printListaProdotti();
                textState.setText("Incasso: €" + Double.toString(distributore.getIncasso()));
                break;
            default:
                return false;
        }
        if (arrayProdotti.size() != 0){
            textList.setText(arrayProdotti.get(indexArrayProdotti));
        } else {
            textList.setText("Distributore completamente vuoto");
        }
        return true;
    }

    private void ritiraIncassi() {
        switch (typeUI) {
            case BEVANDE:
                DistributoreBevande db = (DistributoreBevande) distributore;
                db.ritiraIncassi();
                textState.setText("Incasso: €" + Double.toString(db.getIncasso()) + "\nLiofilizzato: " + db.getLiofilizzato() + "g");
                break;
            case SNACK:
                DistributoreSnack ds = (DistributoreSnack) distributore;
                ds.ritiraIncassi();
                textState.setText("Incasso: €" + Double.toString(distributore.getIncasso()));
                break;
            default:
        }
    }
}
