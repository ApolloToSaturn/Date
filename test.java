/**
 * Beispiel zum Einlesen von Daten von der Tastatur
 */
import java.util.*;

public class test {

    public static void main(String[] args) {

        // Scanner von der Tastatur anlegen
        Scanner sc = new Scanner(System.in);

        System.out.println("Geben Sie nacheinander Daten folgender Typen "
                           + "auf der Tastatur ein: "
                           + "byte, short, int, long, float, double, "
                           + "ein Zeichen (in einer eigene Zeile), "
                           + "eine Zeichenkette in einer eigenen Zeile");

        // Daten ueber den Scanner lesen
        byte b = sc.nextByte();
        short s = sc.nextShort();
        int i = sc.nextInt();
        long l = sc.nextLong();
        float f = sc.nextFloat();
        double d = sc.nextDouble();
        String s1 = sc.next();
        char c = s1.charAt(0);
        String s2 = sc.next();

        // eingelesene Daten ausgeben
        System.out.println("Die eingelesenen Werte sind: " + b + " "
                           + s + " " + i + " " + l + " " + f + " " + d
                           + " " + c + " " + s2);

        // Scanner abschliessen
        sc.close();
    }
}
