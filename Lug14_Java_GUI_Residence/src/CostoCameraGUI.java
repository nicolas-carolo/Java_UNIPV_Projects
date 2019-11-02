import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CostoCameraGUI extends JFrame {
    final int WIDTH = 300;
    final int HEIGHT = 150;
    private JPanel panelText = new JPanel();
    private JLabel labelId = new JLabel("ID:", SwingConstants.CENTER);
    private JLabel labelCosto = new JLabel("Canone:", SwingConstants.CENTER);
    private JTextField textId = new JTextField();
    private JTextField textCosto = new JTextField();
    private JButton buttonCalola = new JButton("Calcola canone");

    private Residence residence;

    public CostoCameraGUI(Residence residence){
        this.residence = residence;
        setTitle("Calcola canone");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        initComponents();
    }

    private void initComponents(){
        panelText.setLayout(new GridLayout(2,2));
        panelText.add(labelId);
        panelText.add(textId);
        panelText.add(labelCosto);
        textCosto.setEditable(false);
        panelText.add(textCosto);
        add(panelText, BorderLayout.CENTER);
        add(buttonCalola, BorderLayout.SOUTH);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getActionCommand().equals("Calcola canone")){
                    try{
                        textCosto.setText(residence.getCostoCameraGUI(Integer.parseInt(textId.getText())));
                    } catch (NumberFormatException e){
                        textCosto.setText("Err");
                    }

                }
            }
        };
        buttonCalola.addActionListener(al);
    }
}
