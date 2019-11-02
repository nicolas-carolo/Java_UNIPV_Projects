import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EnotecaBio extends Enoteca {
    public EnotecaBio(String nome) {
        super(nome);

    }

    public boolean add(Alimento alimento, double prezzo){
        if ((alimento instanceof Vino) && (alimento instanceof Biologico)) {
            ElementoMenu newElemento = new ElementoMenu(alimento, prezzo);
            menu.add(newElemento);
            System.out.println("Alimento biologico \"" + alimento.nome + "\" aggiunto correttamente al menu!");
            return true;
        } else {
            System.out.println("Impossibile aggiungere al menu un alimento che non sia un vino biologico!");
            return false;
        }
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
                if (!(codiceIdentificativo.equals("NOBIO"))){
                    alimento = new VinoBio(nome, gradazione, tipo, colore, codiceIdentificativo);
                    add(alimento, prezzo);
                }
            }
        }
        inputStream.close();
        return true;
    }
}
