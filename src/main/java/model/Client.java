package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm ");

    private String firstName;
    private String lastName;
    private String email;
    private List<Pet> pets = new ArrayList<>();
    private final LocalDateTime registrationDate = LocalDateTime.now();
    private Location location;

    @Override
    public String toString() {
        return "Client {"
                + "\n\tfirstName = " + firstName
                + ", lastName = " + lastName
                + ", email = " + email
                + ", location = " + location
                + ", registrationDate = " + registrationDate.format(FORMATTER)
                + ",\n\tpets = " + petsToString()
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pets, client.pets)
                && Objects.equals(registrationDate, client.registrationDate)
                && Objects.equals(location, client.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, pets, registrationDate, location);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    private String petsToString() {
        String str = new String();
        for (Pet pet : pets) {
            str += pet.toString() + "\n\t\t   ";
        }
        str += "\r\t   ";
        return str;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public enum Location {
        KYIV, LVIV, ODESA, UNKNOWN;

        public static Location fromString(String value) {
            for (Location loc : values()) {
                if (loc.toString().equals(value.toUpperCase())) {
                    System.out.println("Location is accepted.");
                    return loc;
                }
            }
            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);
            return UNKNOWN;
        }
    }
}
