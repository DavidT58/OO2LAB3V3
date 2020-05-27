package igra;

import java.awt.Color;

public class KruznaFigura extends Krug {
	protected Vektor vektorBrzine;
	protected Scena scena;

	public KruznaFigura(Vektor p, Color c, double pr, Vektor br, Scena s) {
		super(p, c, pr);
		vektorBrzine = br;
		scena = s;
	}

	
	
}
