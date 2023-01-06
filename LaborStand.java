import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LaborStand {
	public static void main(String[] args) {
		Scanner sc = null;
		MessReihe messReihe = null;
		
		try {
			
			int maxAnzahlDatensaetze = Integer.parseInt(args[0]);
			
			sc = new Scanner (new File(args[1]));
			
			messReihe = new MessReihe(maxAnzahlDatensaetze);

			while(sc.hasNext()) {
				int u = sc.nextInt();
				double t = sc.nextDouble();
				double d = sc.nextDouble();
				messReihe.neueMessung(u, t, d);
			}
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("Fehler: Datei nicht gefunden.");
		} catch (InputMismatchException ime) {
			System.out.println("Fehler: Zahl in Datei falsch eingegeben");
		} catch (IllegalValue iv) {
			System.out.println("Fehler: Illegaler Parameter");
		} catch (TooMuchData tmd) {
			System.out.println("Fehler: Zu viele Datensätze.");
		} catch (CriticalValue cv) {
			System.out.println("Fehler: Kritischer Wert erreicht");
			System.exit(1);
		}
		
		finally {
			
			double[] mittelwerte = messReihe.ermittleMittelwerte();
			System.out.println("Durchschnitt von Umdrehungszahl: " + mittelwerte[0]);
			System.out.println("Durchschnitt von Temperatur    : " + mittelwerte[1]);
			System.out.println("Durchschnitt von Ladedruck     : " + mittelwerte[2]);	
			
			sc.close();	
		
		}
	}
}
