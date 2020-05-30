package igra;

import java.awt.Canvas;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Scena extends Canvas implements Runnable {

	Igra igra;
	Igrac igrac;
	Thread nit = new Thread(this);
	
	public Scena(Igra i) {
		igra = i;
		setBounds(0, 0, i.getWidth(), i.getHeight());
	}
	
	public void pokreni() {
		igrac = new Igrac(new Vektor(this.getWidth()/2, this.getHeight()-100), 30, new Vektor(0,0), this);
		//igrac = new Igrac(new Vektor(50, 50), 30, new Vektor(0,0), this);
		nit.start();
	}
	
	public void zaustavi() {
		nit.interrupt();
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				repaint();
				Thread.sleep(60);
			}
		} catch (InterruptedException e) {}
	}
	
	@Override
	public void paint(Graphics g) {
		igrac.iscrtaj(this);
		
	}
}
