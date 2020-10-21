import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;  
import java.awt.event.WindowListener;
import java.awt.geom.Ellipse2D;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;



public class Window extends Frame implements WindowListener, MouseListener {
	
	public float x, y;
	int count = 0;
	
	

	public Window(){  
        addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                e.getWindow().dispose();  //Fenster schlieﬂen
                System.exit(0);
            }  
        });
        setTitle("Aufgabe 1");
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setBackground(Color.cyan);
        this.addMouseListener(this);
        
        MenuBar mb = new MenuBar();
        Menu background = new Menu("Hintergrund"); 
        MenuItem item1 = new MenuItem("Weiﬂ");
        MenuItem item2 = new MenuItem("Gelb");
        MenuItem item3 = new MenuItem("Rot");
        MenuItem item4 = new MenuItem("Gr¸n");
        MenuItem item5 = new MenuItem("Blau");
        background.add(item1);
        background.add(item2);
        background.add(item3);
        background.add(item4);
        background.add(item5);
        mb.add(background);
        setMenuBar(mb);
        
        item1.addActionListener(weiﬂ);
        item2.addActionListener(gelb);
        item3.addActionListener(rot);
        item4.addActionListener(gruen);
        item5.addActionListener(blau);
        
        
     } 
	
	ActionListener weiﬂ = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setBackground(Color.white);
			count = 0;
			
		}
		
	};
	
	ActionListener gelb = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setBackground(Color.yellow);
			count = 0;
			
		}
		
	};
	
	ActionListener rot = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setBackground(Color.red);
			count = 0;
			
		}
		
	};
	
	ActionListener gruen = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setBackground(Color.green);
			count = 0;
			
		}
		
	};
	
	ActionListener blau = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setBackground(Color.blue);
			count = 0;
			
		}
		
	};
	
	
	
	public void ellipsepaint(Graphics g) {
		System.out.println(count);
		Graphics2D gd2 = (Graphics2D)g;
		if(count < 2) {
		Ellipse2D ellipse2D = new Ellipse2D.Float(x-25,y-25,50,50); 
		
		
		gd2.draw(ellipse2D);
		count++;
		
		} else if(count == 2) {
			setBackground(Color.black);
			count = 0; 
			
			
		}

	}
    
    public void mouseClicked(MouseEvent e) {
    	
    	if (e.getClickCount() == 2) {
    		ellipsepaint(getGraphics());
    		
       }
    }
    

    
    public void mousePressed(MouseEvent e) {
       
    }

    public void mouseReleased(MouseEvent e) {
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

