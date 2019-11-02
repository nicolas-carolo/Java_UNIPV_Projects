import calcolatriceModel.Calcolatrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class CalcGUI extends JFrame {
    public static final int HEIGHT = 400;
    public static final int WIDTH = 640;
    private Calcolatrice calc;
    private ArrayList<CalcButton> allButtons;
    private JLabel screen;
    private JPanel tastierino;

    public CalcGUI(Calcolatrice c){
        super();
        this.calc = c;
        setTitle("Calcolatrice");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        initComponents();

        add(tastierino, BorderLayout.CENTER);
        add(screen, BorderLayout.NORTH);
    }

    private void initComponents(){
        allButtons = new ArrayList<>();
        allButtons.add(new CalcButton("0", Calcolatrice.BUTTON_0, 16, false));
        allButtons.add(new CalcButton("1", Calcolatrice.BUTTON_1, 11, false));
        allButtons.add(new CalcButton("2", Calcolatrice.BUTTON_2, 12, false));
        allButtons.add(new CalcButton("3", Calcolatrice.BUTTON_3, 13, false));
        allButtons.add(new CalcButton("4", Calcolatrice.BUTTON_4, 6, false));
        allButtons.add(new CalcButton("5", Calcolatrice.BUTTON_5, 7, false));
        allButtons.add(new CalcButton("6", Calcolatrice.BUTTON_6, 8, false));
        allButtons.add(new CalcButton("7", Calcolatrice.BUTTON_7, 1, false));
        allButtons.add(new CalcButton("8", Calcolatrice.BUTTON_8, 2, false));
        allButtons.add(new CalcButton("9", Calcolatrice.BUTTON_9, 3, false));
        allButtons.add(new CalcButton(".", Calcolatrice.BUTTON_COMMA, 17, false));
        allButtons.add(new CalcButton("+", Calcolatrice.BUTTON_PLUS, 4, false));
        allButtons.add(new CalcButton("−", Calcolatrice.BUTTON_MINUS, 9, false));
        allButtons.add(new CalcButton("×", Calcolatrice.BUTTON_MOLT, 14, false));
        allButtons.add(new CalcButton("÷", Calcolatrice.BUTTON_DIV, 19, false));
        allButtons.add(new CalcButton("=", Calcolatrice.BUTTON_RETURN, 18, false));
        allButtons.add(new CalcButton("CE", Calcolatrice.BUTTON_CE, 5, false));
        allButtons.add(new CalcButton("M+", Calcolatrice.BUTTON_M, 10, false));
        allButtons.add(new CalcButton("MR", Calcolatrice.BUTTON_MR, 15, true));
        allButtons.add(new CalcButton("MC", Calcolatrice.BUTTON_MC, 20, true));

        Collections.sort(allButtons);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                calc.key(((CalcButton) ae.getSource()).getKeyCode());
                screen.setText(calc.getDisplay());

                for (CalcButton cb : allButtons) {
                    if (cb.isSpecialButton()) {
                        cb.setForeground((calc.hasMemory()) ? Color.blue : Color.black);
                    }
                }
            }
        };

        for (CalcButton cb : allButtons) {
            cb.addActionListener(al);
        }



        //Tastierino Panel
        tastierino = new JPanel();
        tastierino.setLayout(new GridLayout(4, 5, 10, 10));
        for (CalcButton cb : allButtons) {
            cb.setFont(new java.awt.Font("Arial", 1, 24));
            tastierino.add(cb);
        }

        //Screen Label
        screen = new JLabel();
        screen.setText("HELLO!");
        screen.setBackground(Color.black);
        screen.setFont(new java.awt.Font("Synchro LET", 1, 36));
        screen.setForeground(new java.awt.Color(51, 255, 0));
        screen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        screen.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 40));
        screen.setOpaque(true);
        screen.setPreferredSize(new java.awt.Dimension(100, 70));

    }
}
