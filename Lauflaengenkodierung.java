
import java.util.*;

public class Lauflaengenkodierung {
	
	public static void main(String[] args) {
	
		int n = 1;
		int w;
		String s = "";
		
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		w = i;
		
		while(sc.hasNextInt()) {
			i = sc.nextInt();
			
			if(i == w) {
				
				n = n + 1;
				w = i;
			} else if (i != w) {
					s = s + n + "x" + w + ". ";
					w = i;
					n = 1;
			}
		}
		System.out.println(s);
		sc.close();
	}
}