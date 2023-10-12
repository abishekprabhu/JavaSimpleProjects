package CameraRentalApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class Rent_A_Camera {

	ArrayList<Camera> cameralist= new ArrayList();
	Camera camera;
	
	Scanner input = new Scanner(System.in);
	
	
	//list of camera collected in default constructor
	public Rent_A_Camera() {
		// TODO Auto-generated constructor stub
		
		cameralist.add(new Camera(101,"Canon", "EOS 80D", 120.0,true));
        cameralist.add(new Camera(102,"Nikon", "D7500", 110.0,false));
        cameralist.add(new Camera(103,"Sony", "Alpha", 130.0,true));
        cameralist.add(new Camera(104,"Samsung", "DS123",250.0 ,true));
        cameralist.add(new Camera(105,"GOOGLE", "AS785",250.0 ,true));
        cameralist.add(new Camera(106,"pixel", "DG893",250.0 ,true));
        cameralist.add(new Camera(107,"volvo", "RT9893",250.0 ,true));
        cameralist.add(new Camera(108,"iphone", "12",250.0 ,true));
        cameralist.add(new Camera(109, "One", "XF23", 1000.0, true));
        cameralist.add(new Camera(110, "GoPro", "HERO9", 80.0, true));
        cameralist.add(new Camera(111, "DJI", "ZenIV", 300.0, true));
        cameralist.add(new Camera(112, "Sony", "A7R IV", 300.0, false));
        cameralist.add(new Camera(113, "Canon", "EOS-1D", 500.0, true));
        cameralist.add(new Camera(114, "Nikon", "Z7II", 400.0, true));
        cameralist.add(new Camera(115, "Fuji", "GFX100", 700.0, false));
        cameralist.add(new Camera(116, "Iphone", "13", 450.0, true));
        cameralist.add(new Camera(117,"Canon", "EOS 80D", 120.0,true));
        cameralist.add(new Camera(118,"Nikon", "D7500", 110,false));
        cameralist.add(new Camera(119,"Sony", "Alpha", 130,true));
        
	}
    
	
	//rentCamera
	Camera cameraToRent = null;
	void rentCamera() {
		
       
		//check list is empty or not
		if(cameralist.isEmpty()) {
			System.out.println("Cameralist is EMPTY");
			return;
		}
		//print list of camera
		System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERAS - ");
		System.out.println("\n+===================================================================================+\n");
		System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(PER DAY)\t\tSTATUS");
		System.out.println("\n+===================================================================================+\n");
		for (Camera camera : cameralist) {
			if(camera.getCheckAvailability()) {
	            System.out.println(camera.getId() + "\t\t" + camera.getBrand() + "\t\t" + camera.getModel() +
	                    "\t\t$" + camera.getPricePerDay()+"\t\t\t"+camera.isCheckAvailable());
	        }
		}
		 System.out.println("\n+===================================================================================+\n");
		
		 //getting id from user
		System.out.print("ENTER THE CAMERA ID TO RENT: ");
		int id = input.nextInt();
		input.nextLine();
		
		//checking id 
		for(Camera camera: cameralist) {
			if(camera.getId()==id) {
				cameraToRent = camera;
				break;
			}
			
		}
		
		//rent a camera-->check balance --> rented;
		if (cameraToRent != null) {
			System.out.println("----------------------------------------------------");
	        System.out.println("\nYOUR SELECTED CAMERA - " + cameraToRent.getBrand() + " " + cameraToRent.getModel());
	        double rentalPrice = cameraToRent.getPricePerDay();
	        
	        System.out.println("RENTAL PRICE PER DAY - $" + rentalPrice);
	        
	        // Retrieve wallet balance
	        Wallet wallet = new Wallet();
	        double walletBalance = wallet.getBalance();
	        System.out.println("-----------------------------------------------------");
	        System.out.println("YOUR WALLET BALANCE - $" + walletBalance);
	        System.out.println("-----------------------------------------------------");
	        // Check if wallet balance is sufficient
	        if (walletBalance < rentalPrice) {
	            System.out.println("INSUFFICIENT FUNDS IN WALLET. PLEASE DEPOSIT MONEY TO MAKE PAYMENT.");
	            return;
	        }
	        
	        // Proceed with payment
	        System.out.println("PAYMENT SUCCESSFUL...");
	        wallet.deductAmount(rentalPrice); // Deduct rental amount from wallet balance
	        
	        System.out.println("\nAFTER DEDUCTION YOUR CURRENT WALLET BALANCE: "+wallet.getBalance());
	        
	        // Update camera availability
	        cameraToRent.setCheckAvailability(false);
	        
	        System.out.println("YOUR TRANSACTION FOR CAMERA - " + cameraToRent.getBrand() + " " +
	                cameraToRent.getModel() + " WITH RENTED $" + rentalPrice + " HAS SUCCESSFULLY COMPLETED.");
	        
	        

	    } else {
	        System.out.println("CAMERA NOT FOUND.");
	    }
		
		
		
	}
	
	//viewAllcamera
	void ViewAllCamera() {
		
		System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERAS - ");
		System.out.println("\n+===================================================================================+\n");
		System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(PER DAY)\t\tSTATUS");
		System.out.println("\n+===================================================================================+\n");
        for (Camera camera : cameralist) {
			
	            System.out.println(camera.getId() + "\t\t" + camera.getBrand() + "\t\t" + camera.getModel() +
	                    "\t\t$" + camera.getPricePerDay()+"\t\t\t"+camera.isCheckAvailable());
	        
		}
        System.out.println("\n+===================================================================================+\n");
    }
	
}
	
