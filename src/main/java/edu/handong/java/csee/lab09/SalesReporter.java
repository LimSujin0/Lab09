package edu.handong.java.csee.lab09;//package name

import edu.handong.java.csee.lab09.Salesman;//import Salesman class in lab09 package
import java.util.Scanner;//import scanner class
/**
 * This is a class named SalesReporter
 * this program generate a sales report
 * associates salesmen that have the highest sales
 * and how the sales of each associate compare to the average.
 * Enjoy my program
 * Thank you JaeChang Name Professor :)
 * @author imsuj
 *
 */
public class SalesReporter {
	
	Scanner myScanner = new Scanner(System.in); // instantiating a Scanner to myScanner 
	private double highestSales;//This is a double type variable named highestSales
	private double averageSales;//This is a double type variable named averageSales
	private Salesman[] team;//This is a Salesman type variable named team.
	private int numberOfSalesman;
	
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
		myReporter.SalesReport();//get a number of salesman from user.
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
	public void SalesReport() {
		System.out.println("Enter number of sales associates:");//print out this line on a user's monitor
		numberOfSalesman = myScanner.nextInt();//get a number of salesman from user, and set numberOfSalesman to variable obtained
	}
	
	/**
	 * This is a method named obtained
	 * gets data name and sales of the salesman from user.
	 * save that data in the array team.
	 */
	public void getData() {
		team = new Salesman[numberOfSalesman];//create 10 references to the Salesman object(that is, creates 10 salesman.)
		
		for(int i =0; i<numberOfSalesman; i++) {//this is a for loop for i = 0 ~ (numberOfSalesman-1)
			System.out.println("\nEnter data for associate number " + (i+1));//print out this line on the monitor.
			
			System.out.print("Enter name of sales associate: ");//print out this line on the monitor.
			String name = myScanner.nextLine(); //get a name of salesman from user, and set name to variable obtained
			
			System.out.print("Enter associate's sales: $");//print out this line on the monitor.
			double sales = myScanner.nextDouble(); //get a sales of salesman from user, and set sales to variable obtained
			myScanner.nextLine();//buffer initialization
			
			Salesman mySalesman = new Salesman(); //instantiating Salesman class
			mySalesman.setName(name);//set name of mySalesman to obtained variable 
			mySalesman.setSales(sales);//set sales of mySalesman to obtained variable
			
			team[i] = mySalesman; // set Salesman in team[i] to my Salesman
		}
	}
	

	/**
	 * This is a method named calculateAverageSales
	 * calculates averages of all Salesman in array
	 */
	public void calculateAverageSales() {
		double sum = 0; // this is a double type variable named sum
		
		for(int i = 0 ; i < team.length; i++) { //this is a for loop for i = 0 ~ (team.length-1) because the number means index of the array
			double sales = team[i].getSales();//set sales to sales' value of team[i]
			sum = sum + sales; //set sum to sum+sales
		}
		
		this.averageSales = sum / team.length; //set instance variable averageSales to sum/team.length
	}
	
	/**
	 * This is a method named calculateHighestSales
	 * calculates the highest sales in all Salesman in array
	 */
	public void calculateHighestSales() {
		for(int i = 0; i < (team.length)-1; i++) {//this is a for loop for i = 0 ~ (team.length-1)
			if(team[i].getSales() < team[i+1].getSales())//if sales of team[i] is smaller than sales of team[i+1]
				this.highestSales = team[i+1].getSales();//set the highest sales to sales of team[i+1]
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
				
		for(int i = 0 ; i < team.length; i++) {//this is a for loop for i=0 ~ (team.length-1)
			if(team[i].getSales() == this.highestSales) {//if the value of sales is same as the highest value of sales in the array
				System.out.println("\nThs following had the highest sales:");//print out this line.
				System.out.println("Name :" + team[i].getName());//print out a name of the highest member
				System.out.println("Sales:" + team[i].getSales());//print out a sales of the highest member
				System.out.println("$" + (this.highestSales - this.averageSales) + " above the average.");//print out difference between mean and value
			}
		}
		
		System.out.print("\nThe rest performed as follows : ");//print out this line
		for(int j = 0 ; j < team.length ; j++) {//this is a for loop for i=0 ~ (team.length-1)
			if(team[j].getSales() > this.averageSales && team[j].getSales() != this.highestSales) {//if the value of sales is bigger than the average value of sales in the array(not the highest value)
				System.out.println("\nName:" + team[j].getName());//print out a name of the member
				System.out.println("Sales:" + team[j].getSales());//print out a sales of the member
				System.out.println("$" + (team[j].getSales()- this.averageSales) + " above the average.");//print out difference between mean and value
			}
			else if(team[j].getSales() < this.averageSales && team[j].getSales() != this.highestSales) {//if the value of sales is smaller than the average value of sales in the array(not the highest value)
				System.out.println("\nName:" + team[j].getName());//print out a name of the member
				System.out.println("Sales:" + team[j].getSales());//print out a sales of the member
				System.out.println("$" + ( this.averageSales - team[j].getSales()) + " below the average.");//print out difference between mean and value
			}
		}
	}		
}
