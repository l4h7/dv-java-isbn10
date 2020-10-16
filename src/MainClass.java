import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] isbn = new int[10];

        System.out.println("Bitte ISBN10-Nummer eingeben: ");
        String test = sc.next();

        if (test.isEmpty()) {
            System.out.println("Sie haben nichts eingegeben.");
        } else if (test.length() != 10) {
            System.out.println("Die ISBN muss genau 10 Ziffern haben.");
        } else {
            try {
                switch (test.charAt(test.length() - 1)) {
                    case 'x':
                    case 'X':
                        //alle Werte bis auf die Prüfziffer werden ins Array isbn geladen
                        for (int i = 0; i < test.length() - 1; i++) {
                            isbn[i] = Integer.parseInt(String.valueOf(test.charAt(i)));
                        }
                        //dann "manuelle" Zuweisung der Prüfziffer 10 als letzter Wert im Array isbn
                        isbn[isbn.length - 1] = 10;
                        break;
                    default:
                        for (int i = 0; i < test.length(); i++) {
                            isbn[i] = Integer.parseInt(String.valueOf(test.charAt(i)));

                        }
                }
                if (pruefeIsbn10(isbn)) {
                    System.out.println("Eingegebene ISBN10-Nummer ist korrekt.");
                } else {
                    System.out.println("Eingegebene ISBN10-Nummer falsch.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Es dürfen nur Ziffern von 0-9 eingegeben werden. " + e);
            }
        }
    }

    public static boolean pruefeIsbn10(int[] isbn) {
        int pruefZiffer = isbn[9];
        int summe = 0;

        System.out.println("Prüfziffer: " + pruefZiffer);

        for (int i = 0; i < isbn.length - 1; i++) {
            summe += isbn[i] * (i + 1);
        }
        if ((summe % 11) == pruefZiffer) {
            return true;
        }
        return false;
    }
}