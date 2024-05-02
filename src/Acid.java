package buffer;

import java.util.*;

public class Acid{

	private String name_A;
	private String formula_A;
	private String formula_CB;
	private double ka;
	private boolean b; //true means place Na in front of formula of conjugate base
	
	Acid( String name_A, String formula_A, String formula_CB, double ka, boolean b ){
		this.name_A = name_A;
		this.formula_A = formula_A;
		this.formula_CB = formula_CB;
		this.ka = ka;
		this.b = b;
	}

	Acid( String s ){
		StringTokenizer st = new StringTokenizer( s, "\t" );
		String[] array = new String[5];

		for( int i = 0; i < 5; i++ ){
			array[i] = st.nextToken();
			System.out.println("array[" + i + "] is " + array[i]);
		}


		name_A = array[0];
		formula_A = array[1];
		formula_CB = array[2];
		ka = Double.parseDouble(array[3]);
		b = array[4].equals("true");

		System.out.println("Acid constructed");
	}
	
	public String get_name_A(){
		return name_A;
	}

	public String get_formula_A(){
		return formula_A;
	}

	public String get_formula_CB(){
		return formula_CB;
	}

	public double get_ka(){
		return ka;
	}

	public boolean get_b(){
		return b;
	}

	public String toString(){
		return "" + get_name_A() + "\t" + get_formula_A() + "\t" + get_formula_CB() + "\t" +get_ka() + "\t" +get_b();
	}

}