package MovieTicketBooking;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    String username;
    String password;
    HashMap<String, String> login = new HashMap<>();

    Menu(String username, String password, HashMap<String, String> login) {
        this.username = username;
        this.password = password;
        this.login = login;
    }

    void showMenu() {
        int option;
        Scanner in = new Scanner(System.in);
        ViewSeatingArrangement view = new ViewSeatingArrangement();
        BookTickets bookTickets = new BookTickets();
        CheckBookingStatus checkBookingStatus = new CheckBookingStatus();

        System.out.println("Welcome " + username);

        System.out.println("\n--- MENU ---");
        System.out.println("1. Update Password");
        System.out.println("2. View Seating Arrangement");
        System.out.println("3. Book Ticket");
        System.out.println("4. Check Booking Status");
        System.out.println("5. Exit");

        do {
            System.out.println("=================================");
            System.out.print("Enter your Option: ");
            option = in.nextInt();
            System.out.println("\n");

            switch (option) {
                case 1:
                    UpdatePassword up = new UpdatePassword(username, password, login);
                    up.update();
                    break;

                case 2:
                    view.display();
                    break;

                case 3:
                    bookTickets.bookTicket();
                    break;

                case 4:
                    checkBookingStatus.checkStatus();
                    break;

                case 5:
                    System.out.println("****************************");
                    System.out.println("Thank You " + username);
                    break;

                default:
                    System.out.println("Invalid Option!!\nPlease Enter Option again");
                    break;
            }
        } while (option != 5);
    }
}