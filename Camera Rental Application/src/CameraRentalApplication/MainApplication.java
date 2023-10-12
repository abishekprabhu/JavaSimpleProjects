package CameraRentalApplication;

import java.util.HashMap;
import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) {
		//Login Credential
		
		Scanner input = new Scanner(System.in);
		String username;
	    String password;
		
	    
	    HashMap<String,String> login = new HashMap<>();
	    login.put("abishek","pass");
	    login.put("admin", "pass");
	    
	    do {
	    	System.out.println("+------------------------------------------------+");
	    	System.out.println("|       WELCOME TO CAMERA RENTAL APPLICATION     |");
	    	System.out.println("+------------------------------------------------+\n");
	    	
	    	System.out.println("PLEASE LOGIN TO CONTINUE\n");
	    	System.out.print("USERNAME: ");
	    	username = input.nextLine();
	    	System.out.print("PASSWORD: ");
	    	password = input.nextLine();
	    	
	    	if(autenticate(username,password,login)) {
	    		System.out.println("..........LOGIN SUCCESSFULLY........");
	    		Menu menu = new Menu(username,password,login);
	    		menu.showMenu();
	    	}else {
	    		System.out.println(".......USERNAME OR PASSWORD IS INVALID........\n\nPLEAS ENTER AGAIN.......!");
	    	}
	    	
	    }while(!autenticate(username,password,login));


	}
    
	//CheckLogin
	private static boolean autenticate(String username, String password, HashMap<String, String> login) {
		
		return login.containsKey(username) && login.get(username).equals(password);
	}

}
