import java.util.HashMap;
import java.util.HashSet;

public abstract class Ristorazione {
    protected String nome;
    protected Menu menu;

    public abstract boolean add(Alimento alimento, double prezzo);
    public abstract boolean addFromFile(String nomeFile);
    public abstract void printMenu();

    public void remove(Alimento alimento, double prezzo){
        ElementoMenu elementToRemove = new ElementoMenu(alimento, prezzo);
        if (menu.remove(elementToRemove)){
            System.out.println("Alimento correttamente rimosso dal menu!");
        } else {
            System.out.println("Impossibile rimuovere un alimento inesistente!");
        }
    }

    public Ristorazione(String nome) {
        this.nome = nome;
        this.menu = new Menu();
    }
}
