package igra;

public class Vektor {
	private double x, y;
	
	public Vektor(double xx, double yy) {
		x = xx;
		y = yy;
	}
	
	public double getX() { return x; }
	
	public double getY() { return y; }
	
	public void pomnozi(double v) { x *= v; y *= v; }
	
	public Vektor saberi(Vektor v) { return new Vektor(x+v.x, y+v.y); }
}
