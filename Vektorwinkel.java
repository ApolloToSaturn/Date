
public class Vektorwinkel {
	public static void main(String[] args) {
		
		double[] a = {1,2};
		double[] b = {2,1};
		
		
		System.out.println(winkel(a,b));
	}
	
	public static double winkel(double[] a, double[] b) {
		
		double skalar=skalar(a,b);
		double norm=norm(a)*norm(b);
		
		double ergebnis= skalar/norm;
		
		double winkel= Math.acos(ergebnis);
		
		double grad = grad(winkel);	
	
		return grad;
	}
	
	public static double skalar(double[] a, double[] b) {
	
		int dauer=a.length;
		System.out.println(dauer);
		double product = 0;
		double sum = 0;
		
		for(int i=1;i<=dauer;i++) {
			product = a[i] * b[i];
			sum = sum + product;
		}
		return sum;
	}
	public static double norm(double[] c) {
		
		double normVektor = Math.sqrt(skalar(c,c));
		
		return normVektor;
	}
	public static double grad(double winkel) {
		
		return (winkel*189/Math.PI);
	}
}
