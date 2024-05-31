package service;

import com.magicvet.Main;
import model.Client;
import model.Client.Location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[a-zA-Z-]{3,}$";

    public Client registerNewClient() {

        String firstName, lastName, email, location;

        Client client = null;

        System.out.println("Please provide client details.");
        do {
            System.out.print("First name: ");
            firstName = Main.SCANNER.nextLine();
            if (isNameValid(firstName)) {
                System.out.println("First name is accepted.");
            } else {
                System.out.println("Provided first name is invalid. Please try again.");
            }
        } while (!isNameValid(firstName));
        do {
            System.out.print("Last name: ");
            lastName = Main.SCANNER.nextLine();
            if (isNameValid(lastName)) {
                System.out.println("Last name is accepted.");
            } else {
                System.out.println("Provided last name is invalid. Please try again.");
            }
        } while (!isNameValid(lastName));
        do {
            System.out.print("Email: ");
            email = Main.SCANNER.nextLine();
            if (isEmailValid(email)) {
                System.out.println("Email is accepted.");
            } else {
                System.out.println("Provided email is invalid. Please try again.");
            }
        } while (!isEmailValid(email));

        do {
            System.out.print("Location (Kyiv/Lviv/Odesa): ");
            location = Main.SCANNER.nextLine();
            if (isLocationValid(location)) {
                System.out.println("Location is accepted.");
            } else {
                System.out.println("Provided location is invalid. Please try again.");
            }
        } while (!isLocationValid(location));

        client = buildClient(firstName, lastName, email, Location.valueOf(location.toUpperCase()));
        System.out.println("New client: " + client.getFirstName() + " " + client.getLastName()
                + " (" + client.getEmail() + ") " + client.getLocation());

        return client;
    }

    private static Client buildClient(String firstName, String lastName, String email, Location location) {
        Client client = new Client();

        client.setFirstName(firstName);

        client.setLastName(lastName);

        client.setEmail(email);

        client.setLocation(location);

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

    private static boolean isLocationValid(String location) {
        for (Location loc : Location.values()) {
            if (loc.name().equals(location.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}

