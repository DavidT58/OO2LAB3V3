package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Krug {
	protected Vektor polozajCentra;
	protected Color boja;
	protected double precnik;
	
	public Krug(Vektor p, Color c, double pr) {
		polozajCentra = p;
		boja = c;
		precnik = pr;
	}
	
	public Vektor getPozicija() { return polozajCentra; }
	
	public boolean preklapaSe(Krug k) {
		double x = (polozajCentra.getX() - k.polozajCentra.getX()) * (polozajCentra.getX() - k.polozajCentra.getX());
		double y = (polozajCentra.getY() - k.polozajCentra.getY()) * (polozajCentra.getY() - k.polozajCentra.getY());
		
		double c1c2 = Math.sqrt(x + y);
		double r1r2 = precnik/2 + k.precnik/2;
		
		return (c1c2 <= r1r2);
	}
	
	public void iscrtaj(Scena s) {
		Graphics g = s.getGraphics();
		g.setColor(boja);
		g.fillOval((int)(polozajCentra.getX()), (int)(polozajCentra.getY()), (int)precnik, (int)precnik);
	}
	
}
