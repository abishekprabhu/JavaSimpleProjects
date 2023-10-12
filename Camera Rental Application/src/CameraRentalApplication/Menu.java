package CameraRentalApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
	
	private String username;
	private String password;	
	private HashMap<String,String> login = new HashMap<>();
	Scanner input = new Scanner(System.in);
	
	//constructor
	public Menu(String username, String password, HashMap<String, String> login) {
		super();
		this.username = username;
		this.password = password;
		this.login = login;
	}
	
	
	
	private int option;
	
	//method to call the functions in another class
	void showMenu() {
		Rent_A_Camera rent = new Rent_A_Camera();
		do {
			
		System.out.println("=======================");
		System.out.println("\n|     MY PROFILE     |\n");
		System.out.println("=======================");
		System.out.println("HELLO..! - "+ username+"\n");
		System.out.println("1. MY CAMERA");
		System.out.println("2. RENT A CAMERA");
		System.out.println("3. VIEW ALL CAMERAS");
		System.out.println("4. MY WALLET");
		System.out.println("5. EXIT");
		System.out.println("\n");
		
		System.out.print("CHOOSE THE OPTION: ");
		option = input.nextInt();
		input.nextLine();
		
		switch(option) {
		case 1:
			Mycamera camera = new Mycamera(username);
			camera.display();
			break;
			
		case 2: 			
			rent.rentCamera();
			break;
		
		case 3:
			rent.ViewAllCamera();
			break;
			
		case 4:
			Wallet wallet = new Wallet();
			wallet.display();
			break;
			
		case 5:
			System.out.println("THANK YOU VISITING....\n'CAMERA RENTAL APPLICATION'");
		    break;
		
	    default:
	        System.out.println("INVALID OPTION...\nPLEASE TRY AGAIN.!");
		}
		}while(option !=5);
	}



}
