package EmailID;
import java.util.*;

public class Email {
	
	// checking arrayList contains the user emailId or not
	private static boolean search(String userEmail, ArrayList<String> list) {
		
		boolean check = list.contains(userEmail);
		
		//return the boolean value
		return check;
	}
   public static void main(String[] args) {
	   
	   //Initialize some email ID into Array
	   String email[] = {"abishek@gmail.com","prabhu@gmail.com","pravanth@gmail.com","pratheesh@gmail.com","kumar@gmail.com"};
	   
	   //collection of emailID array stored in arrayList of Strings
	   ArrayList<String> list = new ArrayList<String>(Arrays.asList(email));
	   
	   //Prompt the user to enter the emailId String to search
	   Scanner in = new Scanner(System.in);
	   System.out.print("Enter the Email ID = ");
	   String userEmail = in.nextLine();  
	   
	   //check the emailid in list by calling method search
	   boolean found = search(userEmail,list);
	   
	   //if found = true
	   if(found){
		   System.out.println("\n\n\nYour Email ID = "+ userEmail+" is 'Found'");
	   }
	   //if found = false
	   else {
		   System.out.println("\n\n\nYour Email ID = "+ userEmail+" is 'Not Found'");
	   }   
   
   }

}
