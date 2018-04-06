package edu.handong.java.csee.lab09;//package name
/**
 * This is a class named Salesman
 * This class has variables name,scales
 * methods setName, setSales, getName, getSales
 * @author imsuj
 *
 */
public class Salesman {
	String name; //this is a string type variable named name
	double sales; //this is a double type variable named  sales
	 /**
	  *This is a method named setName
	  *sets instance variable name to parameter's value
	  * @param name
	  */
	public void setName(String name){
		this.name = name;//sets instance variable name to parameter's value
	}
	/**
	 * This is a method names setSales
	 * sets instance variable sales to parameter's value
	 * @param sales
	 */
	public void setSales(double sales) {
		this.sales = sales;//set instance variable sales to parameter's value
	}
	/**
	 * This is a method named getName
	 * returns instance variable name of String type 
	 * @return
	 */
	public String getName() {
		return this.name;//return instance variable name of String type 
	}
	
	/**
	 * This is a method names getSales
	 * returns instance variable sales of double type
	 * @return
	 */
	public double getSales() {
		return this.sales;//return instance variable sales of double type
	}
	
}
