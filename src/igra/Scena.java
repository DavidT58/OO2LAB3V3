package igra;

import java.awt.Canvas;

public class Scena extends Canvas implements Runnable {

	Igra igra;
	Igrac igrac;
	
	public Scena(Igra i) {
		igra = i;
	}
	
	public void pokreni() {
		igrac = new Igrac(new Vektor(this.getWidth()/2, this.getHeight()-50), 30, new Vektor(0,0), this);
	}
	
	public void zaustavi() {
		
	}
	
	@Override
	public void run() {
		
	}

}
