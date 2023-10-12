package CameraRentalApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class Mycamera {
	private String username;
	private int cameraId = 117;
	ArrayList<Camera> cameralist = new ArrayList();
	Camera camera;
	

	
	public Mycamera(String username) {
		super();
		this.username = username;
		
	}
	
	//list of arraylist camera in my camera
	void Mycameralist() {
		
		cameralist.add(new Camera(cameraId++,"Canon", "EOS 80D", 120.0,true));
        cameralist.add(new Camera(cameraId++,"Nikon", "D7500", 110,false));
        cameralist.add(new Camera(cameraId++,"Sony", "Alpha", 130,true));
	}
	
	Scanner input = new Scanner(System.in);
	
	private int option;
	void display() {
		
		Mycameralist();
		
		do {
			System.out.println("\n+=======================+");
			System.out.println("\n      MY CAMERA      \n");
			System.out.println("+=======================+");
			System.out.println("HELLO..! - "+ username+"\n");;
			System.out.println("1. ADD");
			System.out.println("2. REMOVE");
			System.out.println("3. VIEW ALL CAMERAS");
			System.out.println("4. GO TO PREVIOUS MENU");
			
			System.out.print("ENTER THE OPTION: ");
			option = input.nextInt();
			input.nextLine();
			
			
			switch(option) {
			case 1: 
				addCamera();
				break;
			
			case 2: 
				viewMyCameras();
				removeMyCamera();
				break;
				
			case 3:				
				viewMyCameras();
				break;
				
			case 4:
				System.out.println("EXIT..........!");
				System.out.println("---------------");
				break;
			
			default:
				System.out.println("INVALID OPTION ");
			}
			
		}while(option != 4);
	}
	
	
	//addcamera
	private void addCamera() {
		
		System.out.print("\nENTER THE CAMERA BRAND: ");
		String brand = input.nextLine();
		
		
		System.out.print("ENTER THE MODEL: ");
		String model = input.nextLine();
		
		System.out.print("ENTER THE PER DAY PRICE: ");
		double pricePerDay = input.nextDouble();
		input.nextLine();
		
		
		
	    camera = new Camera(cameraId++,brand,model,pricePerDay, true);
		boolean addcheck = cameralist.add(camera);
		if(addcheck) {
			System.out.println("YOUR CAMERA IS ADDED TO THE LIST...!");
		}else {
		    System.out.println("CAMERA IS NOT ADD IN THE LIST..!\nPLEASE TRY AGAIN...!");
		    addCamera();
		
		}
		
		
	}
	
	//removeCamera
	private void removeMyCamera() {
	    
	    System.out.print("\nENTER THE CAMERA ID TO REMOVE: ");
	    int id = input.nextInt();
	    
	    // Search for the camera with the given id
	    Camera cameraToRemove = null;
	    for (Camera camera : cameralist) {
	        if (camera.getId() == id) {
	            cameraToRemove = camera;
	            break;
	        }
	    }
	    
	    if (cameraToRemove != null) {
	        cameralist.remove(cameraToRemove);
	        System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST");
	    } else {
	        System.out.println("CAMERA NOT FOUND");
	    }
	}

	 //removeCamera
	 void viewMyCameras() {
			
		System.out.println("+====================+");
        System.out.println("\n|LIST OF MY CAMERAS |\n");
        System.out.println("+====================+\n");
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
