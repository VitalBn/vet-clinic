package com.magicvet.component;

import com.magicvet.Main;
import model.Client;
import model.Pet;
import service.ClientService;
import service.PetService;

public class ApplicationRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                System.out.print("Would you like to register your pet? (Y/N): ");
                String answer = Main.SCANNER.nextLine();
                if (answer.toLowerCase().equals("y")) {
                    System.out.println("Adding a new pet.");
                    Pet pet = petService.registerNewPet();
                    client.setPet(pet);
                    pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                    System.out.println("Pet has been added.");
                    System.out.println(client);
                } else System.out.println("You can register your pet later. Goodbye.");
            }
        }
    }

}
