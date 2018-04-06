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
		
		for(int i =0; i<numberOfSalesman; i++) {//this is a for loop
			System.out.println("\nEnter data for associate number " + (i+1));
			
			System.out.print("Enter name of sales associate: ");
			String name = myScanner.nextLine();
			
			System.out.print("Enter associate's sales: $");
			double sales = myScanner.nextDouble();
			myScanner.nextLine();
			
			Salesman mySalesman = new Salesman();
			mySalesman.setName(name);
			mySalesman.setSales(sales);
			
			team[i] = mySalesman;
		}
	}
	

	
	public void calculateAverageSales() {
		double sum = 0;
		
		for(int i = 0 ; i < team.length; i++) {
			double sales = team[i].getSales();
			sum = sum + sales;
		}
		
		this.averageSales = sum / team.length;
	}
	
	public void calculateHighestSales() {
		for(int i = 0; i < (team.length)-1; i++) {
			if(team[i].getSales() < team[i+1].getSales())
				this.highestSales = team[i+1].getSales();
		}
	}
	
	public void printOutResults() {
		System.out.println("Average sales per associate is $" + this.averageSales);
		System.out.println("The highest sales figure is $" + this.highestSales);
				
		for(int i = 0 ; i < team.length; i++) {
			if(team[i].getSales() == this.highestSales) {
				System.out.println("\nThs following had the highest sales:");
				System.out.println("Name :" + team[i].getName());
				System.out.println("Sales:" + team[i].getSales());
				System.out.println("$" + (this.highestSales - this.averageSales) + " above the average.");
			}
		}
		
		System.out.print("\nThe rest performed as follows : ");
		for(int j = 0 ; j < team.length ; j++) {
			if(team[j].getSales() > this.averageSales && team[j].getSales() != this.highestSales) {
				System.out.println("\nName:" + team[j].getName());
				System.out.println("Sales:" + team[j].getSales());
				System.out.println("$" + (team[j].getSales()- this.averageSales) + " above the average.");
			}
			else if(team[j].getSales() < this.averageSales && team[j].getSales() != this.highestSales) {
				System.out.println("\nName:" + team[j].getName());
				System.out.println("Sales:" + team[j].getSales());
				System.out.println("$" + ( this.averageSales - team[j].getSales()) + " below the average.");
			}
		}
	}		
}
