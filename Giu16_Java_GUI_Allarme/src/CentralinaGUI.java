import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CentralinaGUI extends JFrame {
    final int WIDTH = 1024;
    final int HEIGHT = 600;
    private JPanel panelText = new JPanel();
    private JPanel panelUpper = new JPanel();
    private JPanel panelPhone = new JPanel();
    private JTextField textNomeSensore = new JTextField();
    private JTextField textEventoAnomalo = new JTextField();
    private JTextField textMinValue = new JTextField();
    private JTextField textMaxValue = new JTextField();
    private JTextField textGrandezza = new JTextField();
    private JLabel labelNomeSensore = new JLabel("Nome sensore:", SwingConstants.CENTER);
    private JLabel labelEventoAnomalo = new JLabel("Evento anomalo:", SwingConstants.CENTER);
    private JLabel labelMinValue = new JLabel("Valore minimo:", SwingConstants.CENTER);
    private JLabel labelMaxValue = new JLabel("Valore massimo:", SwingConstants.CENTER);
    private JLabel labelGrandezza = new JLabel("Grandezza fisica:", SwingConstants.CENTER);
    private JButton buttonTipoA = new JButton("Sensore tipo A");
    private JButton buttonTipoB = new JButton("Sensore tipo B");
    private JButton buttonAssocia = new JButton("Associa sensore");
    private JButton buttonAggiorna = new JButton("Acquisisci");
    private JTextField textNumRilevazioni = new JTextField("1");
    private JButton buttonReportStato = new JButton("Stato centralina");
    private JButton buttonPhone = new JButton("Configura");
    private JLabel labelPhone = new JLabel("Telefono:", SwingConstants.CENTER);
    private JTextArea textPhone = new JTextArea("");
    private JTextArea textInfo = new JTextArea();

    private Centralina centralina;
    private boolean isA = true;

    public CentralinaGUI(){
        setSize(WIDTH, HEIGHT);
        setTitle("Centralina");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(2, 1));
        Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
        setLocation(( screenSize.width / 2 ) - ( this.getWidth ( ) / 2 ), (
                screenSize.height / 2 ) - ( this.getHeight ( ) / 2 ));

        initComponents();
    }

    private void initComponents(){
        panelUpper.setLayout(new BorderLayout());
        panelPhone.setLayout(new GridLayout(1,3, 10, 10));
        panelPhone.add(labelPhone);
        textPhone.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textPhone.setBackground(Color.LIGHT_GRAY);
        panelPhone.add(textPhone);
        panelPhone.add(buttonPhone);
        textInfo.setLineWrap(true);
        textInfo.setEditable(false);
        panelUpper.add(textInfo, BorderLayout.CENTER);
        panelUpper.add(panelPhone, BorderLayout.SOUTH);
        add(panelUpper);
        panelText.setLayout(new GridLayout(4,4));
        panelText.add(buttonTipoA);
        panelText.add(buttonTipoB);
        panelText.add(labelNomeSensore);
        panelText.add(textNomeSensore);
        panelText.add(labelEventoAnomalo);
        panelText.add(textEventoAnomalo);
        panelText.add(labelGrandezza);
        panelText.add(textGrandezza);
        panelText.add(labelMinValue);
        panelText.add(textMinValue);
        panelText.add(labelMaxValue);
        panelText.add(textMaxValue);
        panelText.add(buttonReportStato);
        panelText.add(buttonAssocia);
        panelText.add(buttonAggiorna);
        panelText.add(textNumRilevazioni);
        buttonTipoA.setEnabled(false);
        buttonTipoB.setEnabled(false);
        buttonAggiorna.setEnabled(false);
        buttonAssocia.setEnabled(false);
        buttonReportStato.setEnabled(false);
        textNomeSensore.setEnabled(false);
        textGrandezza.setEnabled(false);
        textEventoAnomalo.setEnabled(false);
        textMaxValue.setEnabled(false);
        textMinValue.setEnabled(false);
        textNumRilevazioni.setEnabled(false);
        add(panelText);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getActionCommand().equals("Sensore tipo A")) {
                    buttonTipoA.setEnabled(false);
                    buttonTipoB.setEnabled(true);
                    textNomeSensore.setEnabled(true);
                    textGrandezza.setEnabled(true);
                    textEventoAnomalo.setEnabled(false);
                    textMaxValue.setEnabled(true);
                    textMinValue.setEnabled(true);
                    isA = true;
                }
                if (ae.getActionCommand().equals("Sensore tipo B")) {
                    buttonTipoA.setEnabled(true);
                    buttonTipoB.setEnabled(false);
                    textNomeSensore.setEnabled(true);
                    textGrandezza.setEnabled(false);
                    textEventoAnomalo.setEnabled(true);
                    textMaxValue.setEnabled(false);
                    textMinValue.setEnabled(false);
                    isA = false;
                }
                if ((ae.getActionCommand().equals("Configura")) && (!(textPhone.getText().equals("")))) {
                    configuraCentralina();
                }
                if (ae.getActionCommand().equals("Associa sensore")) {
                    associaSensore();
                }
                if (ae.getActionCommand().equals("Stato centralina")) {
                    textInfo.setText(centralina.toString());
                    buttonReportStato.setText("Ultimi 10 allarmi");
                }
                if (ae.getActionCommand().equals("Ultimi 10 allarmi")) {
                    textInfo.setText(centralina.printRegistroAllarmi());
                    buttonReportStato.setText("Stato centralina");
                }
                if (ae.getActionCommand().equals("Acquisisci")) {
                    int i;
                    try{
                        for (i = 0; i < Integer.parseInt(textNumRilevazioni.getText()); i++){
                            centralina.readSensors();
                        }
                    } catch (NumberFormatException e){
                        textNumRilevazioni.setText("1");
                        centralina.readSensors();
                    }
                }
            }
        };

        buttonTipoA.addActionListener(al);
        buttonTipoB.addActionListener(al);
        buttonPhone.addActionListener(al);
        buttonAssocia.addActionListener(al);
        buttonReportStato.addActionListener(al);
        buttonAggiorna.addActionListener(al);
    }

    private void configuraCentralina(){
        buttonTipoB.setEnabled(true);
        //buttonAggiorna.setEnabled(true);
        buttonAssocia.setEnabled(true);
        buttonReportStato.setEnabled(true);
        buttonPhone.setEnabled(false);
        textPhone.setEnabled(false);
        textNomeSensore.setEnabled(true);
        textGrandezza.setEnabled(true);
        textMaxValue.setEnabled(true);
        textMinValue.setEnabled(true);
        textNumRilevazioni.setEnabled(true);
        centralina = new Centralina(textPhone.getText());
    }

    private void associaSensore(){
        try{
            if (isA){
                SensoreA s = new SensoreA(textNomeSensore.getText(), Integer.parseInt(textMinValue.getText()),
                        Integer.parseInt(textMaxValue.getText()), textGrandezza.getText());
                if (centralina.addSensore(s)){
                    AvvisoGUI msgOk = new AvvisoGUI(textNomeSensore.getText() + " associato correttamente!");
                    msgOk.setVisible(true);
                    buttonAggiorna.setEnabled(true);
                } else {
                    AvvisoGUI errore = new AvvisoGUI("Non puoi associare altri sensori di questo tipo!");
                    errore.setVisible(true);
                }

            } else{
                SensoreB s = new SensoreB(textNomeSensore.getText(), textEventoAnomalo.getText());
                if (centralina.addSensore(s)){
                    AvvisoGUI msgOk = new AvvisoGUI(textNomeSensore.getText() + " associato correttamente!");
                    msgOk.setVisible(true);
                    buttonAggiorna.setEnabled(true);
                } else {
                    AvvisoGUI errore = new AvvisoGUI("Non puoi associare altri sensori di questo tipo!");
                    errore.setVisible(true);
                }
            }
        } catch (NumberFormatException e){
            AvvisoGUI errore = new AvvisoGUI("Valori non validi!");
            errore.setVisible(true);
        }

        textNomeSensore.setText("");
        textGrandezza.setText("");
        textEventoAnomalo.setText("");
        textMaxValue.setText("");
        textMinValue.setText("");
    }
}
