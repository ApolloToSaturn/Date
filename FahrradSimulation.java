import java.util.*;

public class FahrradSimulation {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		int bit0;
		int bit1;
		int bit2;
		int bit3;
		int bit4;
		int bit5;
		int bit6;
		String schritt = "Schritt ";
		String treten = "[treten]";
		String bremsenVorne = "[bremsen vorne]";
		String bremsenHinten = "[bremsen hinten]";
		String handRechts = "[Hand rechts]";
		String handLinks = "[Hand links]";
		String abbiegenRe = "[abbiegen rechts]";
		String abbiegenLi = "[abbiegen links]";
		String geschw = " Geschwindigkeit=";
		String kmh = " km/h, ";
		String richtung = "Richtung=";
		String handRe = ", Hand rechts ist draussen";
		String handLi = ", Hand links ist draussen";
		String tooFast = "zu schnell";
		String wrongWay = "falsches Abbiegen";
		String aktion = "";
		String ausgabe = "";
		String haende = "";
		int geschwindigkeit = 0;
		int richt = 0;
		int counter = 0;
		boolean handReDraussen = false;
		boolean handLiDraussen = false;
		
		while(sc.hasNextInt()) {
			n = sc.nextInt();
			if(n > 0) {
				bit0 = n & 1;
				bit1 = (n >> 1) & 1;
				bit2 = (n >> 2) & 1;
				bit3 = (n >> 3) & 1;
				bit4 = (n >> 4) & 1;
				bit5 = (n >> 5) & 1;
				bit6 = (n >> 6) & 1;
			} else {
				System.out.println("[Ende]");
				return;
			}
			counter += 1;
			schritt = schritt + counter + ":";
			if(bit0 == 1) {
				geschwindigkeit += 5;
				aktion = aktion + treten;
				if(geschwindigkeit > 50) {
					System.out.println(tooFast);
					return;
				}
			}
			if(bit1 == 1) {
				geschwindigkeit -= 2;
				aktion = aktion + bremsenVorne;
				if(geschwindigkeit < 0) {
					geschwindigkeit = 0;
				}
			}
			if(bit2 == 1) {
				geschwindigkeit -= 1;
				aktion = aktion + bremsenHinten;
				if(geschwindigkeit < 0) {
					geschwindigkeit = 0;
				}
			}
			if(bit3 == 1) {
				aktion = aktion + handRechts;
				haende = handRe;
			}
			if(bit4 == 1) {
				aktion = aktion + handLinks;
				haende = handLi;
			}
			if(bit5 == 1) {
				if(handReDraussen & !handLiDraussen) {
					aktion = aktion + abbiegenRe;
					richt = richt + 90;
					if(richt == 360) {
						richt = 0;
					}
					handReDraussen = false;
				} else {
					System.out.println(wrongWay);
					return;
				}
			}
			if(bit6 == 1) {
				if(handLiDraussen & !handReDraussen) {
					aktion = aktion + abbiegenLi;
					richt = richt - 90;
					if(richt == -360) {
						richt = 0;
					}
					handLiDraussen = false;
				} else {
					System.out.println(wrongWay);
				}
			}
			
			if(bit3 == 1) {
				handReDraussen = true;
			} 
			if(bit4 == 1) {
				handLiDraussen = true;
			}
			if((bit3==1) & (bit4==1)) {
				aktion = aktion + "freihaendig";
				System.out.println(aktion);
				return;
			}
			ausgabe = schritt + aktion + geschw + geschwindigkeit + kmh + richtung + richt + haende;
			System.out.println(ausgabe);
			schritt = "Schritt ";
			aktion = "";
			haende = "";
		}
		sc.close();	
	}
}
