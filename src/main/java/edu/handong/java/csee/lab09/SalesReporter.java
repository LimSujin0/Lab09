package edu.handong.java.csee.lab09;

import edu.handong.java.csee.lab09.Salesman;
import java.util.Scanner;

public class SalesReporter {
	
	Scanner myScanner = new Scanner(System.in);
	private double highestSales;
	private double averageSales;
	private Salesman[] team;
	private int numberOfSalesman;
	
	public static void main(String[] args) {
		SalesReporter myReporter  = new SalesReporter();
		myReporter.SalesReport();
		myReporter.getData();
		myReporter.calculateAverageSales();
		myReporter.calculateHighestSales();
		myReporter.printOutResults();
	}

	
	public void SalesReport() {
		System.out.println("Enter number of sales associates:");
		Scanner myScanner  = new Scanner(System.in);
		numberOfSalesman = myScanner.nextInt();
	}
	
	public void getData() {
		team = new Salesman[numberOfSalesman];
		
		for(int i =0; i<numberOfSalesman; i++) {
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
