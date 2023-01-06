
public class MessReihe {
	private MessBereich mu;
	private MessBereich mt;
	private MessBereich md;
	private MessDatum[] messDaten;
	private int counter = 0;
	
	
	
	public MessReihe(int n) {
		messDaten = new MessDatum[n];
		mu = new MessBereich(0, 12000, 8000);
		mt = new MessBereich(0, 200, 150);
		md = new MessBereich(0, 6, 5);
	}
	
	void neueMessung(int u, double t, double d) throws IllegalValue, CriticalValue, TooMuchData {
		mu.pruefen(u);
		mt.pruefen(t);
		md.pruefen(d);
		if (counter == messDaten.length) {
			throw new TooMuchData("Fehler: Zu viele Daten");
		} else {
			messDaten[counter] = new MessDatum(u, t, d);
			this.counter++;
		}
	}
	
	double[] ermittleMittelwerte() {
		double uG = 0;
		double tG = 0;
		double dG = 0;
		
		for (int i=0;i<messDaten.length;i++) {
			uG += messDaten[i].getU();
			tG += messDaten[i].getT();
			dG += messDaten[i].getD();
		}
		
		uG /= messDaten.length;
		tG /= messDaten.length;
		dG /= messDaten.length;
		
		double[] mittelwerte = {uG, tG, dG};
		
		return mittelwerte;
	}
	
	
}
