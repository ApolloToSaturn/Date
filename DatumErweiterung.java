import java.util.Scanner;

public class DatumErweiterung {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int j = scan.nextInt();
		int m = scan.nextInt();
		int t = scan.nextInt();
		int s = scan.nextInt();
		int m1 = scan.nextInt();
		int m2 = scan.nextInt();
		boolean langerMonat = ((m == 1) || (m == 3) || (m == 5) || (m == 7) || (m == 8) || (m == 10) || (m == 12)) && (t > 31);
		boolean kurzerMonat = ((m == 4) || (m == 6) || (m == 9) || (m == 11)) && (t > 30);
		boolean februar = (m == 2) && (t > 28);
		boolean years = (j >= 1600) && (j <= 3000);
		boolean months = (m >= 1) && (m <= 12);
		boolean days = (t >= 1) && (t <= 31);
		boolean hours = (s >= 0) && (s <= 23);
		boolean minminutes = (m1 >= 0) && (m1 <= 59);
		boolean plusminutes = (m2 >= 0) && (m2 <= 40000);
		
		if ((years) && (months) && (days) && (hours) && (minminutes) && (plusminutes)) { // Prüfen ob die eingegebenen Werte im Wertebereich sind
			if ((februar) || ((kurzerMonat) && (t > 30)) || ((langerMonat) && (t > 31))) { // Prüfen ob die eingegeben Tage zu den entsprechenden Monaten passt
						System.out.println("Der Monat " + m + " passt nicht zu den angegebenen Tagen " + t);
			} else { for (int i=1; i <= m2; i++) { // for-Schleife die so oft läuft, wie m2 (Minuten die dazu addiert werden) läuft 
				if (m1 + 1 > 59) {
					m1 = 0;			
			     	s = s + 1;
			     	if (s > 23) { // Prüfen ob die Stunden größer 23 sind, wenn ja dann s auf 0 setzen und den Tag + 1 rechnen
						 s = 0;
						 t = t + 1;
						 if ((februar)) { // Prüfen ob der Monat Februar ist und mehr als 28 Tage hat, dann Tag + 1 und Monat + 1 rechnen
							 t = 1;
							 m = m + 1;
						 } else { if ((kurzerMonat)) { // Prüfen ob der Monat zu den Monaten mit 30 Tagen zählt und ob dieser mehr als 30 Tage hat 
									m = m + 1;
								} else { if ((langerMonat)) {  // Prüfen ob der Monat zu den Monaten mit 31 Tagen zählt und ob dieser mehr als 31 Tage hat 
									t = 1;
									m = m + 1;
								} if (m > 12) { // wenn der Monat größer 12 ist, dann Tag auf 1, Monat auf 1 und das Jahr + 1 rechnen,
									t = 1;
									m = 1;
									j = j + 1;
								}
								}
						}
					} 
				}else { // Falls die Minuten nicht über 59 kommen, einfach + 1 rechnen
					m1 = m1 + 1;
				} 
			}
			}
		} else { // Ausgabe, falls einer der Werte nicht mit dem Wertebereich übereinstimmt
			System.out.println("Einer der Werte ist außerhalb des Wertebereichs"
					+ "\nDie Wertebereiche sind:"
					+ "\nJahr: 1600 <= " + j + " <= 3000"
					+ "\nMonat: 1 <= " + m + " <= 12"
					+ "\nTag: 1 <= " + t + " <= 31 - Ausnahmen sind hier zudem noch die unterschiedlichen Längen der einzelnen Monate"
					+ "\nStunden: 0 <= " + s + " <= 23"
					+ "\nMinuten: 0 <= " + m1 + " <= 59"
					+ "\nMinuten plus: 0 <= "+ m2 + " <= 40000"
					+ "\nBitte Eingabe korrigieren.");
		}
		System.out.println(j + " " + m + " " + t + " " + s + " " + m1 + "\n"); // Ausgabe des errechneten Wertes
		scan.close();
	}	
}
