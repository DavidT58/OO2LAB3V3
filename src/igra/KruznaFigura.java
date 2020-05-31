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
	
	public synchronized void prosloVreme(double t) {
		vremeOdStvaranja += t;
		System.out.println("Pre pomeranja: " + polozajCentra.getX() + " " + polozajCentra.getY());
		System.out.println("Vekt Brzine pre: " + vektorBrzine.getX() + " " + vektorBrzine.getY());
		System.out.println("Vreme / 1000 " + t/1000);
		Vektor pomeraj = vektorBrzine.pomnozi(t/1000);
		System.out.println("Vekt Brzine posle: " + vektorBrzine.getX() + " " + vektorBrzine.getY());
		polozajCentra = polozajCentra.saberi(pomeraj);
		System.out.println("Posle pomeranja: " + polozajCentra.getX() + " " + polozajCentra.getY());
	}
	
}
