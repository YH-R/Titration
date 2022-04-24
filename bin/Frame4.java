import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.lang.Math.*;
import java.util.ArrayList;

public class Frame4 extends JFrame{

	private Manager m;
	private JPanel mainP, leftMainP, rightMainP;
	private DrawingPanel ldp, rdp;
	private JLabel title, leftTitle, rightTitle, leftSlide, rightSlide, leftVolume, rightVolume, leftpH_l, rightpH_l,leftv_l, rightv_l ;
	private JButton back, finish;
	private JSlider vol_SA_s, vol_SB_s;
	private JTextField vol_SA_t, vol_SB_t, leftpH_t, rightpH_t, leftv_t, rightv_t;

	Frame4(){
		setTitle( "Buffer solution - Part 4" );
		setSize( 900,600 );
		setLayout( new FlowLayout() );



		Font f1 = new Font( "Times New Roman", Font.BOLD, 33 );
		Font f3 = new Font( "Times New Roman", Font.BOLD, 22 );
		Font f2 = new Font( "Times New Roman", Font.PLAIN, 20 );
		Font f4 = new Font( "Times New Roman", Font.PLAIN, 15 );

		title = new JLabel( "Part 4: Testing the buffer solution", SwingConstants.CENTER );
		title.setVerticalAlignment( SwingConstants.CENTER );
		title.setFont( f1 );
		title.setPreferredSize( new Dimension( 530,60 ) );

		back = new JButton( "Back to part 3" );
		back.setFont( f2 );
		back.setPreferredSize( new Dimension( 155,40 ) );
		back.addActionListener( new backListener() );

		finish = new JButton( "Finish" );
		finish.setFont( f2 );
		finish.setPreferredSize( new Dimension( 95,40 ) );
		finish.addActionListener( new finishListener() );

		add( title );
		add( back );
		add( finish );


		leftTitle = new JLabel( "Add Strong acid: 0.1 M HCl", SwingConstants.CENTER );
		leftTitle.setVerticalAlignment( SwingConstants.CENTER );
		leftTitle.setFont( f3 );
		leftTitle.setPreferredSize( new Dimension( 450,50 ) );

		rightTitle = new JLabel( "Add Strong base: 0.1 M NaOH", SwingConstants.CENTER );
		rightTitle.setVerticalAlignment( SwingConstants.CENTER );
		rightTitle.setFont( f3 );
		rightTitle.setPreferredSize( new Dimension( 450,50 ) );

		leftSlide = new JLabel( "Slide to Adjust Volume to Add", SwingConstants.CENTER );
		leftSlide.setVerticalAlignment( SwingConstants.CENTER );
		leftSlide.setFont( f2 );
		leftSlide.setPreferredSize( new Dimension( 450,40 ) );

		rightSlide = new JLabel( "Slide to Adjust Volume to Add", SwingConstants.CENTER );
		rightSlide.setVerticalAlignment( SwingConstants.CENTER );
		rightSlide.setFont( f2 );
		rightSlide.setPreferredSize( new Dimension( 450,40 ) );

		vol_SA_s = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		vol_SA_s.setPreferredSize( new Dimension( 250,40 ) );
		vol_SA_s.addChangeListener( new vol_SA_Listener() );

		vol_SB_s = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		vol_SB_s.setPreferredSize( new Dimension( 250,40 ) );
		vol_SB_s.addChangeListener( new vol_SB_Listener() );

		vol_SA_t = new JTextField( "0.0 L", SwingConstants.CENTER );
		vol_SA_t.setFont( f2 );
		vol_SA_t.setPreferredSize( new Dimension( 85,35 ) );
		vol_SA_t.setEditable(false);

		vol_SB_t = new JTextField( "0.0 L", SwingConstants.CENTER );
		vol_SB_t.setFont( f2 );
		vol_SB_t.setPreferredSize( new Dimension( 85,35 ) );
		vol_SB_t.setEditable(false);

		ldp = new DrawingPanel( 0.3, 0.6, 0.1, true );

		rdp = new DrawingPanel( 0.1, 0.6, Manager.kw / 0.1, false );

		leftpH_l = new JLabel( "pH =", SwingConstants.CENTER );
		leftpH_l.setVerticalAlignment( SwingConstants.CENTER );
		leftpH_l.setFont( f2 );
		leftpH_l.setPreferredSize( new Dimension( 50,40 ) );

		rightpH_l = new JLabel( "pH =", SwingConstants.CENTER );
		rightpH_l.setVerticalAlignment( SwingConstants.CENTER );
		rightpH_l.setFont( f2 );
		rightpH_l.setPreferredSize( new Dimension( 50,40 ) );

		leftpH_t = new JTextField( "" + Manager.p(0.1) , SwingConstants.CENTER );
		leftpH_t.setFont( f2 );
		leftpH_t.setPreferredSize( new Dimension( 60,35 ) );
		leftpH_t.setEditable(false);

		rightpH_t = new JTextField( "" + ( Manager.p(Manager.kw) - Manager.p(0.1) ) , SwingConstants.CENTER );
		rightpH_t.setFont( f2 );
		rightpH_t.setPreferredSize( new Dimension( 60,35 ) );
		rightpH_t.setEditable(false);

		leftv_l = new JLabel( "Total Volume = ", SwingConstants.CENTER );
		leftv_l.setVerticalAlignment( SwingConstants.CENTER );
		leftv_l.setFont( f2 );
		leftv_l.setPreferredSize( new Dimension( 140,40 ) );

		rightv_l = new JLabel( "Total Volume = ", SwingConstants.CENTER );
		rightv_l.setVerticalAlignment( SwingConstants.CENTER );
		rightv_l.setFont( f2 );
		rightv_l.setPreferredSize( new Dimension( 140,40 ) );

		leftv_t = new JTextField( "" , SwingConstants.CENTER );
		leftv_t.setFont( f2 );
		leftv_t.setPreferredSize( new Dimension( 100,35 ) );
		leftv_t.setEditable(false);

		rightv_t = new JTextField( "" , SwingConstants.CENTER );
		rightv_t.setFont( f2 );
		rightv_t.setPreferredSize( new Dimension( 100,35 ) );
		rightv_t.setEditable(false);


		mainP = new JPanel();
		mainP.setPreferredSize( new Dimension( 890,520 ) );
		mainP.setLayout( new GridLayout( 1, 2 ) ); //rows, columns

		leftMainP = new JPanel();
		leftMainP.setPreferredSize( new Dimension( 445,520 ) );
		leftMainP.setLayout( new FlowLayout() );

		rightMainP = new JPanel();
		rightMainP.setPreferredSize( new Dimension( 445,520 ) );
		rightMainP.setLayout( new FlowLayout() );


		leftMainP.add(leftTitle);
		leftMainP.add(leftSlide);
		leftMainP.add(vol_SA_s);
		leftMainP.add(vol_SA_t);
		leftMainP.add(ldp);
		leftMainP.add(leftpH_l);
		leftMainP.add(leftpH_t);
		leftMainP.add(leftv_l);
		leftMainP.add(leftv_t);

		
		rightMainP.add(rightTitle);
		rightMainP.add(rightSlide);
		rightMainP.add(vol_SB_s);
		rightMainP.add(vol_SB_t);
		rightMainP.add(rdp);
		rightMainP.add(rightpH_l);
		rightMainP.add(rightpH_t);
		rightMainP.add(rightv_l);
		rightMainP.add(rightv_t);


		mainP.add( leftMainP );
		mainP.add( rightMainP );

		add(mainP);


		setResizable( false );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( false );
	}

