import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPrenotazione extends JFrame {
    final int WIDTH = 800;
    final int HEIGHT = 300;
    private JTextArea textPrenotazione = new JTextArea();
    private JPanel mainPanel = new JPanel();
    private JPanel panelText = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JTextField textNome = new JTextField();
    private JTextField textCognome = new JTextField();
    private JTextField textPatologia = new JTextField();
    private JTextField textGiorno = new JTextField();
    private JLabel labelNome = new JLabel("Nome", SwingConstants.CENTER);
    private JLabel labelCognome = new JLabel("Cognome", SwingConstants.CENTER);
    private JLabel labelPatologia = new JLabel("Patologia", SwingConstants.CENTER);
    private JLabel labelGiorno = new JLabel("Giorno (opzionale)", SwingConstants.CENTER);
    private JButton buttonPrenota = new JButton("Prenota");
    private JLabel labelAvviso = new JLabel("Effettua la prenotazione", SwingConstants.CENTER);

    private Clinica clinica;


    public GuiPrenotazione(Clinica clinica){
        setTitle("Prenotazione");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));

        this.clinica = clinica;
        initComponents();
    }

    public void initComponents(){
        textPrenotazione.setFont(new Font("Serif", Font.PLAIN, 16));
        textPrenotazione.setLineWrap(true);
        textPrenotazione.setEditable(false);
        add(textPrenotazione);
        mainPanel.setLayout(new BorderLayout());
        panelText.setLayout(new GridLayout(2,8));
        bottomPanel.setLayout(new BorderLayout());
        labelCognome.setFont(new Font("Serif", Font.PLAIN, 16));
        panelText.add(labelCognome);
        textCognome.setFont(new Font("Serif", Font.PLAIN, 16));
        panelText.add(textCognome);
        labelNome.setFont(new Font("Serif", Font.PLAIN, 16));
        panelText.add(labelNome);
        textNome.setFont(new Font("Serif", Font.PLAIN, 16));
        panelText.add(textNome);
        labelPatologia.setFont(new Font("Serif", Font.PLAIN, 16));
        panelText.add(labelPatologia);
        textPatologia.setFont(new Font("Serif", Font.PLAIN, 16));
        panelText.add(textPatologia);
        labelGiorno.setFont(new Font("Serif", Font.PLAIN, 16));
        panelText.add(labelGiorno);
        textGiorno.setFont(new Font("Serif", Font.PLAIN, 16));
        panelText.add(textGiorno);
        buttonPrenota.setFont(new Font("Serif", Font.PLAIN, 16));
        bottomPanel.add(buttonPrenota, BorderLayout.NORTH);
        labelAvviso.setFont(new Font("Serif", Font.PLAIN, 16));
        bottomPanel.add(labelAvviso, BorderLayout.CENTER);
        mainPanel.add(panelText, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(mainPanel);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if ((ae.getActionCommand().equals("Prenota")) && (!(textCognome.getText().equals(""))) && (!(textNome.getText().equals(""))) &&(!(textPatologia.getText().equals("")))){
                    textPatologia.setText(textPatologia.getText().toUpperCase());
                    labelAvviso.setText(clinica.avviaPrenotazioneGui(textCognome.getText(), textNome.getText(), textPatologia.getText(), textGiorno.getText()));
                    if (labelAvviso.getText().equals("Prenotazione effettuata!")){
                        textPrenotazione.setText(clinica.getLastPrenotazione());
                    } else {
                        textPrenotazione.setText("");
                    }

                }

            }
        };

        buttonPrenota.addActionListener(al);
    }
}
