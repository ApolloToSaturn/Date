import java.util.Arrays;

public class Vertauschen {
	public static void main (String[] args) {
				
		String[] inhalt = vertauscheInhalt(args);
		String[] referenz = vertauscheReferenz(args);
		
		System.out.println(Arrays.toString(referenz));
		System.out.println(Arrays.toString(inhalt));
		System.out.println(Arrays.toString(vertauscheInhalt(referenz)));
		System.out.println(Arrays.toString(vertauscheReferenz(referenz)));
		System.out.println(referenz);
		System.out.println(inhalt);
		
		if(!testInhaltGleich(inhalt, referenz)) {
			System.out.println("Fehler: Inhalte stimmen nicht überein !");
		}
		
		if(testReferenzGleich(inhalt, referenz)) {
			System.out.println("Fehler: Referenzen muessen unterschiedlich sein !");
		}
		
	}
	public static String[] vertauscheInhalt(String[] args) {
		String[] newInhalt = new String[args.length];
		for(int i=0; i < args.length;i++) {
			String tmp = "";
			tmp = args[args.length - 1 - i];
			newInhalt[i] = tmp;
		}
		return newInhalt;
	}
	/*public static String[] vertauscheReferenz(String[] args) {
		String[] newReferenz = new String[args.length];
		for(int i=0; i < args.length;i++) {
			newReferenz[i] = args[args.length - 1 - i];
		}
		return newReferenz;
	}*/
	public static String[] vertauscheReferenz(String[] args) {
		String[] newReferenz = new String[args.length];
		for(int i=0; i < args.length;i++) {
			newReferenz[i] = args[args.length - 1 - i];
		}
		return newReferenz;
	}
	
	
	public static boolean testInhaltGleich(String[] arg1, String[] arg2) {
		for(int i=0; i < arg1.length;i++) {
			if(!arg1[i].equals(arg2[i])) {
				return false;
			}
		}
		return true;
		
	}
	public static boolean testReferenzGleich(String[] arg1, String[] arg2) {
		for(int i=0; i < arg1.length;i++) {
			if(arg1[i] != arg2[i]) {
				return false;
			}
		}
		return true;
	}
}
