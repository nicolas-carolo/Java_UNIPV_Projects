public class TestReadFile {
    public static void main(String[] args) {
        int i= 0;
        ReadFile prova = new ReadFile();
        prova.openFile("/Users/nicolas/Documents/unipv/java/partite/volley.txt");
        for (i = 0; i < 35; i++){
            prova.updateFromFile();
        }
        prova.closeFile();
    }
}
