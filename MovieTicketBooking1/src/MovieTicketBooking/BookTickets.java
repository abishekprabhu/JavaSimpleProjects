package MovieTicketBooking;

import java.util.HashMap;
import java.util.Scanner;

public class BookTickets {
	
	
    private static final String SEATING[][] = {
            {"A1", "A2", "A3", "A4", "A5"},
            {"B1", "B2", "B3", "B4", "B5"},
            {"C1", "C2", "C3", "C4", "C5"},
            {"D1", "D2", "D3", "D4", "D5"},
            {"E1", "E2", "E3", "E4", "E5"}};
    private static final int NUM_ROWS = SEATING.length;
    private static final int NUM_COLS = SEATING[0].length;
    private static boolean[][] seatAvailability = new boolean[NUM_ROWS][NUM_COLS];

    
    protected static HashMap<String, String> bookingStatus = new HashMap<>();

    private String username;
    private String movie;
    private String date;
    private String showTime;
    private int numSeats;
    private int ticketPrice  = 100;
    private String seatNumber;
    
    
    Scanner in = new Scanner(System.in);
    
    public void bookTicket() {
        

        System.out.println("-- LIST OF MOVIES --");
        System.out.println("1. RRR");
        System.out.println("2. AVATAR");
        System.out.println("3. CARS-3");
        System.out.print("ENTER THE MOVIE [OPTION]: ");
        int option = in.nextInt();
        movie = getBookMovie(option);

        in.nextLine();
        System.out.print("ENTER DATE [(DD:MM:YYYY)]: ");
        date = in.nextLine();

        System.out.println("---- AVAILABLE SHOW TIMES ----");
        for (String showTime : ViewSeatingArrangement.SHOW_TIMES) {
            System.out.println(showTime);
        }
        System.out.print("ENTER SHOW TIME [HR:MIN AM/PM]: ");
        showTime = in.nextLine();

        System.out.print("ENTER NUMBER OF SEATS: ");
        numSeats = in.nextInt();
        in.nextLine();
        
        
        initializeSeats();
        if (checkSeatAvailability(numSeats)) {
        	displaySeatAvailability();
        	
            System.out.println("----Seats are available for booking----");
            
            System.out.print("Enter the Seat Number [e.g., B1,B2,B1-B5]: ");
            seatNumber = in.nextLine();
                        
            System.out.println("\nPlease make the payment: ");
            makePayment(numSeats);
            
            System.out.print("Enter your username: ");
            
            username = in.next();
            
            

            if (bookSeats(username)) {
                System.out.println("Booked "+numSeats+" tickets for Movie "+movie+" at "+date+" " +showTime);
                System.out.println("========================================================================");
                System.out.println("Your booking details:");
                System.out.println("Username: " + username);
                System.out.println("Movie: " + movie);
                System.out.println("Date: " + date);
                System.out.println("Show Time: " + showTime);
                System.out.println("Number of Seats: " + numSeats);
                System.out.println("Seat Number :"+seatNumber);
                System.out.println("========================================================================");
               // displaySeatAvailability();
                } else {
                System.out.println("Booking failed. Please try again.");
            }
        } else {
            System.out.println("Seats are not available for booking.");
        }
    }

    private void makePayment(int numSeats) {
		
		System.out.println("------- PAYMENT ------");
		System.out.println("Ticket Price Per Person: "+ticketPrice);
		System.out.println("       Number of person: "+numSeats);
		System.out.println("           Total Amount: "+(ticketPrice*numSeats));
		System.out.println("Type 'YES' to make payment or 'NO' to cancel Payment:");
		String response = in.nextLine();
		if(response.equalsIgnoreCase("YES")) {
			System.out.println("----PAYMENT SUCCESSFULLY-----");
		}
		else {
			System.out.println("----PAYMENT UNSUCCESSFULLY------");
			bookTicket();
		}
	}

	private String getBookMovie(int option) {
        switch (option) {
            case 1:
                return "RRR";

            case 2:
                return "AVATAR";

            case 3:
                return "CARS-3";

            default:
                return "Invalid Option.....! \nMOVIE is not in the list";
        }
    }
    
    private void initializeSeats() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                seatAvailability[i][j] = true;
            }
        }
    }
    
    private boolean checkSeatAvailability(int numSeats) {
        int availableSeats = 0;

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (seatAvailability[i][j]) {
                    availableSeats++;
                }
                if (availableSeats >= numSeats) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void displaySeatAvailability() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (seatAvailability[i][j]) {
                    System.out.print(SEATING[i][j] + " ");
                } else {
                    System.out.print("XX"+ " ");
                }
            }
            System.out.println();
        }
    }

    private boolean bookSeats(String username) {
        int seatsBooked = 0;

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (seatAvailability[i][j]) {
                    seatAvailability[i][j] = false;
                    seatsBooked++;

                    if (seatsBooked == numSeats) {
                        bookingStatus.put(username, getBookingDetails());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String getBookingDetails() {
        return "Movie: " + movie + ", Date: " + date + ", Show Time: " + showTime + ", Seats: " + numSeats +", SEAT NUMBERS: "+ seatNumber;
    }
}

