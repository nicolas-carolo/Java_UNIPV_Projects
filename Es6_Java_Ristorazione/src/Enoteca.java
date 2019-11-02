import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Enoteca extends Ristorazione {
    public Enoteca(String nome) {
        super(nome);

    }

    public boolean add(Alimento alimento, double prezzo){
        if (alimento instanceof Vino) {
            ElementoMenu newElemento = new ElementoMenu(alimento, prezzo);
            menu.add(newElemento);
            System.out.println("Vino \"" + alimento.nome + "\" aggiunto correttamente al menu!");
            return true;
        } else {
            System.out.println("Impossibile aggiungere al menu un alimento che non sia un vino!");
            return false;
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
