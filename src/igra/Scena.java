package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class Scena extends Canvas implements Runnable {

	Igra igra;
	Igrac igrac;
	Thread nit = new Thread(this);
	ArrayList<Balon> baloni;
	
	public Scena(Igra i) {
		igra = i;
		setBounds(0, 0, i.getWidth(), i.getHeight());
		baloni = new ArrayList<Balon>();
	}
	
	public void pokreni() {
		igrac = new Igrac(new Vektor(this.getWidth()/2, this.getHeight()-100), 30, new Vektor(0,0), this);
		
		nit.start();
	}
	
	public void zaustavi() {
		nit.interrupt();
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				generisiBalon();
				repaint();
				Thread.sleep(60);
			}
		} catch (InterruptedException e) {}
	}
	
	public void dodajFiguru(KruznaFigura k) {
		if(k instanceof Balon) {
			Balon b = (Balon)k;
			baloni.add(b);
		}
	}
	
	private void generisiBalon(){
		double verovatnoca = Math.random();
		if(verovatnoca <= 0.1) {
			Random r = new Random();
			int r1 = r.nextInt(igra.getWidth()-20);
			int r2 = r.nextInt(igra.getHeight()-200);
			Balon b = new Balon(new Vektor(r1, r2), Color.RED, 20, new Vektor(0,0), this);
			dodajFiguru(b);
		}
	}
	
	public void izbaciFiguru(KruznaFigura k) {
		if(k instanceof Balon) {
			baloni.remove(k);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		igrac.iscrtaj(this);
		for(Balon b : baloni)
			b.iscrtaj(this);
	}
}
