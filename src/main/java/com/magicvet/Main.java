package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static final String PASSWORD = "default";

    static Scanner SCANNER = new Scanner(System.in);

    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    static String NAME_PATTERN = "^[a-zA-Z-]{3,}$";

    public static void main(String[] args) {
        run();
    }


    static void run() {
        if (auth()) {
            registerNewClient();
        }

    }

    static void registerNewClient() {

        String firstName;
        String lastName;
        String email;

        System.out.println("Please provide client details.");
        do {
            System.out.print("First name: ");
            firstName = SCANNER.nextLine();
            if (!isNameValid(firstName)) {
                System.out.println("Provided first name is invalid. Try again.");
            }
        } while (!isNameValid(firstName));
        do {
            System.out.print("Last name: ");
            lastName = SCANNER.nextLine();
            if (!isNameValid(lastName)) {
                System.out.println("Provided last name is invalid. Try again.");
            }
        } while (!isNameValid(lastName));
        do {
            System.out.print("Email: ");
            email = SCANNER.nextLine();
            if (isEmailValid(email)) {
                System.out.println("Provided email is invalid. Try again.");
            }
        } while (!isEmailValid(email));

        Client client = buildClient(firstName, lastName, email);
        System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");

    }

    static Client buildClient(String firstName, String lastName, String email) {
        Client client = new Client();

        client.firstName = firstName;

        client.lastName = lastName;

        client.email = email;

        return client;
    }

    static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();

    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = Main.SCANNER.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }

        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");
        return accepted;
    }
}



