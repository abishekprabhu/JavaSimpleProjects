package MovieTicketBooking;

import java.util.HashMap;
import java.util.Scanner;

public class UpdatePassword {
    private String username;
    private String password;
    private HashMap<String, String> login;

    public UpdatePassword(String username, String password, HashMap<String, String> login) {
        this.username = username;
        this.password = password;
        this.login = login;
    }

    public void update() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your new password: ");
        String newPassword = in.nextLine();
        login.put(username, newPassword);
        System.out.println("Password updated successfully!");
    }
}