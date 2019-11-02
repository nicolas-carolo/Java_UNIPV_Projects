public class Cerchio extends Forma {
    private double r;
    public Cerchio(Colore color, double r) {
        super(color);
        this.r = r;
    }

    public double perimetro() {
        return 2 * Math.PI * r;
    }

    public double area(){
        return (Math.pow(r, 2)) * Math.PI;
    }

    @Override
    public String toString() {
        return "Cerchio: raggio = " + r + ", perimetro = " + this.perimetro() + ", area = " + this.area() + ", colore = " + getColor() + "\n";
    }
}

