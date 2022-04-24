import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Manager{

	private Frame1 frame1;
	private Frame2 frame2;
	private Frame3 frame3;
	private Frame4 frame4;

	public final static double kw = 0.00000000000001;

	//default values
	private double KValue;
	private double w_vol = 0.1;
	private double s_vol = 0.1;
	private double w_mol = 0.1;
	private double s_mol = 0.1;
	private double SA_mol = 0.1;
	private double SB_mol = 0.1;
	private Acid asel;
	private Base bsel;
	private boolean c = true;

	//variables
	private double totalV, w_mole, s_mole, h_mole;
	private double volumeA = 0;
	private double volumeB = 0;


	public Manager(){}

	public Manager ( Frame1 frame1, Frame2 frame2, Frame3 frame3, Frame4 frame4 ) throws IOException{
		this.frame1 = frame1;
		this.frame2 = frame2;
		this.frame3 = frame3;
		this.frame4 = frame4;

		asel = new Acid( new BufferedReader(new InputStreamReader( this.getClass().getClassLoader().getResourceAsStream("List_of_Weak_Acid.txt"))).readLine() );
		bsel = new Base( new BufferedReader(new InputStreamReader( this.getClass().getClassLoader().getResourceAsStream("List_of_Weak_Base.txt"))).readLine() );
		KValue = asel.get_ka();
	
	}

	//Accessors and Mutators
	public Frame1 get_frame1(){
		return frame1;
	}

	public Frame2 get_frame2(){
		return frame2;
	}

	public Frame3 get_frame3(){
		return frame3;
	}

	public Frame4 get_frame4(){
		return frame4;
	}

	public double getKValue(){
		return KValue;
	}

	public Acid getAcid(){
		return asel;
	}

	public Base getBase(){
		return bsel;
	}

	public boolean getC(){
		return c;
	}

	public double get_w_vol(){
		return w_vol;
	}

	public double get_s_vol(){
		return s_vol;
	}

	public double get_w_mol(){
		return w_mol;
	}

	public double get_s_mol(){
		return s_mol;
	}

	public double get_SA_mol(){
		return SA_mol;
	}

	public double get_SB_mol(){
		return SB_mol;
	}

	public double get_totalV(){
		return totalV;
	}

	public double get_w_mole(){
		return w_mole;
	}

	public double get_s_mole(){
		return s_mole;
	}

	public double get_h_mole(){
		return h_mole;
	}

	public double get_volumeA(){
		return volumeA;
	}

	public double get_volumeB(){
		return volumeB;
	}

	public void setKValue( double k ){
		KValue = k;	
	}

	public void setAcid( Acid a ){
		asel = a;
	}

	public void setBase( Base b ){
		bsel = b;
	}

	public void setC( boolean c){
		this.c = c;
	}

	public void set_w_vol( double d ){
		w_vol = d;
	}

	public void set_s_vol( double d ){
		s_vol = d;
	}

	public void set_w_mol( double d ){
		w_mol = d;
	}

	public void set_s_mol( double d ){
		s_mol = d;
	}

	public void set_SA_mol( double d ){
		SA_mol = d;
	}

	public void set_SB_mol( double d ){
		SB_mol = d;
	}

	public void set_totalV( double d ){
		totalV = d;
	}

	public void set_w_mole( double d ){
		w_mole = d;
	}

	public void set_s_mole( double d ){
		s_mole = d;
	}

	public void set_h_mole( double d ){
		h_mole = d;
	}

	public void set_volumeA( double d ){
		volumeA = d;
	}

	public void set_volumeB( double d ){
		volumeB = d;
	}


	public void next1(){
		frame1.setVisible(false);
		frame2.setVisible(true);
		frame3.setVisible(false);
		frame4.setVisible(false);
	}

	public void next2(){
		frame1.setVisible(false);
		frame2.setVisible(false);
		frame3.setVisible(true);
		frame4.setVisible(false);
	}

	public void back2(){
		frame1.setVisible(true);
		frame2.setVisible(false);
		frame3.setVisible(false);
		frame4.setVisible(false);
	}

	public void next3(){
		frame1.setVisible(false);
		frame2.setVisible(false);
		frame3.setVisible(false);
		frame4.setVisible(true);
	}

	public void back3(){
		frame1.setVisible(false);
		frame2.setVisible(true);
		frame3.setVisible(false);
		frame4.setVisible(false);
	}

	public void back4(){
		frame1.setVisible(false);
		frame2.setVisible(false);
		frame3.setVisible(true);
		frame4.setVisible(false);
	}

	public static double p( double d ){
		return -Math.log10(d);
	}

}