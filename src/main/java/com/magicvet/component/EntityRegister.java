package com.magicvet.component;

import com.magicvet.Main;
import model.Client;
import model.Pet;
import service.ClientService;
import service.PetService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityRegister {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();
    private List<Client> clients = new ArrayList<>();

    public void registerClients() {

        String message = "Do you want to register more clients? (y/n): ";
        do {
            Optional<Client> client = addClient();
            client.ifPresent(clients::add);
        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> clientsByLocation = clients.stream()
                .collect(Collectors.groupingBy(Client::getLocation));

        printClients(clientsByLocation);
    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for (Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()) {
            String content = "\nLocation: " + clients.getKey()
                    + "\nClients (" + clients.getValue().size() + "):"
                    + "\n[" + clientsToString(clients.getValue()) + "]";

            System.out.println(content);
        }
    }


    private Optional<Client> addClient() {
        Optional<Client> client = clientService.registerNewClient();
        client.ifPresent(this::registerPets);
        return client;
    }

    private void registerPets(Client client) {
        String message = "Do you want to add more pets for the current client? (y/n): ";
        do {
            addPet(client);
            System.out.println(client);
        } while (verifyRepeating(message));
    }

    private void addPet(Client client) {
        System.out.println("Adding a new pet.");

        Optional<Pet> pet = petService.registerNewPet();
        pet.ifPresent(ob -> {
            client.addPet(ob);
            ob.setOwnerName(client.getFirstName() + " " + client.getLastName());
            System.out.println("Pet has been added.");
        });
    }

    private boolean verifyRepeating(String message) {
        System.out.print(message);

        String answer = Main.SCANNER.nextLine();
        if ("y".equals(answer.toLowerCase())) {
            return true;
        } else if ("n".equals(answer.toLowerCase())) {
            return false;
        } else {
            System.out.println("Incorrect answer. Please try again.");
            return verifyRepeating(message);
        }
    }

    private String clientsToString(List<Client> clients) {
        String str = "";
        if (clients.size() != 0) {
            for (Client client : clients) {
                str += client.toString() + "\b }" + "\n ";
            }
            str += "\b";
        }
        return str;
    }

}
