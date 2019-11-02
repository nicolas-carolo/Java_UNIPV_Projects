import javax.swing.*;

public class CalcButton extends JButton implements Comparable<CalcButton>{
    private int keyCode;
    private int ordine;
    private boolean specialButton;

    public CalcButton(String string, int keyCode, int ordine, boolean special) {
        super(string);
        this.keyCode = keyCode;
        this.ordine = ordine;
        this.specialButton = special;
    }

    public int compareTo(CalcButton t){
        return (ordine - t.ordine);
    }

    public int getKeyCode(){
        return keyCode;
    }

    public boolean isSpecialButton(){
        return specialButton;
    }
}
