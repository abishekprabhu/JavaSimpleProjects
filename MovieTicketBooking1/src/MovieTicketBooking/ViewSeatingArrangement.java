package MovieTicketBooking;

import java.util.Scanner;

public class ViewSeatingArrangement {

    private static final String SEATING[][] = {
            {"A1", "A2", "A3", "A4", "A5"},
            {"B1", "B2", "B3", "B4", "B5"},
            {"C1", "C2", "C3", "C4", "C5"},
            {"D1", "D2", "D3", "D4", "D5"},
            {"E1", "E2", "E3", "E4", "E5"}};
    private static final int NUM_ROWS = SEATING.length;
    private static final int NUM_COLS = SEATING[0].length;
    private static boolean[][] seatAvailability = new boolean[NUM_ROWS][NUM_COLS];
    static final String[] SHOW_TIMES = {
            "10:00 AM", "1:00 PM", "4:00 PM", "7:00 PM", "10:00 PM"
    };

    Scanner in = new Scanner(System.in);

    void display() {
        System.out.println("--LIST OF MOVIES-- \n1.RRR \n2.AVATAR \n3.CARS-3");
        System.out.print("ENTER THE MOVIE[OPTION]: ");
        int option = in.nextInt();
        String movie = getBookMovie(option);
        System.out.println("Movie: " + movie);

        in.nextLine();
        System.out.print("ENTER DATE: [(DD:MM:YYYY)] : ");
        String dateStr = in.nextLine();
        System.out.println("\n");

        System.out.println("---- AVAILABLE SHOW TIMES ----");
        for (String showTime : SHOW_TIMES) {
            System.out.println(showTime);
        }

        System.out.println("ENTER SHOW TIME:[HR:MIN AM/PM] ");
        String showTime = in.nextLine();

        viewSeatingArrangement(dateStr, showTime, movie);
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

    private void viewSeatingArrangement(String date, String showTime, String movie) {
        System.out.println("Seating Arrangement for " + movie + " " + date + " " + showTime + ": ");
        System.out.print("\nEnter the Number Of Seats: ");
        int numSeats = in.nextInt();
        setNumSeats(numSeats);
        initializeSeats();
        if (checkSeatAvailability(numSeats)) {
            displaySeatAvailability();
        } else {
            System.out.println("SEATS ARE FULLY BOOKED .....! \nPLEASE TRY AGAIN");
        }
    }

    private void displaySeatAvailability() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (seatAvailability[i][j]) {
                    System.out.print(SEATING[i][j] + " ");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    private static void initializeSeats() {
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

    private static void setNumSeats(int numSeats) {
        seatAvailability = new boolean[NUM_ROWS][NUM_COLS];
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                seatAvailability[i][j] = true;
            }
        }
    }
}