import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Ellipse2D;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MouseInfo;
import java.awt.TextField;

/**
 * 
 * @author Maximilian Gerlach (m27937) & Renée Pauline von Bushe (m27428)
 *         Softwaretechnik Abgabe 1 
 * Date 22-10-2020 
 * Aufgabe Konfigurationsverwaltung und Java mittels Quellcodeverwaltung
 *         (arbeiten mit java.awt & Git)
 * Version 1.3
 *
 */

public class Window extends Frame implements WindowListener, MouseListener {

	public float x, y;
	int count = 0;
	int radius = 50;
	int xEins;
	int yEins;
	int xZwei;
	int yZwei;
	TextField area = new TextField(); // Textfield von Koordinate 1
	TextField area2 = new TextField(); // Textfield von Koordinate 2
	TextField area3 = new TextField(); // Textfield von Abstand der Koordinaten
	Graphics2D gd2;

	public Window() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose(); // Fenster schließen
				System.exit(0);
			}
		});
		setTitle("Aufgabe 1");
		setSize(500, 500);
		setLayout(null);
		setVisible(true);
		setBackground(Color.cyan);
		this.addMouseListener(this);

		MenuBar mb = new MenuBar();
		Menu background = new Menu("Hintergrund");
		MenuItem item1 = new MenuItem("Weiß");
		MenuItem item2 = new MenuItem("Gelb");
		MenuItem item3 = new MenuItem("Rot");
		MenuItem item4 = new MenuItem("Grün");
		MenuItem item5 = new MenuItem("Blau");
		MenuItem radius = new MenuItem("Radius");
		background.add(item1);
		background.add(item2);
		background.add(item3);
		background.add(item4);
		background.add(item5);
		background.add(radius);
		mb.add(background);
		setMenuBar(mb);

		item1.addActionListener(weiß);
		item2.addActionListener(gelb);
		item3.addActionListener(rot);
		item4.addActionListener(gruen);
		item5.addActionListener(blau);
		radius.addActionListener(r);

	}

	ActionListener r = new ActionListener() { // Actionlistener der für das Einstellen des Radius' zuständig ist

		@Override
		public void actionPerformed(ActionEvent arg0) {
			TextField input = new TextField();
			input.setBounds(300, 50, 100, 25); // Textfield von Radius wird geöffnet sobald im Menu angeklickt wurde,
												// Position & Größe von Textfield
			add(input);
			Button button = new Button("OK");
			button.setBounds(300, 75, 100, 50); // Position & Größe von Button
			add(button);
			button.addActionListener(new ActionListener() { // ActionListener für Button
				public void actionPerformed(ActionEvent e) {
					String string = input.getText();

					radius = Math.abs(Integer.parseInt(string)); // Zahlen welche in String string untergebracht wurden
																	// werden in Variable radius gepackt.

				}
			});

		}
	};

	ActionListener weiß = new ActionListener() { // ActionListener für Farben (für Hintergrundfarbe die über Menü
													// gesteuert wird)

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setBackground(Color.white);
			count = 0; // entfernen der Ellipsen weil beim Hintergrundwechsel die Kreise verschwinden

		}

	};
	ActionListener gelb = new ActionListener() { // ActionListener für Farben (für Hintergrundfarbe die über Menü
													// gesteuert wird)

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setBackground(Color.yellow);
			count = 0; // entfernen der Ellipsen weil beim Hintergrundwechsel die Kreise verschwinden

		}

	};

	ActionListener rot = new ActionListener() { // ActionListener für Farben (für Hintergrundfarbe die über Menü
												// gesteuert wird)

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setBackground(Color.red);
			count = 0; // entfernen der Ellipsen weil beim Hintergrundwechsel die Kreise verschwinden

		}

	};

	ActionListener gruen = new ActionListener() { // ActionListener für Farben (für Hintergrundfarbe die über Menü
													// gesteuert wird)

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setBackground(Color.green);
			count = 0; // entfernen der Ellipsen weil beim Hintergrundwechsel die Kreise verschwinden

		}

	};

	ActionListener blau = new ActionListener() { // ActionListener für Farben (für Hintergrundfarbe die über Menü
													// gesteuert wird)

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setBackground(Color.blue);
			count = 0; // entfernen der Ellipsen weil beim Hintergrundwechsel die Kreise verschwinden

		}

	};

	public void ellipsepaint(Graphics g) { // Aussehen & Zeichnen der Kreise
		gd2 = (Graphics2D) g;
		if (count < 2) { // zeichnet nur zwei Kreise
			Ellipse2D ellipse2D = new Ellipse2D.Float(x - radius / 2, y - radius / 2, radius, radius);
			gd2.draw(ellipse2D);
			count++;

		} else if (count == 2) { // bei einem dritten Kreis wird alles im Fenster gelöscht
			repaint();
			count = 0;
			remove(area);
			remove(area2);
			remove(area3);
		}

	}

	public void mouseClicked(MouseEvent e) { // platziert Ellipsen bei Doppelklick

		if (e.getClickCount() == 2) {
			ellipsepaint(getGraphics());
			if (count == 1) { //Koordinaten von Ellipse 1 werden für später aufgehoben
				xEins = MouseInfo.getPointerInfo().getLocation().x; 
				yEins = MouseInfo.getPointerInfo().getLocation().y;
				area.setText("(" + xEins + ", " + yEins + ")"); //Ausgabe der Koordinaten von Ellipse 1
				area.setBounds(400, 50, 100, 25);
				add(area);
			}

			if (count == 2) { //Koordinaten von Ellipse 2 werden für später aufgehoben
				xZwei = MouseInfo.getPointerInfo().getLocation().x;
				yZwei = MouseInfo.getPointerInfo().getLocation().y;
				area2.setText("(" + xZwei + ", " + yZwei + ")"); //Ausgabe der Koordinaten von Ellipse 2
				area2.setBounds(400, 75, 100, 25);
				add(area2);
				gd2.drawLine(xEins, yEins, xZwei, yZwei); //zeichnen der Linie welche die beiden Mittelpunkte der Ellipsen verbindet

				double ergebnis = Math.sqrt(Math.pow(xEins - xZwei, 2) + (Math.pow(yEins - yZwei, 2))); //Berechnung der Länge der Linien zwischen den Ellipsen
				area3.setText("Abstand: " + ergebnis);
				area3.setBounds(400, 100, 100, 25);
				add(area3);

			}
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) { //holen von x & y Koordinaten
		x = e.getX();
		y = e.getY();
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		dispose();

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
