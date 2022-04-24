import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class Inventory{

	private Frame1 frame1;
	private Frame2 frame2;
	private Frame3 frame3;
	private Frame4 frame4;
	private Manager m;

	public Inventory(){
		try{
			frame1 = new Frame1();
		}
		catch( IOException ex ){}

		frame2 = new Frame2();

		frame3 = new Frame3();

		frame4 = new Frame4();


		try{
			m = new Manager( frame1, frame2, frame3, frame4 );
		}
		catch( IOException ex ){}

		frame1.setManager(m);
		frame2.setManager(m);
		frame3.setManager(m);
		frame4.setManager(m);


	}

	public static void main( String[] args ){
		Inventory i = new Inventory();
	}
}