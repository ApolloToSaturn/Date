/** (xi, yi) i = 0,1,2,... n-1
 *  vom 0. Punkt Linie zum 1. Punkt. 1. Punkt Linie 2. Punkt...
 *  
 *  Fläche: Summe n-1  ((xi + xi+1) * (y i+1 - yi))
 *  		i = 0					2
 * 
 * 	indexausdruck i+1 modulo n 
 * 	z. B. n = 4 --> ((x3 + x0) * (y0 - y3)) weil 3+1 modulo 4 = 0
 
 * @author korbi
 *
 */
public class FlaecheBerechnen {
	public static void main(String[] args) {
		
		float[][] a = { {0,0},{1,0},{0,1},{1,1} };
		
		System.out.println(a.length);
		System.out.println(a[0].length);
		
		System.out.println(flaecheBerechnen(a));
	}
	public static float flaecheBerechnen(float[][] coord) {
		
		int n=coord.length;
		float xWert = 0;
		float yWert = 0;
		float xMaly = 0;
		float ergebnis = 0;
		
		
		for(int i=0; i<n; i++) {
				xWert = coord[0][0] + coord[i+1][0];
				yWert =  coord[0][i+1] - coord[0][0];
				xMaly = xWert * yWert;
				ergebnis += xMaly;
		}
		ergebnis = ergebnis/2;
			
		return ergebnis;
	}
}
