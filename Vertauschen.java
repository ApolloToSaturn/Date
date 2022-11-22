import java.util.Arrays;
public class Vertauschen {
	public static void main (String[] args) {
		
		
		String[] test = new String[] {"ich", "habe", "kohldampf"};
		
		String[] inhalt = vertauscheInhalt(test);
		String[] referenz = vertauscheReferenz(test);
		
		System.out.println(Arrays.toString(referenz));
		System.out.println(Arrays.toString(inhalt));
		System.out.println(Arrays.toString(vertauscheInhalt(referenz)));
		System.out.println(Arrays.toString(vertauscheReferenz(referenz)));
		
		if(!testInhaltGleich(inhalt, referenz)) {
			System.out.println("Fehler: Inhalte stimmen nicht überein !");
		}
		
		if(testReferenzGleich(inhalt, referenz)) {
			System.out.println("Fehler: Referenzen muessen unterschiedlich sein !");
		}
		
	}
	public static String[] vertauscheInhalt(String[] args) {
		String tmp = "";
		String[] newInhalt = new String[args.length];
		for(int i=0; i < args.length;i++) {
			tmp = args[args.length - 1 - i];
			newInhalt[i] = tmp;
		}
		return newInhalt;
	}
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
			if(arg1[i] == arg2[i]) 
				return true;
				}
		return false;
	}
}