	private class backListener implements ActionListener{
		public void actionPerformed( ActionEvent e ){


			m.back4();
		}
	}

	private class finishListener implements ActionListener{
		public void actionPerformed( ActionEvent e ){
			System.exit(0);
		}
	}

	private class vol_SA_Listener implements ChangeListener {
		public void stateChanged( ChangeEvent e ) {
			m.set_volumeA( ( (double)vol_SA_s.getValue() ) / 2000.0 );
			vol_SA_t.setText( "" + m.get_volumeA() + " L" );
			leftv_t.setText( "" + Math.floor( 1000.0 * ( m.get_volumeA() + m.get_totalV() ) ) / 1000.0 + " L"  );

			double wi = ( m.get_w_mole() * m.get_totalV() ) / ( m.get_totalV() + m.get_volumeA() );
			double si = ( m.get_s_mole() * m.get_totalV() ) / ( m.get_totalV() + m.get_volumeA() );
			double hi = ( m.get_h_mole() * m.get_totalV() + m.get_SA_mol() * m.get_volumeA() ) / ( m.get_totalV() + m.get_volumeA() );

			updateCharts( m.getC(), wi, si, hi, ldp, leftpH_t, true );

		}
	}

	private class vol_SB_Listener implements ChangeListener {
		public void stateChanged( ChangeEvent e ) {
			m.set_volumeB( ( (double)vol_SB_s.getValue() ) / 2000.0 );
			vol_SB_t.setText( "" + m.get_volumeB() + " L" );
			rightv_t.setText( "" + Math.floor( 1000.0 * ( m.get_volumeB() + m.get_totalV() ) ) / 1000.0 + " L" );


			double wi = ( m.get_w_mole() * m.get_totalV() ) / ( m.get_totalV() + m.get_volumeB() );
			double si = ( m.get_s_mole() * m.get_totalV() ) / ( m.get_totalV() + m.get_volumeB() );
			double ohi = ( Manager.kw / m.get_h_mole() * m.get_totalV() + m.get_SB_mol() * m.get_volumeB() ) / ( m.get_totalV() + m.get_volumeB() );


			updateCharts( !m.getC(), wi, si, ohi, rdp, rightpH_t, false );

		}
	}

