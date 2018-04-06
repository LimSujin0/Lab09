package edu.handong.java.csee.lab09;

import edu.handong.java.csee.lab09.Salesman;
import java.util.Scanner;

public class SalesReporter {
	
	Scanner myScanner = new Scanner(System.in);
	private double highestSales;
	private double averageSales;
	private Salesman[] team;
	private int numberOfSalesman;
	
	
	public void SalesReport() {
		System.out.println("Enter number of salesman");
		Scanner myScanner  = new Scanner(System.in);
		numberOfSalesman = myScanner.nextInt();
	}
	

	public static void main(String[] args) {
		SalesReporter myReporter  = new SalesReporter();
		myReporter.getData();
		myReporter.calculateAverageSales();
		myReporter.calculateHighestSales();
		myReporter.printOutResults();
	}

	public void getData() {
		team = new Salesman[numberOfSalesman];
		
		for(int i =0; i<numberOfSalesman; i++) {
			System.out.println("Enter data for associate number " + (i+1));
			
			System.out.print("Enter name of sales associate: ");
			String name = myScanner.nextLine();
			
			System.out.print("Enter associate's sales: $");
			double sales = myScanner.nextDouble();
			
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
				
		for(int =0 ; i < team.length; i++) {
			if(team[i].getSales() == this.highestSales) {
				System.out.println("Ths following had the highest sales:");
				System.out.println("Name :" + team[i].getName());
				System.out.println("Sales:" + team[i].getSales());
				System.out.println("$" + (this.highestSales - this.AverageSales) + "above the average");
			}
		}
		
		System.out.println("The rest performed as follows : ");
		for(int =0 ; i = team.length; i++) {
			if(team[i].getSales() > this.averageSales) {
				System.out.println("Name:" + team[i].getName());
				System.out.println("Sales:" + team[i].getSales());
				System.out.println("$" + (team[i].getSales()- this.AverageSales) + "above the average");
			}
			else {
				System.out.println("Name:" + team[i].getName());
				System.out.println("Sales:" + team[i].getSales());
				System.out.println("$" + ( this.AverageSales - team[i].getSales()) + "below the average");
			}
		}
	}		
	
}
