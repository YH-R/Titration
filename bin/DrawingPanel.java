import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawingPanel extends JPanel{

	private final Color BLUE = new Color( 96,223,229 );
	private final Color CORAL = new Color( 255,127,80 );
	private final Color SILVER = new Color( 192, 192, 192 );
	private final Color PURPLE = new Color( 76, 0, 153 );
	private final Color BLACK = new Color( 0, 0, 0 );

	private JLabel wl, sl, hl;

	private double mol_w, mol_s, mol_h;
	private boolean c; // true means acid

	private String weakname = "";
	private String saltname = "";
	
	public DrawingPanel( double mol_w, double mol_s, double mol_h, boolean c ){
		super();
		setPreferredSize( new Dimension( 400, 270 ) ); //width, height
		setLayout(null);

		this.mol_w = mol_w;
		this.mol_s = mol_s;
		this.mol_h = mol_h;
		this.c = c;

		wl = new JLabel( "", SwingConstants.CENTER );
		sl = new JLabel( "", SwingConstants.CENTER );
		hl = new JLabel( "", SwingConstants.CENTER );

		wl.setBounds( 1, 210, 90, 40 );
		sl.setBounds( 106, 210, 90, 40 );
		hl.setBounds( 211, 210, 90, 40 );

		add(wl);
		add(sl);
		add(hl);
	}

	protected void paintComponent( Graphics g ){
		super.paintComponent(g);

		g.setFont( new Font( "Times New Roman", Font.PLAIN, 20 ) );		

		g.setColor( BLUE );
		g.fillRect( 0, (int)( ( 1.0 - mol_w ) * 200.0 ), 90, (int)( mol_w * 200.0 ) );

		g.setColor( CORAL );
		g.fillRect( 105, (int)( ( 1.0 - mol_s ) * 200.0 ), 90, (int)( mol_s * 200.0 ) );

		if( c ){
			g.setColor( SILVER );
		}
		else{
			g.setColor( PURPLE );
		}

		g.fillRect( 210, (int)( ( 1.0 - mol_h ) * 200.0 ), 90, (int)( mol_h * 200.0 ) );

		g.setColor( BLACK );

		g.fillRect( 0, 0, 300, 1 );

		g.drawString( "1.0 M", 320, 16 );
	}



	public void setName( String wn, String sn, boolean b ){
		weakname = wn;
		saltname = sn;

		wl.setText( "<html>[" + weakname + "]</html>]</html>" );

		if( c ){
			hl.setText( "<html>[H<sub>3</sub>0<sup>+</sup>]</html>" );
		}
		else{
			hl.setText( "<html>[0H<sup>-</sup>]</html>" );
		}

		if( b ){
			sl.setText( "<html>[" + saltname + "<sup>-</sup>]</html>" );
		}
		else{
			sl.setText( "<html>[" + saltname + "<sup>+</sup>]</html>" );
		}
	}

	public void setValue(double mol_w, double mol_s, double mol_h){
		this.mol_w = mol_w;
		this.mol_s = mol_s;
		this.mol_h = mol_h;

		repaint();
	}
	

}