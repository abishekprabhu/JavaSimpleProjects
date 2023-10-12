package CameraRentalApplication;

import java.util.Scanner;

public class Wallet {
	
	    private static double balance = 0.0;
        Scanner input = new Scanner(System.in);
        
	   
	    //display amount balance
	    public void display() {
	    	System.out.println("----MY WALLET----");
	    	System.out.println("YOUR CURRENT WALLET BALANCE IS - INR"+balance);
	    	System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET?(1.YES / 2. NO) : ");
	    	String option = input.nextLine();
	    	if(option.equalsIgnoreCase("YES")) {
	    	System.out.print("ENTER THE AMOUNT TO DEPOSIT: ");
	    	double amount = input.nextDouble();
	    	input.nextLine();
	    	depositAmount(amount);
	    	System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE - INR."+ getBalance());
	    	}
	    }
         
	    
	    //deposit 
	    public static void depositAmount(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("DEPOSIT OF $" + amount + " SUCCESSFULLY");
	            getBalance();
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }
        
	    //deducted
	    public static void deductAmount(double amount) {
	        if (amount > 0 && balance >= amount) {
	            balance -= amount;
	            System.out.println("DEDUCTION OF AMOUNT $" + amount + " SUCCESSFUL");
	            getBalance();
	        } else {
	            System.out.println("INSUFFICIENT FUNDS IN THE WALLET");
	        }
	    }

	    public static double getBalance() {
	        return balance;
	    }
	}