package buffer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Frame3 extends JFrame{

	private Manager m = new Manager();

	private JPanel p, p1, p2, p3, p4, p5;
	private JLabel title, HCl, NaOH, molarity, blank, blank1, blank2, blank3;
	private JButton back, next;
	private JSlider mol_SA_s, mol_SB_s;
	private JTextField mol_SA_t, mol_SB_t;

	public Frame3(){

		setTitle( "Buffer solution - Part 3" );
		setSize( 900,600 );
		setLayout( new BorderLayout() );



		Font f1 = new Font( "Arial", Font.BOLD, 45 );
		Font f2 = new Font( "Times New Roman", Font.PLAIN, 24 );
		Font f3 = new Font( "Times New Roman", Font.PLAIN, 20 );

		title = new JLabel( "<html>Part 3: Specify Molarity of<br>Stong Acid and Strong Base</html>", SwingConstants.CENTER );
		title.setVerticalAlignment( SwingConstants.CENTER );
		title.setFont( f1 );
		title.setPreferredSize( new Dimension( 850,150 ) );

		add( title, BorderLayout.NORTH );


		p1 = new JPanel();
		p1.setPreferredSize( new Dimension( 735,320 ) );
		p1.setLayout( new GridLayout( 2, 1 ) ); //rows, columns

		p2 = new JPanel();
		p2.setPreferredSize( new Dimension( 735,130 ) );
		p2.setLayout( new GridLayout( 1, 3 ) ); //rows, columns

		p3 = new JPanel();
		p3.setPreferredSize( new Dimension( 735,160 ) );
		p3.setLayout( new GridLayout( 1, 3 ) ); //rows, columns

		p4 = new JPanel();
		p4.setPreferredSize( new Dimension( 245,140 ) );
		p4.setLayout( new FlowLayout() );

		p5 = new JPanel();
		p5.setPreferredSize( new Dimension( 245,140 ) );
		p5.setLayout( new FlowLayout() );


		blank = new JLabel( "" );

		HCl = new JLabel( "HCl (Strong Acid)", SwingConstants.CENTER );
		HCl.setVerticalAlignment( SwingConstants.CENTER );
		HCl.setFont( f2 );
		HCl.setPreferredSize( new Dimension( 120,190 ) );

		NaOH = new JLabel( "NaOH (Strong Base)", SwingConstants.CENTER );
		NaOH.setVerticalAlignment( SwingConstants.CENTER );
		NaOH.setFont( f2 );
		NaOH.setPreferredSize( new Dimension( 120,190 ) );


		molarity = new JLabel( "Molarity (M)", SwingConstants.CENTER );
		molarity.setVerticalAlignment( SwingConstants.TOP );
		molarity.setFont( f2 );
		molarity.setPreferredSize( new Dimension( 240,180 ) );


		mol_SA_t = new JTextField( "0.1 M", SwingConstants.CENTER );
		mol_SA_t.setFont( f3 );
		mol_SA_t.setPreferredSize( new Dimension( 100,35 ) );
		mol_SA_t.setEditable(false);

		mol_SB_t = new JTextField( "0.1 M", SwingConstants.CENTER );
		mol_SB_t.setFont( f3 );
		mol_SB_t.setPreferredSize( new Dimension( 100,35 ) );
		mol_SB_t.setEditable(false);


		mol_SA_s = new JSlider(JSlider.HORIZONTAL, 100, 5000, 100);
		mol_SA_s.setPreferredSize( new Dimension( 200,50 ) );
		mol_SA_s.addChangeListener(new mol_SA_Listener());

		mol_SB_s = new JSlider(JSlider.HORIZONTAL, 100, 5000, 100);
		mol_SB_s.setPreferredSize( new Dimension( 200,50 ) );
		mol_SB_s.addChangeListener(new mol_SB_Listener());

		p4.add(mol_SA_s);
		p4.add(mol_SA_t);
		
		p5.add(mol_SB_s);
		p5.add(mol_SB_t);

		p2.add( blank );
		p2.add( HCl );
		p2.add( NaOH );

		p3.add( molarity );
		p3.add( p4 );
		p3.add( p5 );


		p1.add( p2 );
		p1.add( p3 );


		add( p1, BorderLayout.CENTER );



		p = new JPanel();
		p.setPreferredSize( new Dimension( 170,400 ) );
		p.setLayout( new FlowLayout() );

		blank1 = new JLabel( "" );
		blank1.setPreferredSize( new Dimension( 150,100 ) );
		p.add( blank1 );


		back = new JButton( "<html>Back to<br>part 2</html>" );
		back.setFont( f2 );
		back.setPreferredSize( new Dimension( 110,60 ) );
		back.addActionListener( new backListener() );
		p.add( back );

		blank2 = new JLabel( "" );
		blank2.setPreferredSize( new Dimension( 30,30 ) );
		p.add( blank2 );

		next = new JButton( "<html>Go to<br>part 4</html>" );
		next.setFont( f2 );
		next.setPreferredSize( new Dimension( 110,60 ) );
		next.addActionListener( new nextListener() );
		p.add( next );

		blank3 = new JLabel( "" );
		blank3.setPreferredSize( new Dimension( 30,30 ) );
		p.add( blank3 );


		add( p, BorderLayout.EAST );


		setResizable( false );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( false );
	}

	public void setManager(Manager m){
		this.m = m;
	}

	private class backListener implements ActionListener{
		public void actionPerformed( ActionEvent e ){
			System.out.println( "Mol_SA = " + m.get_SA_mol() + " M" );
			System.out.println( "Mol_SB = " + m.get_SB_mol() + " M" );

			m.back3();
		}
	}

	private class nextListener implements ActionListener{
		public void actionPerformed( ActionEvent e ){
			System.out.println( "Mol_SA = " + m.get_SA_mol() + " M" );
			System.out.println( "Mol_SB = " + m.get_SB_mol() + " M" );


			m.get_frame4().refresh();
			m.get_frame4().revalidate();


			m.next3();
		}
	}

	private class mol_SA_Listener implements ChangeListener {
		public void stateChanged( ChangeEvent e ) {
			m.set_SA_mol( ( (double)mol_SA_s.getValue() ) / 1000.0 );
			mol_SA_t.setText( "" + m.get_SA_mol() + " M" );
		}
	}

	private class mol_SB_Listener implements ChangeListener {
		public void stateChanged( ChangeEvent e ) {
			m.set_SB_mol( ( (double)mol_SB_s.getValue() ) / 1000.0 );
			mol_SB_t.setText( "" + m.get_SB_mol() + " M" );
		}
	}



	public static void main( String[] args ){
		JFrame j = new JFrame();
		j.add( new Frame3() );
		j.setResizable( false );
		j.setTitle( "Part 3" );
		j.pack();
		j.setLocationRelativeTo( null );
		j.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		j.setVisible( true );
	}

}