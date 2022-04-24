import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.lang.Math.*;

public class Frame2 extends JFrame{

	private Manager m = new Manager();

	private JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9;
	private JLabel title, blank1, blank2, blank3, blank4, weak, salt, molarity, volume;
	private JButton back, next;
	private JSlider w_mol_s, s_mol_s, w_vol_s, s_vol_s;
	private JTextField w_mol_t, s_mol_t, w_vol_t, s_vol_t;

	public Frame2(){

		setTitle( "Buffer solution - Part 2" );
		setSize( 900,600 );
		setLayout( new BorderLayout() );



		Font f1 = new Font( "Arial", Font.BOLD, 45 );
		Font f2 = new Font( "Times New Roman", Font.PLAIN, 23 );
		Font f3 = new Font( "Times New Roman", Font.PLAIN, 20 );

		if( m.getC() ){
			title = new JLabel( "<html>Part 2: Specify Molarity and Volume<br>of Weak Acid and Conjugate Base</html>", SwingConstants.CENTER );
		}
		else{
			title = new JLabel( "<html>Part 2: Specify Molarity and Volume<br>of Weak Base and Conjugate Acid</html>", SwingConstants.CENTER );
		}
		title.setVerticalAlignment( SwingConstants.CENTER );
		title.setFont( f1 );
		title.setPreferredSize( new Dimension( 850,150 ) );

		add(title, BorderLayout.NORTH);



		p1 = new JPanel();
		p1.setPreferredSize( new Dimension( 720,80 ) );
		p1.setLayout( new GridLayout( 1, 3 ) ); //rows, columns

		p2 = new JPanel();
		p2.setPreferredSize( new Dimension( 735,160 ) );
		p2.setLayout( new GridLayout( 1, 3 ) ); //rows, columns

		p3 = new JPanel();
		p3.setPreferredSize( new Dimension( 735,160 ) );
		p3.setLayout( new GridLayout( 1, 3 ) ); //rows, columns

		p4 = new JPanel();
		p4.setPreferredSize( new Dimension( 245,150 ) );
		p4.setLayout( new FlowLayout() );

		p5 = new JPanel();
		p5.setPreferredSize( new Dimension( 245,150 ) );
		p5.setLayout( new FlowLayout() );

		p6 = new JPanel();
		p6.setPreferredSize( new Dimension( 245,150 ) );
		p6.setLayout( new FlowLayout() );

		p7 = new JPanel();
		p7.setPreferredSize( new Dimension( 245,150 ) );
		p7.setLayout( new FlowLayout() );

		p8 = new JPanel();
		p8.setPreferredSize( new Dimension( 750,440 ) );
		p8.setLayout( new FlowLayout() );


		blank1 = new JLabel( "" );
		blank1.setPreferredSize( new Dimension( 240,75 ) );


		weak = new JLabel( "weak", SwingConstants.CENTER );
		weak.setVerticalAlignment( SwingConstants.CENTER );
		weak.setFont( f2 );
		weak.setPreferredSize( new Dimension( 240,75 ) );


		salt = new JLabel( "salt", SwingConstants.CENTER );
		salt.setVerticalAlignment( SwingConstants.CENTER );
		salt.setFont( f2 );
		salt.setPreferredSize( new Dimension( 240,75 ) );


		molarity = new JLabel( "Molarity (M)", SwingConstants.CENTER );
		molarity.setVerticalAlignment( SwingConstants.CENTER );
		molarity.setFont( f2 );
		molarity.setPreferredSize( new Dimension( 240,180 ) );


		volume = new JLabel( "Volume (L)", SwingConstants.CENTER );
		volume.setVerticalAlignment( SwingConstants.CENTER );
		volume.setFont( f2 );
		volume.setPreferredSize( new Dimension( 240,180 ) );


		w_mol_t = new JTextField( "0.1 M", SwingConstants.CENTER );
		w_mol_t.setFont( f3 );
		w_mol_t.setPreferredSize( new Dimension( 100,35 ) );
		w_mol_t.setEditable(false);

		s_mol_t = new JTextField( "0.1 M", SwingConstants.CENTER );
		s_mol_t.setFont( f3 );
		s_mol_t.setPreferredSize( new Dimension( 100,35 ) );
		s_mol_t.setEditable(false);

		w_vol_t = new JTextField( "0.1 L", SwingConstants.CENTER );
		w_vol_t.setFont( f3 );
		w_vol_t.setPreferredSize( new Dimension( 100,35 ) );
		w_vol_t.setEditable(false);

		s_vol_t = new JTextField( "0.1 L", SwingConstants.CENTER );
		s_vol_t.setFont( f3 );
		s_vol_t.setPreferredSize( new Dimension( 100,35 ) );
		s_vol_t.setEditable(false);


		w_mol_s = new JSlider(JSlider.HORIZONTAL, 100, 1000, 100);
		w_mol_s.setPreferredSize( new Dimension( 200,100 ) );
		w_mol_s.addChangeListener(new w_mol_Listener());


		s_mol_s = new JSlider(JSlider.HORIZONTAL, 100, 1000, 100);
		s_mol_s.setPreferredSize( new Dimension( 200,100 ) );
		s_mol_s.addChangeListener(new s_mol_Listener());


		w_vol_s = new JSlider(JSlider.HORIZONTAL, 100, 500, 100);
		w_vol_s.setPreferredSize( new Dimension( 200,100 ) );
		w_vol_s.addChangeListener(new w_vol_Listener());


		s_vol_s = new JSlider(JSlider.HORIZONTAL, 100, 500, 100);
		s_vol_s.setPreferredSize( new Dimension( 200,100 ) );
		s_vol_s.addChangeListener(new s_vol_Listener());


		p4.add( w_mol_s );
		p4.add( w_mol_t );

		p5.add( s_mol_s );
		p5.add( s_mol_t );

		p6.add( w_vol_s );
		p6.add( w_vol_t );

		p7.add( s_vol_s );
		p7.add( s_vol_t );


		p1.add( blank1 );
		p1.add( weak );
		p1.add( salt );

		p2.add( molarity );
		p2.add( p4 );
		p2.add( p5 );
		
		p3.add( volume );
		p3.add( p6 );
		p3.add( p7 );

		p8.add( p1 );
		p8.add( p2 );
		p8.add( p3 );


		add(p8, BorderLayout.CENTER);

		p9 = new JPanel();
		p9.setPreferredSize( new Dimension( 170,400 ) );
		p9.setLayout( new FlowLayout() );

		blank2 = new JLabel( "" );
		blank2.setPreferredSize( new Dimension( 150,200 ) );
		p9.add( blank2 );


		back = new JButton( "<html>Back to<br>part 1</html>" );
		back.setFont( f2 );
		back.setPreferredSize( new Dimension( 110,60 ) );
		back.addActionListener( new backListener() );
		p9.add( back );

		blank3 = new JLabel( "" );
		blank3.setPreferredSize( new Dimension( 30,30 ) );
		p9.add( blank3 );

		next = new JButton( "<html>Go to<br>part 3</html>" );
		next.setFont( f2 );
		next.setPreferredSize( new Dimension( 110,60 ) );
		next.addActionListener( new nextListener() );
		p9.add( next );

		blank4 = new JLabel( "" );
		blank4.setPreferredSize( new Dimension( 30,30 ) );
		p9.add( blank4 );


		add(p9, BorderLayout.EAST);

		setResizable( false );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( false );
	}

