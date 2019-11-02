import java.util.StringTokenizer;

public class Calculator {
    private final int A = 65;
    private final int Z = 90;
    private final int ASCII = 64;

    public int parse(String text) {
        int sum = 0;
        String nowToken = "";
        StringTokenizer textToken = new StringTokenizer(text, ",");
        while (textToken.hasMoreTokens()) {
            try {
                nowToken = textToken.nextToken();
                sum = sum + Integer.parseInt(nowToken);
            }

            catch (NumberFormatException notANumber){
                sum = sum + tokenParse(nowToken);
            }
        }
        return sum;
    }

    private int tokenParse(String tokenToParse){
        char nowTokenChar;
        int multChar = 1;
        int i;
        int j;

        for (j = 0; j < tokenToParse.length(); j++){
            nowTokenChar = tokenToParse.toUpperCase().charAt(j);
            for (i = A; i <= Z; i++) {
                if (nowTokenChar == i) {
                    multChar = multChar * (i - ASCII);
                }
            }
        }

        return multChar;
    }
}