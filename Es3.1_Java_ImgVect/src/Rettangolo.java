public class Rettangolo extends Forma {
    private double base;
    private double altezza;
    public Rettangolo(Colore color, double base, double altezza) {
        super(color);
        this.base = base;
        this.altezza = altezza;
    }
    public double perimetro() {
        return (base + altezza) * 2;
    }

    public double area(){
        return base * altezza;
    }

    @Override
    public String toString() {
        return "Rettangolo: base = " + base + ", altezza = " + altezza + ", perimetro = " + this.perimetro() + ", area = " + this.area() + ", colore = " + getColor() + "\n";
    }
}
