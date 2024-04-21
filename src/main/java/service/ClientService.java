package service;

import com.magicvet.Main;
import model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static String NAME_PATTERN = "^[a-zA-Z-]{3,}$";

    public Client registerNewClient() {

        String firstName;
        String lastName;
        String email;

        Client client = null;

        System.out.println("Please provide client details.");
        do {
            System.out.print("First name: ");
            firstName = Main.SCANNER.nextLine();
            if (!isNameValid(firstName)) {
                System.out.println("Provided first name is invalid. Please try again.");
            } else {
                System.out.println("First name is accepted.");
            }
        } while (!isNameValid(firstName));
        do {
            System.out.print("Last name: ");
            lastName = Main.SCANNER.nextLine();
            if (!isNameValid(lastName)) {
                System.out.println("Provided last name is invalid. Please try again.");
            } else {
                System.out.println("Last name is accepted.");
            }
        } while (!isNameValid(lastName));
        do {
            System.out.print("Email: ");
            email = Main.SCANNER.nextLine();
            if (!isEmailValid(email)) {
                System.out.println("Provided email is invalid. Please try again.");
            } else {
                System.out.println("Email is accepted.");
            }
        } while (!isEmailValid(email));

        client = buildClient(firstName, lastName, email);
        System.out.println("New client: " + client.getFirstName() + " " + client.getLastName() + " (" + client.getEmail() + ")");

        return client;
    }

    private static Client buildClient(String firstName, String lastName, String email) {
        Client client = new Client();

        client.setFirstName(firstName);

        client.setLastName(lastName);

        client.setEmail(email);

        return client;
    }

    private static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();

    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
}
