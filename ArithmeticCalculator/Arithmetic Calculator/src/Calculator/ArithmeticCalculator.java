package Calculator;
import java.util.*;

public class ArithmeticCalculator {

	public static void main(String[] args) {
		//initialize numbers
		int num1  , num2 ;		
		//using Scanner to get input
		Scanner in = new Scanner(System.in);
		//enter number1 input		
		System.out.print("Enter the number1 = ");
		num1 = in.nextInt();
		//enter number2 input
		System.out.print("Enter the number2 = ");
		num2 = in.nextInt();
		
		//Display the option
		System.out.print("\nChoose the Option: \n1.Addition \n2.Subtraction \n3.Multiplication \n4.Division \n5.Modulus \n\nEnter Choice = ");
		//read choice
		char choice = in.next().charAt(0);
		
		switch(choice) {
			case '1':
				 System.out.println("\nAnswer = "+ add(num1,num2));
				 break;
			
			case '2':
				System.out.println("\nAnswer = "+ sub(num1,num2));
				break;
				
			case '3':
				System.out.println("\nAnswer = "+ mul(num1,num2));
				break;
			
			case '4':
				System.out.println("\nAnswer = "+ div(num1,num2));
				break;
			
			case '5':
				System.out.println("\nAnswer = "+ mod(num1,num2));
				break;
				
			default :
				System.out.println("\nEnter the Correct Option.........");
				break;				
		}
	}
	
	//Addition method
	private static int add(int n1 , int n2) {
		
		int add = n1 + n2;
		return add;
	}
	
	//Subtraction method
	private static int sub(int n1 , int n2) {
		
		int sub = n1 - n2;
		return sub;
	}
	
	//Multiplication method
	private static int mul(int n1 , int n2) {
		
		int mul = n1 * n2;
		return mul;
	}
	
	//Division Method
	private static int  div(int n1 , int n2) {
		
		int div = n1 / n2;
		return div;
	}
	
	//modulus Method
	private static int mod(int n1 , int n2) {
		//Addition
		int mod = n1 % n2;
		return mod;
	}

}
