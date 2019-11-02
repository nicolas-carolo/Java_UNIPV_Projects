public abstract class Forma implements Comparable {
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

    public int compareTo(Object o){
        if (this.area() < ((Forma)o).area()) {
            return -1;
        } else if (this.area() > ((Forma)o).area()) {
            return  1;
        }
        return 0;
    }

    public abstract double perimetro();
    public abstract double area();
    public abstract String toString();
}
