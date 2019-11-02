import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ristorante extends Ristorazione {
    public Ristorante(String nome) {
        super(nome);
    }

    public boolean add(Alimento alimento, double prezzo){
        ElementoMenu newElemento = new ElementoMenu(alimento, prezzo);
        menu.add(newElemento);
        System.out.println("Alimento \"" + alimento.nome + "\" aggiunto correttamente al menu!");
        return true;
    }

    public void remove(Alimento alimento, double prezzo){
        ElementoMenu elementToRemove = new ElementoMenu(alimento, prezzo);
        if (menu.remove(elementToRemove)){
            System.out.println("Alimento \"" + alimento.nome + "\" correttamente rimosso dal menu!");
        } else {
            System.out.println("ERRORE: Impossibile rimovere un alimento inesistente dal menu!");
        }
    }

    public void printMenu(){
        menu.printMenu();
    }

    public boolean addFromFile(String nomeFile){
        Scanner inputStream = null;
        Alimento alimento = null;
        double prezzo = 0.0;
        double gradazione = 0.0;
        try{
           inputStream = new Scanner(new File (nomeFile));
        }
        catch(FileNotFoundException e){
            System.out.println("File non trovato!");
            return false;
        }

        while (inputStream.hasNextLine()){
            String riga = inputStream.nextLine();

            StringTokenizer token = new StringTokenizer(riga, "\t");

            String type = token.nextToken();

            if (type.equals("0")) {
                String nome = token.nextToken();
                String animale = token.nextToken();
                String pezzo = token.nextToken();
                prezzo = Double.parseDouble(token.nextToken());
                String codiceIdentificativo = token.nextToken();
                if (codiceIdentificativo.equals("NOBIO")){
                    alimento = new Carne(nome, animale, pezzo);
                } else {
                    alimento = new CarneBio(nome, animale, pezzo, codiceIdentificativo);
                }
                add(alimento, prezzo);
            }

            if (type.equals("1")) {
                String nome = token.nextToken();
                gradazione = Double.parseDouble(token.nextToken());
                String tipo = token.nextToken();
                String colore = token.nextToken();
                prezzo = Double.parseDouble(token.nextToken());
                String codiceIdentificativo = token.nextToken();
                if (codiceIdentificativo.equals("NOBIO")){
                    alimento = new Vino(nome, gradazione, tipo, colore);
                } else {
                    alimento = new VinoBio(nome, gradazione, tipo, colore, codiceIdentificativo);
                }
                add(alimento, prezzo);
            }
        }
        inputStream.close();
        return true;
    }
}
