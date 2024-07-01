package service;

import com.magicvet.Main;
import model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[a-zA-Z-]{3,}$";

    public Client registerNewClient() {

        Client client;

        System.out.println("Please provide client details.");

        String firstName = repeatedQuery("First name");

        String lastName = repeatedQuery("Last name");

        String email = repeatedQuery("Email");

        System.out.print("Location (Kyiv / Lviv / Odesa): ");
        String location = Main.SCANNER.nextLine();

        client = buildClient(firstName, lastName, email, Client.Location.fromString(location));
        System.out.println("New client: " + client.getFirstName() + " " + client.getLastName()
                + " (" + client.getEmail() + ") " + client.getLocation());

        return client;
    }

    private static Client buildClient(String firstName, String lastName, String email, Client.Location location) {
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

    private String repeatedQuery(String detailInString) {
        String detail;
        while (true) {
            System.out.print(detailInString + ": ");
            detail = Main.SCANNER.nextLine();
            if (detailInString.equals("Email") && (isEmailValid(detail)) || !detailInString.equals("Email") && (isNameValid(detail))) {
                System.out.println(detailInString + " is accepted.");
                break;
            } else {
                System.out.println("Provided " + detailInString.toLowerCase() + " is invalid. Please try again.");
            }
        }
        return detail;
    }

}

