package CameraRentalApplication;

import java.util.ArrayList;

public class Camera  {	
	
	//getters and setters for arraylist<camera>
	private int id ;
	private String brand;
	private String model;
	private double pricePerDay;
	private boolean checkAvailability;
	
	public Camera(int id, String brand, String model, double pricePerDay, boolean checkAvailability) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.pricePerDay = pricePerDay;
		this.checkAvailability = checkAvailability;
	}

	public String isCheckAvailable() {
		return checkAvailability==true ?"AVAILABLE" : "RENTED";
	}
	
	public boolean getCheckAvailability(){
		return checkAvailability;
	}
	

	public void setCheckAvailability(boolean checkAvailability) {
		this.checkAvailability = checkAvailability;
	}

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	@Override
	public String toString() {
		return "Camera [id=" + id + ", brand=" + brand + ", model=" + model + ", pricePerDay=" + pricePerDay
				+ ", checkAvailability=" + checkAvailability + "]";
	}

	
    
}
