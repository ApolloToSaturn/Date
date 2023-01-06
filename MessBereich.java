
public class MessBereich {
	private double von;
	private double bis;
	private double crit;
	
	
	public MessBereich(double von, double bis, double crit) {
		this.von = von;
		this.bis = bis;
		this.crit = crit;
	}
	
	void pruefen (double wert) throws IllegalValue, CriticalValue {
		if (wert < von || wert > bis) {
			throw new IllegalValue("Fehler: Illegaler Wert.");
		}
		
		if (wert >= crit && wert <= bis) {
			throw new CriticalValue("Fehler: Kritischer Wert.");
		}
		
	}
}
