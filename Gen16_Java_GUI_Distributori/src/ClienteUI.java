import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.ArrayList;

public class ClienteUI extends JFrame {
    final int WIDTH = 1024;
    final int HEIGHT = 600;

    private TypeDistributore typeUI;
    private Distributore distributore;
    private String codToBuy = "";

    private JTextArea textList = new JTextArea();
    private JPanel panelIntMonete = new JPanel();
    private JLabel labelBudget = new JLabel("€0.00", SwingConstants.CENTER);
    private JLabel labelMonete = new JLabel("Codice prodotto:", SwingConstants.CENTER);
    private JButton buttonConfermaMonete = new JButton("Seleziona");
    private JPanel panelMonete = new JPanel();
    private JTextField textNumeroMonete = new JTextField("");
    private JButton buttonBuy = new JButton("Acquista");
    private JLabel labelAvviso = new JLabel("Seleziona un prodotto", SwingConstants.CENTER);
    private JPanel panelBuy = new JPanel();
    private JPanel panelNavigation = new JPanel();
    private JButton buttonSuccessivo = new JButton("Successivo");
    private JButton buttonPrecedente = new JButton("Precedente");

    private ArrayList<String> arrayProdotti = new ArrayList<String>();
    private int indexArrayProdotti = 0;

    public ClienteUI(Distributore d, TypeDistributore td) {
        super();
        setTitle("Cliente");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(3,1));

        this.typeUI = td;
        this.distributore = d;

        initComponents();
        initData();
    }

    private void initComponents(){
        textList.setEditable(false);
        textList.setLineWrap(true);
        textList.setFont(new Font("Arial Black", Font.BOLD, 18));
        add(textList);
        panelMonete.setLayout(new GridLayout(2,1));
        panelIntMonete.setLayout(new GridLayout(1, 2));
        labelMonete.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelIntMonete.add(labelMonete);
        textNumeroMonete.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelIntMonete.add(textNumeroMonete);
        labelBudget.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelIntMonete.add(labelBudget);
        panelMonete.add(panelIntMonete);
        panelNavigation.setLayout(new GridLayout(1, 3));
        buttonPrecedente.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelNavigation.add(buttonPrecedente);
        buttonConfermaMonete.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelNavigation.add(buttonConfermaMonete);
        buttonSuccessivo.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelNavigation.add(buttonSuccessivo);
        panelMonete.add(panelNavigation);
        add(panelMonete);
        panelBuy.setLayout(new GridLayout(2, 1));
        labelAvviso.setFont(new Font("Arial Black", Font.BOLD, 18));
        panelBuy.add(labelAvviso);
        buttonBuy.setFont(new Font("Arial Black", Font.BOLD, 18));
        buttonBuy.setEnabled(false);
        panelBuy.add(buttonBuy);
        add(panelBuy);

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

                if (ae.getActionCommand().equals("Inserisci")){
                    inserisciMonete();
                }

                if (ae.getActionCommand().equals("Seleziona")){
                    labelAvviso.setText("Acquisto in corso");
                    preparaAcquisto();
                    preparaPagamento();
                }

                if (ae.getActionCommand().equals("Acquista")){
                    distributore.acquistaProdotto(codToBuy);
                    labelAvviso.setText(distributore.avviso);
                    buttonBuy.setEnabled(false);
                    buttonConfermaMonete.setEnabled(true);
                    buttonConfermaMonete.setText("Seleziona");
                    textNumeroMonete.setText("");
                    textNumeroMonete.setEnabled(true);
                    labelBudget.setText(Double.toString(distributore.budget));
                    aggiorna();
                }
            }
        };

        buttonSuccessivo.addActionListener(al);
        buttonPrecedente.addActionListener(al);
        buttonConfermaMonete.addActionListener(al);
        buttonBuy.addActionListener(al);
    }

    private boolean initData(){
        indexArrayProdotti = 0;
        switch (typeUI){
            case BEVANDE:
                DistributoreBevande db = (DistributoreBevande)distributore;
                arrayProdotti = db.printListaProdotti();
                break;
            case SNACK:
                DistributoreSnack ds = (DistributoreSnack)distributore;
                arrayProdotti = ds.printListaProdotti();
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

    private void preparaAcquisto(){
        switch (typeUI){
            case SNACK:
                DistributoreSnack ds = (DistributoreSnack) distributore;
                codToBuy = textNumeroMonete.getText();
                break;
            case BEVANDE:
                DistributoreBevande db = (DistributoreBevande)distributore;
                codToBuy = textNumeroMonete.getText();
                break;
        }
    }

    private void preparaPagamento(){
        if (labelMonete.getText().equals("Codice prodotto:")){
            labelMonete.setText("Numero monete da €0.50:");
            buttonConfermaMonete.setText("Inserisci");
            textNumeroMonete.setText("0");
        } else if (labelMonete.getText().equals("Numero monete da €0.50:")){
            labelMonete.setText("Numero monete da €0.20:");
        } else if (labelMonete.getText().equals("Numero monete da €0.20:")){
            labelMonete.setText("Numero monete da €0.10:");
        } else if (labelMonete.getText().equals("Numero monete da €0.10:")){
            labelMonete.setText("Numero monete da €0.05:");
        } else if (labelMonete.getText().equals("Numero monete da €0.05:")){
            buttonConfermaMonete.setEnabled(false);
            textNumeroMonete.setEnabled(false);
            buttonBuy.setEnabled(true);
            labelAvviso.setText("Premi per acquistare!");
            labelMonete.setText("Codice prodotto:");
        }
    }

    private void inserisciMonete(){
        if (labelMonete.getText().equals("Numero monete da €0.50:")){
            distributore.budget = distributore.budget + 0.50 * Double.parseDouble(textNumeroMonete.getText());
            textNumeroMonete.setText("0");
            labelBudget.setText(Double.toString(distributore.budget));
            preparaPagamento();
        } else if (labelMonete.getText().equals("Numero monete da €0.20:")){
            distributore.budget = distributore.budget + 0.20 * Double.parseDouble(textNumeroMonete.getText());
            textNumeroMonete.setText("0");
            labelBudget.setText(Double.toString(distributore.budget));
            preparaPagamento();
        }else if (labelMonete.getText().equals("Numero monete da €0.10:")){
            distributore.budget = distributore.budget + 0.10 * Double.parseDouble(textNumeroMonete.getText());
            textNumeroMonete.setText("0");
            labelBudget.setText(Double.toString(distributore.budget));
            preparaPagamento();
        }else if (labelMonete.getText().equals("Numero monete da €0.05:")){
            distributore.budget = distributore.budget + 0.05 * Double.parseDouble(textNumeroMonete.getText());
            textNumeroMonete.setText("0");
            labelBudget.setText(Double.toString(distributore.budget));
            preparaPagamento();
        }
    }

    private void aggiorna(){
        indexArrayProdotti = 0;
        switch (typeUI){
            case BEVANDE:
                DistributoreBevande db = (DistributoreBevande)distributore;
                arrayProdotti = db.printListaProdotti();
                break;
            case SNACK:
                DistributoreSnack ds = (DistributoreSnack)distributore;
                arrayProdotti = ds.printListaProdotti();
                break;
        }
        if (arrayProdotti.size() != 0){
            textList.setText(arrayProdotti.get(indexArrayProdotti));
        } else {
            textList.setText("Distributore completamente vuoto");
        }
    }

}
