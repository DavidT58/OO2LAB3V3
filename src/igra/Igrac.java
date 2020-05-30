package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends KruznaFigura {
	
	public Igrac(Vektor p, double pr, Vektor br, Scena s) {
		super(p, Color.GREEN, pr, br, s);
	}
	
	@Override
	public void iscrtaj(Scena s) {
		super.iscrtaj(s);
		Graphics g = s.getGraphics();
		g.setColor(Color.BLUE);
		int xpos = (int)(polozajCentra.getX() + precnik/4);
		int ypos = (int)(polozajCentra.getY() + precnik/4);
		g.fillOval(xpos, ypos, (int)precnik/2, (int)precnik/2);
	}

}