	public void setManager(Manager m){
		this.m = m;
	}

	public void refresh(){
		if( m.getC() ){
			title.setText( "<html>Part 2: Specify Molarity and Volume<br>of Weak Acid and Conjugate Base</html>" );
			weak.setText( "<html>" + m.getAcid().get_formula_A() + "</html>" );
			if( m.getAcid().get_b()){
				salt.setText( "<html>Na" + m.getAcid().get_formula_CB() + "</html>" );
			}
			else{
				salt.setText( "<html>" + m.getAcid().get_formula_CB() + "Na</html>" );
			}
		}
		else{
			title.setText( "<html>Part 2: Specify Molarity and Volume<br>of Weak Base and Conjugate Acid</html>" );
			weak.setText( "<html>" + m.getBase().get_formula_B() + "</html>" );
			salt.setText( "<html>" + m.getBase().get_formula_CA() + "Cl</html>" );
		}
	}

	private class backListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println( "Volume of weak acid/base = " + m.get_w_vol() + " L" );
			System.out.println( "Volume of salt = " + m.get_s_vol() + " L" );
			System.out.println( "Molarity of weak acid/base = " + m.get_w_mol() + " M" );
			System.out.println( "Molarity of salt = " + m.get_s_mol() + " M" );

			m.set_totalV( m.get_w_vol() + m.get_s_vol() );
			m.set_w_mole( m.get_w_mol() * m.get_w_vol() / m.get_totalV() );
			m.set_s_mole( m.get_s_mol() * m.get_s_vol() / m.get_totalV() );
			if( m.getC() ){
				m.set_h_mole( ( - m.getKValue() - m.get_s_mole() + Math.sqrt( Math.pow(  m.getKValue() + m.get_s_mole(),2 ) + 4 * ( m.getKValue() * m.get_w_mole() + Manager.kw ) ) ) / 2.0 );
				m.set_s_mole( m.get_h_mole() - Manager.kw / m.get_h_mole() + m.get_s_mole() );
				m.set_w_mole( m.get_h_mole() * m.get_s_mole() / m.getKValue() );
			}
			else{
				m.set_h_mole( Manager.kw / ( ( - m.getKValue() - m.get_s_mole() + Math.sqrt( Math.pow(  m.getKValue() + m.get_s_mole(),2 ) + 4 * ( m.getKValue() * m.get_w_mole() + Manager.kw ) ) ) / 2.0 ) );
				m.set_s_mole( Manager.kw / m.get_h_mole() - m.get_h_mole()  + m.get_s_mole() );
				m.set_w_mole( Manager.kw * m.get_s_mole() / m.get_h_mole() / m.getKValue() );
			}