	public void updateCharts( boolean c, double w, double s, double h, DrawingPanel dp, JTextField tf, boolean cc ){
		if( c ){

			double x1 = ( s + h + m.getKValue() + Math.sqrt( Math.pow( ( s + h + m.getKValue() ), 2 ) - 4 * s * h + 4 * m.getKValue() * w ) ) / 2.0;
			double x2 = ( s + h + m.getKValue() - Math.sqrt( Math.pow( ( s + h + m.getKValue() ), 2 ) - 4 * s * h + 4 * m.getKValue() * w ) ) / 2.0;

			boolean root = x1 > 0 && x1 < s && x1 < h; // true means use x1

			if( root ){
				dp.setValue( w+x1, s-x1, h-x1  );
				if( cc ){
					tf.setText( "" + (double)Math.round( 100 * Manager.p( h - x1 ) ) / 100.0  );
				}
				else{
					tf.setText( "" + (double)Math.round( 100 * ( Manager.p( Manager.kw ) - Manager.p( h - x1 ) ) ) / 100.0 );
				}
			}
			else{
				dp.setValue( w+x2, s-x2, h-x2 );
				if( cc ){
					tf.setText( "" + (double)Math.round( 100 * Manager.p( h - x2 ) ) / 100.0 );
				}
				else{
					tf.setText( "" + (double)Math.round( 100 * ( Manager.p( Manager.kw ) - Manager.p( h - x2 ) ) ) / 100.0 );
				}
			}
		}
		else{

			double x1 = ( w + h + Manager.kw / m.getKValue() + Math.sqrt( Math.pow( ( w + h + Manager.kw / m.getKValue() ), 2 ) - 4 * w * h + 4 * Manager.kw / m.getKValue() * s ) ) / 2.0;
			double x2 = ( w + h + Manager.kw / m.getKValue() - Math.sqrt( Math.pow( ( w + h + Manager.kw / m.getKValue() ), 2 ) - 4 * w * h + 4 * Manager.kw / m.getKValue() * s ) ) / 2.0;

			boolean root = x1 > 0 && x1 < w && x1 < h; // true means use x1

			if( root ){
				dp.setValue( w-x1, s+x1, h-x1  );
				if( cc ){
					tf.setText( "" + (double)Math.round( 100 * Manager.p( h - x1 ) ) / 100.0 );
				}
				else{
					tf.setText( "" + (double)Math.round( 100 * ( Manager.p( Manager.kw ) - Manager.p( h - x1 ) ) ) / 100.0 );
				}
			}
			else{
				dp.setValue( w-x2, s+x2, h-x2 );
				if( cc ){
					tf.setText( "" + (double)Math.round( 100 * Manager.p( h - x2 ) ) / 100.0 );
				}
				else{
					tf.setText( "" + (double)Math.round( 100 * ( Manager.p( Manager.kw ) - Manager.p( h - x2 ) ) ) / 100.0 );
				}
			}

		}
	}

	public void refresh(){
		if( m.getC() ){
			ldp.setName( m.getAcid().get_formula_A(),  m.getAcid().get_formula_CB(), true );
			rdp.setName( m.getAcid().get_formula_A(),  m.getAcid().get_formula_CB(), true );
		}
		else{
			ldp.setName( m.getBase().get_formula_B(),  m.getBase().get_formula_CA(), false );
			rdp.setName( m.getBase().get_formula_B(),  m.getBase().get_formula_CA(), false );
		}

		leftTitle.setText( "Add Strong acid: " + m.get_SA_mol() + " M HCl" );
		rightTitle.setText( "Add Strong base: " + m.get_SB_mol() + " M NaOH" );



		double wil = ( m.get_w_mole() * m.get_totalV() ) / ( m.get_totalV() + m.get_volumeA() );
		double sil = ( m.get_s_mole() * m.get_totalV() ) / ( m.get_totalV() + m.get_volumeA() );
		double hil = ( m.get_h_mole() * m.get_totalV() + m.get_SA_mol() * m.get_volumeA() ) / ( m.get_totalV() + m.get_volumeA() );

		updateCharts( m.getC(), wil, sil, hil, ldp, leftpH_t, true );

		double wir = ( m.get_w_mole() * m.get_totalV() ) / ( m.get_totalV() + m.get_volumeB() );
		double sir = ( m.get_s_mole() * m.get_totalV() ) / ( m.get_totalV() + m.get_volumeB() );
		double ohir = ( Manager.kw / m.get_h_mole() * m.get_totalV() + m.get_SB_mol() * m.get_volumeB() ) / ( m.get_totalV() + m.get_volumeB() );

		updateCharts( !m.getC(), wir, sir, ohir, rdp, rightpH_t, false );

		leftv_t.setText( "" + Math.floor( 1000.0 * ( m.get_volumeA() + m.get_totalV() ) ) / 1000.0 + " L"  );
		rightv_t.setText( "" + Math.floor( 1000.0 * ( m.get_volumeB() + m.get_totalV() ) ) / 1000.0 + " L" );

	}

	public void setManager(Manager m){
		this.m = m;
	}

}