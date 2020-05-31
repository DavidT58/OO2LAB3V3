package igra;

import java.awt.Color;

public class KruznaFigura extends Krug {
	protected Vektor vektorBrzine;
	protected long vremeOdStvaranja= 0;
	protected Scena scena;
	protected boolean preklopljena;

	public KruznaFigura(Vektor p, Color c, double pr, Vektor br, Scena s) {
		super(p, c, pr);
		vektorBrzine = br;
		scena = s;
	}

	public boolean getPreklopljena() { return preklopljena; }
	
	public void setPreklopljena(boolean t) { preklopljena = t; }
	
	public synchronized void prosloVreme(int t) {
		vremeOdStvaranja += t;
		Vektor pomeraj = vektorBrzine.pomnozi(t);
		polozajCentra = polozajCentra.saberi(pomeraj);
	}
	
}
