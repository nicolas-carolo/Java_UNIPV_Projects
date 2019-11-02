public abstract class Forma {
    private Colore color;

    public Forma(Colore color) {
        this.color = color;
    }

    public Colore getColor() {
        return color;
    }

    public void setColor(Colore color) {
        this.color = color;
    }

    public abstract double perimetro();
    public abstract double area();
    public abstract String toString();
}
