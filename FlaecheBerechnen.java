/**  
 * @author
 */
public class FlaecheBerechnen {
	/*public static void main(String[] args) {
		
	}
	*/
	public static float flaecheBerechnen(float[][] coord) {
		
		int n=coord.length;
		float xWert = 0;
		float yWert = 0;
		float xMaly = 0;
		float ergebnis = 0;
		
		
		for(int i=0; i<n; i++) {
				xWert = coord[i][0] + coord[(i+1)%n][0];
				yWert =  coord[(i+1)%n][1] - coord[i][1];
				xMaly = xWert * yWert;
				ergebnis += xMaly;
		}
		ergebnis = Math.abs(ergebnis/2);
			
		return ergebnis;
	}
}
