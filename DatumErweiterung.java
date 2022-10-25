import java.util.*;

public class DatumErweiterung {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int j = scan.nextInt();
		int m = scan.nextInt();
		int t = scan.nextInt();
		int s = scan.nextInt();
		int m1 = scan.nextInt();
		int m2 = scan.nextInt();
		boolean langerMonat = (m == 1) || (m == 3) || (m == 5) || (m == 7) || (m == 8) || (m == 10) || (m == 12);
		boolean kurzerMonat = (m == 4) || (m == 6) || (m == 9) || (m == 11);
		boolean februar = (m == 2);
		//boolean maxTage1 = t > 31;
		//boolean maxTage2 = t >= 30;
		//boolean maxTage3 = t > 28;
		
		if ((j >= 1600) && (j <= 3000)) { // Prüfen ob das Jahr im Wertebereich liegt
			if ((m >= 1) && (m <= 12)) { // Prüfen ob der Monat im Wertebereich liegt
				if ((t >= 1) && (t <= 31)) { // Prüfen ob der Tag im Wertebereich liegt
					if (((februar) && (t > 28)) || ((kurzerMonat) && (t > 30)) || ((langerMonat) && (t > 31))) {
						System.out.println("Der Monat " + m + " passt nicht zu den angegebenen Tagen " + t);
					} else { if ((s >= 0) && (s <= 23)) { // Prüfen ob die Stunde im Wertebereich liegt
								if ((m1 >= 0 ) && (m1 <= 59)) { // Prüfen ob die Minuten im Wertebereich liegt
									if ((m2 >= 0) && (m2 <= 40000)) { // Prüfen ob die Minuten (die addiert werden) im Wertebereich liegt
										for (int i=1; i <= m2; i++) { // for-Schleife die so oft läuft, wie m2 (Minuten die dazu addiert werden) läuft 
											if (m1 + 1 > 59) { // Prüfen ob m1 + 1 größer 59 ist, wenn ja dann m1 auf 0 setzen und die Stunde + 1 rechnen
												m1 = 0;
												s = s + 1;
												if (s > 23) { // Prüfen ob die Stunden größer 23 sind, wenn ja dann s auf 0 setzen und den Tag + 1 rechnen
													s = 0;
													t = t + 1;
													if ((februar) && (t > 28)) { // Prüfen ob der Monat zu den Monaten mit 31 Tagen zählt und ob dieser mehr als 31 Tage hat
														t = 1;
														m = m + 1;
													} else { if ((kurzerMonat) && (t > 30)) { // Prüfen ob der Monat zu den Monaten mit 30 Tagen zählt und ob dieser mehr als 30 Tage hat 
														t = 1;
														m = m + 1;
														} else { if ((langerMonat) && (t > 31)) {
															t = 1;
															m = m + 1;
														}
															if (m > 12) { // wenn der Monat größer 12 ist, dann Tag auf 1, Monat auf 1 und das Jahr + 1 rechnen,
																t = 1;
																m = 1;
																j = j + 1;
																if (j > 3000) { // Wenn das Jahr größer als 3000 ist, angeben, dass der Wertebereich überschritten wurde
																	System.out.println("Das Jahr " + j + " befindet sich außerhalb des Wertebereichs von kleiner gleich 3000");
																}
															}
														}
													}
												}
											} else {
												m1 = m1 + 1;
											}
										} 
										System.out.println(j + " " + m + " " + t + " " + s + " " + m1);
									} else {
										System.out.println("Die Minuten " + m2 + " befindet sich außerhalb des Wertebereichs größer gleich 0 und kleiner gleich 40000.");
									}
								} else {
									System.out.println("Die Minuten " + m1 + " befindet sich außerhalb des Wertebereichs größer gleich 0 und kleiner gleich 59.");
								}
							} else {
								System.out.println("Die Stunden " + s + " befindet sich außerhalb des Wertebereichs größer gleich 0 und kleiner gleich 23.");
						}
					}	
				} else {
					System.out.println("Der Tag " + t + " befindet sich außerhalb des Wertebereichs größer gleich 1 und kleiner gleich 31.");
				}
			} else {
				System.out.println("Der Monat " + m + " befindet sich außerhalb des Wertebereichs größer gleich 1 und kleiner gleich 12.");
			}
		} else {
			System.out.println("Das Jahr " + j + " befindet sich außerhalb des Wertebereichs größer gleich 1600 und kleiner gleich 3000.");
		}		
	scan.close();
	}
}


 /* 	if (langerMonat && maxTage1) { // Prüfen ob der Monat zu den Monaten mit 31 Tagen zählt und ob dieser mehr als 31 Tage hat
												t = 1;
												m = m + 1;
												if (m > 12) { // wenn der Monat größer 12 ist, dann Tag auf 1, Monat auf 1 und das Jahr + 1 rechnen,
													t = 1;
													m = 1;
													j = j + 1;
													if (j > 3000) { // Wenn das Jahr größer als 3000 ist, angeben, dass der Wertebereich überschritten wurde
														System.out.println("Das Jahr " + j + " befindet sich außerhalb des Wertebereichs von kleiner gleich 3000");
													}
												} else { // Falls Monat kleiner 12, Tag auf 1 setzen und Monat + 1
													t = 1;
													m = m + 1;
													}
											} else if (kurzerMonat && maxTage2) { // Prüfen ob der Monat zu den Monaten mit 30 Tagen zählt und ob dieser mehr als 30 Tage hat 
													t = 1;
													m = m + 1;
													} else if (februar && maxTage3) {
															t = 1;
															m = m + 1; */
