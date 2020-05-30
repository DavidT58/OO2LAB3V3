package igra;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame {
	
	Scena s;
	
	public Igra() {
		super("Baloni");
		setSize(650, 650);
		
		s = new Scena(this);
		s.pokreni();
		
		
		add(s, BorderLayout.CENTER);
		
		dodajOsluskivace();
		
		setVisible(true);
	}
	
	private void dodajOsluskivace() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				s.zaustavi();
				dispose();
			}
		});
	}
}
