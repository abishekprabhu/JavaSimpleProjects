package MovieTicketBooking;


import java.util.Scanner;

public class CheckBookingStatus {
	

	public void checkStatus() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your username: ");
		String username = in.nextLine();

		if (BookTickets.bookingStatus.containsKey(username)) {
			String bookingDetails = BookTickets.bookingStatus.get(username);
			System.out.println("Booking Details:");
			System.out.println(bookingDetails);
		} else {
			System.out.println("No booking found for the given username.");
		}
	}
}