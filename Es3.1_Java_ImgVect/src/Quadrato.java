public class Quadrato extends Forma{
    private double l;
    public Quadrato(Colore color, double l) {
        super(color);
        this.l = l;
    }

    public double perimetro() {
        return l * 4;
    }

    public double area(){
        return Math.pow(l, 2);
    }

    @Override
    public String toString() {
        return "Quadrato: lato = " + l + ", perimetro = " + this.perimetro() + ", area = " + this.area() + ", colore = " + getColor() + "\n";
    }
}
