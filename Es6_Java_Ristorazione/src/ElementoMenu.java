public class ElementoMenu {
    private Alimento alimento;
    private double prezzo;

    public ElementoMenu(Alimento alimento, double prezzo) {
        this.alimento = alimento;
        this.prezzo = prezzo;
    }

    public boolean equals(ElementoMenu em) {
        if ((this.prezzo == em.prezzo) && (this.alimento.nome.equals(em.alimento.nome))){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.alimento.toString() + "\nprezzo: " + this.prezzo;
    }
}
