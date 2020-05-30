package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Balon extends KruznaFigura {

	public Balon(Vektor p, Color c, double pr, Vektor br, Scena s) {
		super(p, c, pr, br, s);
	}
	
	
	
	public void iscrtaj(Scena s) {
		Graphics g = s.getGraphics();
		g.setColor(boja);
		g.fillOval((int)polozajCentra.getX(), (int)polozajCentra.getY(), 20, 20);
	}
}
