import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Frame1 extends JFrame{

	private Manager m = new Manager();

	private JPanel p1, p2, p3;
	private JComboBox cba, cbb;
	private JRadioButton a, b;
	private JButton next;
	private JLabel title, kValue;
	private JLabel[] empty;
	private JLabel[] eqn;

	private ArrayList<Acid> acidArray = new ArrayList<Acid>();
	private ArrayList<Base> baseArray = new ArrayList<Base>();


	public Frame1() throws IOException{

		BufferedReader inputStreamA = new BufferedReader(new InputStreamReader( this.getClass().getClassLoader().getResourceAsStream("List_of_Weak_Acid.txt")));
		BufferedReader inputStreamB = new BufferedReader(new InputStreamReader( this.getClass().getClassLoader().getResourceAsStream("List_of_Weak_Base.txt")));

		String line = "dummy";

		while( line != null ){
			line = inputStreamA.readLine();
			if(line != null){
				acidArray.add( new Acid( line ) );
			}
		}

		line = "dummy";

		while( line != null ){
			line = inputStreamB.readLine();
			if(line != null){
				baseArray.add( new Base( line ) );
			}
		}


		empty = new JLabel[13];
		for( int i = 0; i < 13; i++ ){
			empty[i] = new JLabel();
			empty[i].setPreferredSize( new Dimension( 10, 10 ) );
		}

		setTitle( "Buffer solution - Part 1" );
		setSize( 900,600 );
		setLayout( new FlowLayout() );



		Font f1 = new Font( "Times New Roman", Font.BOLD, 45 );
		Font f2 = new Font( "Times New Roman", Font.PLAIN, 23 );


		title = new JLabel( "Part 1: Choose a weak", SwingConstants.CENTER );
		title.setVerticalAlignment( SwingConstants.CENTER );
		title.setFont( f1 );
		title.setPreferredSize( new Dimension( 450,150 ) );


		a = new JRadioButton( "acid or" );
		a.setFont( f1 );
		a.setPreferredSize( new Dimension( 160,150 ) );
		a.setSelected(true);
		a.setActionCommand("acid");
		a.addActionListener( new RadioListener() );

		b = new JRadioButton( "base." );
		b.setFont( f1 );
		b.setPreferredSize( new Dimension( 130,150 ) );
		b.setSelected(false);
		b.setActionCommand("base");
		b.addActionListener( new RadioListener() );

		ButtonGroup group = new ButtonGroup();
		group.add( a );
		group.add( b );


		p1 = new JPanel();
		p1.setPreferredSize( new Dimension( 900,150 ) );
		p1.setLayout( new FlowLayout() );

		p1.add( title );
		p1.add( a );
		p1.add( b );



		String[] acidString = new String[acidArray.size()];

		for( int i = 0; i < acidString.length; i++ ){
			acidString[i] = acidArray.get(i).get_name_A();
		}

		cba = new JComboBox( acidString );
		cba.setFont( f2 );
		cba.setPreferredSize( new Dimension( 165,50 ) );
		cba.addActionListener( new cbaListener() );

		String[] baseString = new String[baseArray.size()];

		for( int i = 0; i < baseString.length; i++ ){
			baseString[i] = baseArray.get(i).get_name_B();
		}

		cbb = new JComboBox( baseString );
		cbb.setFont( f2 );
		cbb.setPreferredSize( new Dimension( 165,50 ) );
		cbb.addActionListener( new cbbListener() );
		cbb.setEnabled(false);


		kValue = new JLabel( "<html>K<sub>a</sub> = " + acidArray.get( cba.getSelectedIndex() ).get_ka() + "</html>" , SwingConstants.CENTER );
		kValue.setVerticalAlignment( SwingConstants.CENTER );
		kValue.setFont( f2 );
		kValue.setPreferredSize( new Dimension( 160, 55 ) );


		next = new JButton( "<html>Go to<br>part 2</html>" );
		next.setFont( f2 );
		next.setMaximumSize( new Dimension( 110,60 ) );
		next.addActionListener( new nextListener() );
		

		p2 = new JPanel();
		p2.setPreferredSize( new Dimension( 900,70 ) );
		p2.setLayout( new FlowLayout() );

		p2.add( cba );
		p2.add( empty[0] );
		p2.add( cbb );
		p2.add( empty[1] );
		p2.add( kValue );
		p2.add( empty[2] );
		p2.add( next );



		p3 = new JPanel();
		p3.setPreferredSize( new Dimension( 875,360 ) );
		p3.setLayout( new GridLayout( 3, 7 ) ); //rows, columns


		for( int i = 3; i < 10; i++ ){
			p3.add(empty[i]);
		}

		eqn = new JLabel[11];
		for( int i = 0; i < 11; i++ ){
			eqn[i] = new JLabel( "", SwingConstants.CENTER );
			eqn[i].setPreferredSize( new Dimension(120,100) );
		}

		eqn[0].setText( "<html>" + acidArray.get( cba.getSelectedIndex() ).get_formula_A() + "</html>" );
		eqn[1].setText( "+" );
		eqn[2].setText( "<html>H<sub>2</sub>0</html>" );
		eqn[3].setText( "<=>" );
		eqn[4].setText( "<html>" + acidArray.get( cba.getSelectedIndex() ).get_formula_CB() +"<sup>-</sup></html>" );
		eqn[5].setText( "+" );
		eqn[6].setText("<html>H<sub>3</sub>0<sup>+</sup></html>");
		eqn[7].setText( "(aq)" );
		eqn[8].setText( "(l)" );
		eqn[9].setText( "(aq)" );
		eqn[10].setText( "(aq)" );


		Font f3 = new Font( "Times New Roman", Font.BOLD, 20 );
		Font f4 = new Font( "Times New Roman", Font.PLAIN, 20 );

		
		for( int i = 0; i < 7; i++ ){
			eqn[i].setFont(f3);
			p3.add(eqn[i]);
		}

		for( int i = 7; i < 11; i++ ){
			eqn[i].setFont(f4);
		}

		for( int i = 0; i < 3; i++ ){
			p3.add( eqn[i+7] );
			p3.add( empty[i+10] );
		}

		p3.add( eqn[10] );


		add(p1);
		add(p2);
		add(p3);

		setResizable( false );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true );
	}

	public void setManager(Manager m){
		this.m = m;
	}

	private class RadioListener implements ActionListener{
		public void actionPerformed( ActionEvent e ){
			String s = e.getActionCommand();

			if( s.equals("acid") ){
				System.out.println( "acid is selected" );
				cba.setEnabled( true );
				cbb.setEnabled( false );
				m.setKValue( m.getAcid().get_ka() );
				m.setC( true );
				
				kValue.setText( "<html>K<sub>a</sub> = " + m.getAcid().get_ka() + "</html>" );
				eqn[0].setText( "<html>" + m.getAcid().get_formula_A() + "</html>" );
				eqn[4].setText( "<html>" + m.getAcid().get_formula_CB() + "<sup>-</sup></html>" );
				eqn[6].setText( "<html>H<sub>3</sub>0<sup>+</sup></html>" );

			}
			else if( s.equals("base") ){
				System.out.println( "base is selected" );
				cba.setEnabled( false );
				cbb.setEnabled( true );
				m.setKValue( m.getBase().get_kb() );
				m.setC( false );
				
				kValue.setText( "<html>K<sub>b</sub> = " + m.getBase().get_kb() + "</html>" );
				eqn[0].setText( "<html>" + m.getBase().get_formula_B() + "</html>" );
				eqn[4].setText( "<html>" +m.getBase().get_formula_CA() + "<sup>+</sup></html>" );
				eqn[6].setText( "<html>OH<sup>-</sup></html>" );

			}
			else{}
		}
	}

	private class cbaListener implements ActionListener{
		public void actionPerformed( ActionEvent e ) {
			m.setAcid( acidArray.get( cba.getSelectedIndex() ) );
			m.setKValue( m.getAcid().get_ka() );

			kValue.setText( "<html>K<sub>a</sub> = " + m.getAcid().get_ka() + "</html>" );
			eqn[0].setText( "<html>" + m.getAcid().get_formula_A() + "</html>" );
			eqn[4].setText( "<html>" + m.getAcid().get_formula_CB() + "<sup>-</sup></html>" );
		}
	}

	private class cbbListener implements ActionListener{
		public void actionPerformed( ActionEvent e ) {
			m.setBase( baseArray.get( cbb.getSelectedIndex() ) );
			m.setKValue( m.getBase().get_kb() );

			kValue.setText( "<html>K<sub>b</sub> = " + m.getBase().get_kb() + "</html>" );
			eqn[0].setText( "<html>" + m.getBase().get_formula_B() + "</html>" );
			eqn[4].setText( "<html>" + m.getBase().get_formula_CA() + "<sup>+</sup></html>" );
		}
	}

	private class nextListener implements ActionListener{
		public void actionPerformed( ActionEvent e ) {
			System.out.println( m.getAcid().toString() );
			System.out.println( m.getBase().toString() );
			System.out.println( m.getC() );
			System.out.println( "Equilibrium constant = " + m.getKValue() );	

			m.next1();
			m.get_frame2().refresh();
			m.get_frame2().revalidate();
		}
	}

}