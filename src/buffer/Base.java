package buffer;

import java.util.*;

public class Base{

	private String name_B;
	private String formula_B;
	private String formula_CA;
	private double kb;
	
	Base( String name_B, String formula_B, String formula_CA, double kb ){
		this.name_B = name_B;
		this.formula_B = formula_B;
		this.formula_CA = formula_CA;
		this.kb = kb;
	}

	Base( String s ){
		StringTokenizer st = new StringTokenizer( s, "\t" );
		String[] array = new String[4];

		for( int i = 0; i < 4; i++ ){
			array[i] = st.nextToken();
			System.out.println("array[" + i + "] is " + array[i]);
		}


		name_B = array[0];
		formula_B = array[1];
		formula_CA = array[2];
		kb = Double.parseDouble(array[3]);
		System.out.println("Base constructed");
	}

	public String get_name_B(){
		return name_B;
	}

	public String get_formula_B(){
		return formula_B;
	}

	public String get_formula_CA(){
		return formula_CA;
	}

	public double get_kb(){
		return kb;
	}

	public String toString(){
		return "" + get_name_B() + "\t" + get_formula_B() + "\t" + get_formula_CA() + "\t" +get_kb();
	}

}