import java.util.Scanner;
import java.util.regex.Pattern;

public class MainClass {
    static Pattern patternIsbn10Alternative1 = Pattern.compile("\\d{9}(\\d|X)");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte ISBN10-Nummer eingeben: ");
        String strIsbn = sc.next().toUpperCase();

        if (patternIsbn10Alternative1.matcher(strIsbn).matches()) {
            System.out.println("ISBN10-Konformität ist " + isISBN10Correct(strIsbn) + "\n");
        } else {
            System.out.println("Falsches Format.");
        }
    }

    public static boolean isISBN10Correct(String strIsbn) {
        int[] intIsbn = strIsbnArrayToIntIsbnArray(strIsbn);

        int pruefZiffer = intIsbn[9];
        int summe = 0;
        for (int i = 0; i < intIsbn.length - 1; i++) {
            summe += intIsbn[i] * (i + 1);
        }
        System.out.println("Prüfziffer: " + pruefZiffer + ", Rest: " + (summe % 11));
        return ((summe % 11) == pruefZiffer);
    }

    public static int[] strIsbnArrayToIntIsbnArray(String strArray) {
        int[] intArray = new int[10];

        for (int i = 0; i < strArray.length(); i++) {
            if (i == 9 & isCharEqualsX(strArray.charAt(i))) {
                intArray[i] = 10;
            } else {
                intArray[i] = Integer.parseInt(String.valueOf(strArray.charAt(i)));
            }
        }
        return intArray;
    }

    public static boolean isCharEqualsX(char input) {
        return input == 'X';
    }
}