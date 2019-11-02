import java.util.HashSet;

public class Menu {
    public HashSet<ElementoMenu> menu;

    public boolean add(ElementoMenu newElemento){
        menu.add(newElemento);
        return true;
    }

    public boolean remove(ElementoMenu elementToRemove){
        for(ElementoMenu elementMenu : menu){
            if (elementToRemove.equals(elementMenu)) {
                Object objElement = (Object)elementMenu;
                menu.remove(objElement);
                return true;
            }
        }
        return false;
    }

    public void printMenu(){
        System.out.println("Stampa menu:\n*****");
        for(ElementoMenu elementToPrint : menu){
            System.out.println(elementToPrint.toString() + "\n*****");
        }
        System.out.println("Fine Stampa");
    }

    public Menu() {
        this.menu = new HashSet<ElementoMenu>();
    }
}
