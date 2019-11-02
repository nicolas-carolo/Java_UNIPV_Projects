import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvvisoGUI extends JFrame {
    final int WIDTH = 300;
    final int HEIGHT = 150;

    private JLabel labelAvviso = new JLabel("", SwingConstants.CENTER);
    private JButton buttonOk = new JButton("OK");

    public AvvisoGUI(String avviso) {
        labelAvviso.setText(avviso);
        setSize(WIDTH, HEIGHT);
        setTitle("Avviso");
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
        setLocation(( screenSize.width / 2 ) - ( this.getWidth ( ) / 2 ), (
                screenSize.height / 2 ) - ( this.getHeight ( ) / 2 ));

        initComponents();
    }

    private void initComponents(){
        labelAvviso.setFont(new Font("Arial Black", Font.PLAIN, 14));
        add(labelAvviso, BorderLayout.CENTER);
        buttonOk.setFont(new Font("Arial Black", Font.PLAIN, 16));
        add(buttonOk, BorderLayout.SOUTH);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("OK")){
                    setVisible(false);
                }
            }
        };
        buttonOk.addActionListener(al);
    }
}
