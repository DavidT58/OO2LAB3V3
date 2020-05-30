package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class Scena extends Canvas implements Runnable {

	Igra igra;
	Igrac igrac;
	Thread nit = new Thread(this);
	ArrayList<KruznaFigura> figure;
	
	public Scena(Igra i) {
		igra = i;
		setBounds(0, 0, i.getWidth(), i.getHeight());
		figure = new ArrayList<KruznaFigura>();
		
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				repaint();
				generisiBalon();
				proveriPreklapanja();
				
				Thread.sleep(60);
			}
		} catch (InterruptedException e) {}
	}
	
	public void pokreni() {
		igrac = new Igrac(new Vektor(this.getWidth()/2, this.getHeight()-100), 30, new Vektor(0,0), this);
		//figure.add(igrac);
		nit.start();
	}
	
	public synchronized void zaustavi() {
		if(nit != null && nit.isAlive())
			nit.interrupt();
		nit = null;
	}
	
	public void dodajFiguru(KruznaFigura k) {
		if(k instanceof Balon) {
			Balon b = (Balon)k;
			figure.add(b);
		}
	}
	
	public void izbaciFiguru(KruznaFigura k) {
		figure.remove(k);
	}
	
	private void generisiBalon(){
		double verovatnoca = Math.random();
		if(verovatnoca <= 0.1) {
			Random r = new Random();
			int r1 = r.nextInt(igra.getWidth());
			int r2 = r.nextInt(igra.getHeight());
			Balon b = new Balon(new Vektor(r1, r2), Color.RED, 20, new Vektor(0,0), this);
			dodajFiguru(b);
		}
	}
	
	private void proveriPreklapanja() {
		for(KruznaFigura i: figure) {
			for(KruznaFigura j: figure) {
				if(i.preklapaSe(j) && !i.equals(j)) {
					i.setPreklopljena(true);
					j.setPreklopljena(true);
				}
			}
			if(igrac.preklapaSe(i)) {
				System.out.println("Igra zaustavljena");
				zaustavi();	
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		igrac.iscrtaj(this);
		for(KruznaFigura k: figure)
			k.iscrtaj(this);
	}
}
