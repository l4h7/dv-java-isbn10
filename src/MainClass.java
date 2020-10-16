import java.util.Scanner;
import java.util.regex.Pattern;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] intIsbn = new int[10];

        System.out.println("Bitte ISBN10-Nummer eingeben: ");
        String strIsbn = sc.next();

        if (isbn10Format(strIsbn)) {
            int lauf = intIsbn.length;
            String pruefZiffer = String.valueOf(strIsbn.charAt(strIsbn.length() - 1)).toUpperCase();
            if (pruefZiffer.equals("X")) {
                lauf--;
                intIsbn[intIsbn.length - 1] = 10;
            }
            for (int i = 0; i < lauf; i++) {
                intIsbn[i] = Integer.parseInt(String.valueOf(strIsbn.charAt(i)));
            }
            System.out.println("ISBN10-Konformität ist " + pruefeIsbn10(intIsbn) + "\n");
        } else {
            System.out.println("Falsches Format.");
        }
    }

    public static boolean isbn10Format(String isbn) {
        Pattern pIsbn = Pattern.compile("^\\d[0-9]{9}$|^\\d[0-9]{8}[x,X]$");
        return pIsbn.matcher(isbn).find();
    }

    public static boolean pruefeIsbn10(int[] isbn) {
        int pruefZiffer = isbn[9];
        int summe = 0;
        for (int i = 0; i < isbn.length - 1; i++) {
            summe += isbn[i] * (i + 1);
        }

        System.out.println("Prüfziffer: " + pruefZiffer + ", Rest: " + (summe % 11));

        return ((summe % 11) == pruefZiffer);
    }
}