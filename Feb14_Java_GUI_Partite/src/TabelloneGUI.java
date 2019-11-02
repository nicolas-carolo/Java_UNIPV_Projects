import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabelloneGUI extends JFrame {
    final int WIDTH = 1024;
    final int HEIGHT = 400;
    private JPanel upPanel;
    private JPanel centerPanel;
    private JPanel downPanel;
    private ReadFile leggiFile = new ReadFile();
    JLabel labelNomeCasa;
    JLabel labelPunteggioCasa;
    JLabel labelPunteggioOspite;
    JLabel labelNomeOspite;
    JLabel labelSetWinCasa;
    JLabel labelSetWinOspite;
    JLabel labelTimeOutCasa;
    JLabel labelSet;
    JLabel labelMinuti;
    JLabel labelTimeOutOspite;
    JLabel labelCommenti;
    JButton buttonUpdate;

    public TabelloneGUI(String nomeTabellone, TabelloneType tt ,String inputFileDirectory, String casa, String ospite){
        super();
        setTitle(nomeTabellone);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        initComponents(tt,casa, ospite);
        leggiFile.openFile(inputFileDirectory);
        getData();

    }

    private void initComponents(TabelloneType tt, String casa, String ospite){
        upPanel = new JPanel();
        upPanel.setLayout(new GridLayout(2,4, 10, 10));
        labelNomeCasa = new JLabel(casa, SwingConstants.CENTER);
        labelNomeCasa.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        labelPunteggioCasa = new JLabel("0", SwingConstants.CENTER);
        labelPunteggioCasa.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        labelPunteggioOspite = new JLabel("0", SwingConstants.CENTER);
        labelPunteggioOspite.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        labelNomeOspite = new JLabel(ospite, SwingConstants.CENTER);
        labelNomeOspite.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        upPanel.add(labelNomeCasa);
        upPanel.add(labelPunteggioCasa);
        upPanel.add(labelPunteggioOspite);
        upPanel.add(labelNomeOspite);
        JLabel label1 = new JLabel("Set vinti", SwingConstants.CENTER);
        label1.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        labelSetWinCasa = new JLabel("0", SwingConstants.CENTER);
        labelSetWinCasa.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        labelSetWinOspite = new JLabel("0", SwingConstants.CENTER);
        labelSetWinOspite.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        JLabel label2 = new JLabel("Set vinti", SwingConstants.CENTER);
        label2.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        upPanel.add(label1);
        upPanel.add(labelSetWinCasa);
        upPanel.add(labelSetWinOspite);
        upPanel.add(label2);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1,6, 10, 10));
        JLabel label3 = new JLabel("Time-out", SwingConstants.CENTER);
        label3.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        labelTimeOutCasa = new JLabel("0", SwingConstants.CENTER);
        labelTimeOutCasa.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        labelSet = new JLabel("Set: 0", SwingConstants.CENTER);
        labelSet.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        labelMinuti = new JLabel("0'", SwingConstants.CENTER);
        labelMinuti.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        labelTimeOutOspite = new JLabel("0", SwingConstants.CENTER);
        labelTimeOutOspite.setFont((new Font("Arial Black", Font.PLAIN, 16)));
        JLabel label4 = new JLabel("Time-out", SwingConstants.CENTER);
        label4.setFont(new Font("Arial Black", Font.PLAIN, 16));
        centerPanel.add(label3);
        centerPanel.add(labelTimeOutCasa);
        centerPanel.add(labelSet);
        centerPanel.add(labelMinuti);
        centerPanel.add(labelTimeOutOspite);
        centerPanel.add(label4);

        downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(2,1, 10, 10));
        labelCommenti = new JLabel("", SwingConstants.CENTER);
        buttonUpdate = new JButton("Aggiorna");
        downPanel.add(labelCommenti);
        downPanel.add(buttonUpdate);

        if (tt.equals(TabelloneType.CALCIO)){
            labelSetWinCasa.setVisible(false);
            labelSetWinOspite.setVisible(false);
            label1.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(false);
            label4.setVisible(false);
            labelTimeOutCasa.setVisible(false);
            labelTimeOutOspite.setVisible(false);
        } else if (tt.equals(TabelloneType.VOLLEY)){
            labelMinuti.setVisible(false);
        }

        add(upPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(downPanel, BorderLayout.SOUTH);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getActionCommand().equals("Aggiorna")) {
                    getData();
                }
            }
        };

        buttonUpdate.addActionListener(al);
    }

    public void getData(){
        try{
            leggiFile.updateFromFile();
            labelCommenti.setText(leggiFile.getDescrizione());
            labelPunteggioCasa.setText(Integer.toString(leggiFile.getPartita().punteggioCasa));
            labelPunteggioOspite.setText(Integer.toString(leggiFile.getPartita().punteggioOspite));
            if (leggiFile.getPartita() instanceof PartitaVolley){
                PartitaVolley pv = (PartitaVolley)leggiFile.getPartita();
                labelSet.setText("Set: " + Integer.toString(leggiFile.getPartita().setInProgress));
                labelSetWinCasa.setText(Integer.toString(pv.getSetWinCasa()));
                labelSetWinOspite.setText(Integer.toString(pv.getSetWinOspite()));
                labelTimeOutCasa.setText(Integer.toString(pv.getTimeOutCasa()));
                labelTimeOutOspite.setText(Integer.toString(pv.getTimeOutOspite()));
            }
            if (leggiFile.getPartita() instanceof PartitaCalcio){
                PartitaCalcio pc = (PartitaCalcio) leggiFile.getPartita();
                labelSet.setText(Integer.toString(leggiFile.getPartita().setInProgress) + "T");
                labelMinuti.setText(Integer.toString(leggiFile.getMinutoSet()) + "'");
            }
        }
        catch (IllegalStateException e){
            buttonUpdate.enable(false);
            buttonUpdate.setText("Fine");
        }

    }



}