			System.out.println( "[weak acid/base] = " + m.get_w_mole() + " M" );
			System.out.println( "[salt] = " + m.get_s_mole() + " M" );
			System.out.println( "[H+] = " + m.get_h_mole() + " M" );

			m.back2();
		}
	}

	private class nextListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println( "Volume of weak acid/base = " + m.get_w_vol() + " L" );
			System.out.println( "Volume of salt = " + m.get_s_vol() + " L" );
			System.out.println( "Molarity of weak acid/base = " + m.get_w_mol() + " M" );
			System.out.println( "Molarity of salt = " + m.get_s_mol() + " M" );

			m.set_totalV( m.get_w_vol() + m.get_s_vol() );
			m.set_w_mole( m.get_w_mol() * m.get_w_vol() / m.get_totalV() );
			m.set_s_mole( m.get_s_mol() * m.get_s_vol() / m.get_totalV() );
			if( m.getC() ){
				m.set_h_mole( ( - m.getKValue() - m.get_s_mole() + Math.sqrt( Math.pow(  m.getKValue() + m.get_s_mole(),2 ) + 4 * ( m.getKValue() * m.get_w_mole() + Manager.kw ) ) ) / 2.0 );
				m.set_s_mole( m.get_h_mole() - Manager.kw / m.get_h_mole() + m.get_s_mole() );
				m.set_w_mole( m.get_h_mole() * m.get_s_mole() / m.getKValue() );
			}
			else{
				m.set_h_mole( Manager.kw / ( ( - m.getKValue() - m.get_s_mole() + Math.sqrt( Math.pow(  m.getKValue() + m.get_s_mole(),2 ) + 4 * ( m.getKValue() * m.get_w_mole() + Manager.kw ) ) ) / 2.0 ) );
				m.set_s_mole( Manager.kw / m.get_h_mole() - m.get_h_mole()  + m.get_s_mole() );
				m.set_w_mole( Manager.kw * m.get_s_mole() / m.get_h_mole() / m.getKValue() );
			}

			System.out.println( "[weak acid/base] = " + m.get_w_mole() + " M" );
			System.out.println( "[salt] = " + m.get_s_mole() + " M" );
			System.out.println( "[H+] = " + m.get_h_mole() + " M" );

			m.next2();
		}
	}

	private class w_mol_Listener implements ChangeListener {
		public void stateChanged( ChangeEvent e ) {
			m.set_w_mol( ( (double)w_mol_s.getValue() ) / 1000.0 );
			w_mol_t.setText( "" + m.get_w_mol() + " M" );
		}
	}

	private class s_mol_Listener implements ChangeListener {
		public void stateChanged( ChangeEvent e ) {
			m.set_s_mol( ( (double)s_mol_s.getValue() ) / 1000.0 );
			s_mol_t.setText( "" + m.get_s_mol() + " M" );
		}
	}

	private class w_vol_Listener implements ChangeListener {
		public void stateChanged( ChangeEvent e ) {
			m.set_w_vol( ( (double)w_vol_s.getValue() ) / 1000.0 );
			w_vol_t.setText( "" + m.get_w_vol() + " L" );
		}
	}

	private class s_vol_Listener implements ChangeListener {
		public void stateChanged( ChangeEvent e ) {
			m.set_s_vol( ( (double)s_vol_s.getValue() ) / 1000.0 );
			s_vol_t.setText( "" + m.get_s_vol() + " L" );
		}
	}

}