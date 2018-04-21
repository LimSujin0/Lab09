package edu.handong.java.csee.lab09;//package name

//import edu.handong.java.csee.lab09.Salesman;//import Salesman class in lab09 package
import java.util.Scanner;//import scanner class
import java.util.ArrayList; //import java.util.ArrayList
/**
 * This is a class named SalesReporter
 * this program generate a sales report
 * associates salesmen that have the highest sales
 * and how the sales of each associate compare to the average.
 * Enjoy my program
 * Thank you JaeChang Name Professor :)
 * @author imsuj
 */

public class SalesReporter {
	Scanner myScanner = new Scanner(System.in); // instantiating a Scanner to myScanner 
	private double highestSales;//This is a double type variable named highestSales
	private double averageSales;//This is a double type variable named averageSales
	private ArrayList<String> names = new ArrayList<String>();//this is a array list type named names
	private ArrayList<Double> sales = new ArrayList<Double>();//this is a array list type named sales
//	private int numberOfSalesman;
	
	/**
	 * This is a main method of SalesReporter
	 * get a number of salesman from user.
	 * and get data name and sales of the salesman from user.
	 * calculate average and highest sales
	 * print out the results of outcomes.
	 * @param args
	 */
	public static void main(String[] args) {
		SalesReporter myReporter  = new SalesReporter();//instantiating SalesReporter class
//		myReporter.SalesReport();//get a number of salesman from user.
		myReporter.getData();//get data name and sales of the salesman from user.
		myReporter.calculateAverageSales();//calculate average sales of that data
		myReporter.calculateHighestSales();//calculate highest sales of that data
		myReporter.printOutResults();//print out the result of outcomes.
	}

	/**
	 * This is a method named Sales Reporter
	 * gets a number of salesman from user.
	 * sets number of sales man to variable obtained
	 */
/*	public void SalesReport() {
		System.out.println("Enter number of sales associates:");//print out this line on a user's monitor
		numberOfSalesman = myScanner.nextInt();//get a number of salesman from user, and set numberOfSalesman to variable obtained
	}
*/	
	/**
	 * This is a method named obtained
	 * gets data name and sales of the salesman from user.
	 * save that data in the array team.
	 */
	public void getData() {
		int i = 0; //this is a int type variable named i
		
		while(true) {//this is a infinite while
			System.out.println("\nEnter data for associate number " + ((i++)+1));//print out this line on the monitor.
			
			System.out.print("Enter name of sales associate: ");//print out this line on the monitor.
			names.add(myScanner.nextLine()); //get a name of salesman from user, and set names to variable obtained
		
			System.out.print("Enter associate's sales: $");//print out this line on the monitor.
			sales.add(myScanner.nextDouble()); //get a sales of salesman from user, and set sales to variable obtained	
			myScanner.nextLine();//buffer initialization
	
			
/*			Salesman mySalesman = new Salesman(); //instantiating Salesman class
			mySalesman.setName(name);//set name of mySalesman to obtained variable 
			mySalesman.setSales(sales);//set sales of mySalesman to obtained variable
*/
				
			System.out.println("Do you want add one more slaesman?"); //print out "do you want to add on more person?"
			
			if(myScanner.nextLine().equalsIgnoreCase("no")) //if user don't want to add one more person
				break;//break this while loop.
		}
	}
	

	/**
	 * This is a method named calculateAverageSales
	 * calculates averages of all Salesman in array
	 */
	public void calculateAverageSales() {
		double sum = 0; // this is a double type variable named sum

		for(int i = 0 ; i < sales.size(); i++) { //this is a for loop for i = 0 ~ size of names-1 because the number means index of the array
			double sale = sales.get(i);//set sales to sales(i)
			sum = sum + sale; //set sum to sum+sale
		}
		
		this.averageSales =(int) sum/sales.size(); //set instance variable averageSales to sum/team.length
	}
	
	/**
	 * This is a method named calculateHighestSales
	 * calculates the highest sales in all Salesman in array
	 */
	public void calculateHighestSales() {
		if(sales.size()==1) { //if the array has only one item;
			this.highestSales = sales.get(0); //set the highestSales to array[0]'s value
		}
		else{ //if the array has more than one item;
			for(int i = 0; i < names.size()-1; i++) {//this is a for loop for i = 0 ~ size of names-1
				if(sales.get(i) <= sales.get(i+1))//if sales of sales(i) is smaller than sales(i+1)
					this.highestSales = sales.get(i+1);//set the highest sales to sales of sale(i+1)
			}
		}
	}
	
	/**
	 * this is a method named printOutResults
	 * prints out the average sales per associate and the highest sales figure
	 * prints out the outcomes of all salesman
	 */
	public void printOutResults() {
		System.out.println("Average sales per associate is $" + this.averageSales);//prints out the average sales per associate
		System.out.println("The highest sales figure is $" + this.highestSales);//prints out the highest sales figure
				
		for(int i = 0 ; i < names.size(); i++) {//this is a for loop for i=0 ~ size of names-1
			if(sales.get(i) == this.highestSales) {//if the value of sales is same as the highest value of sales in the array
				System.out.println("\nThs following had the highest sales:");//print out this line.
				System.out.println("Name :" + names.get(i));//print out a name of the highest member
				System.out.println("Sales:" + sales.get(i));//print out a sales of the highest member
				System.out.println("$" + (this.highestSales - this.averageSales) + " above the average.");//print out difference between mean and value
			}
		}
		
		System.out.print("\nThe rest performed as follows : ");//print out this line
		for(int j = 0 ; j < names.size(); j++) {//this is a for loop for i=0 ~  names.size()-1
			if(sales.get(j) > this.averageSales && sales.get(j)!= this.highestSales) {//if the value of sales is bigger than the average value of sales in the array(not the highest value)
				System.out.println("\nName:" + names.get(j));//print out a name of the member
				System.out.println("Sales:" + sales.get(j));//print out a sales of the member
				System.out.println("$" + (sales.get(j)- this.averageSales) + " above the average.");//print out difference between mean and value
			}
			else if(sales.get(j) < this.averageSales && sales.get(j)!= this.highestSales) {//if the value of sales is smaller than the average value of sales in the array(not the highest value)
				System.out.println("\nName:" + names.get(j));//print out a name of the member
				System.out.println("Sales:" + sales.get(j));//print out a sales of the member
				System.out.println("$" + ( this.averageSales - sales.get(j)) + " below the average.");//print out difference between mean and value
			}
		}
	}		
}