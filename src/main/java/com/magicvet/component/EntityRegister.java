package com.magicvet.component;

import com.magicvet.Main;
import model.Client;
import model.Pet;
import service.ClientService;
import service.PetService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRegister {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();
    private List<Client> clients = new ArrayList<>();

    public void registerClients() {

        String message = "Do you want to register more clients? (y/n): ";
        do {
            Client client = addClient();
            if (client != null) {
                clients.add(client);
            }
        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> clientsByLocation = groupClients(clients);
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

    private Map<Client.Location, List<Client>> groupClients(List<Client> clients) {
        List<Client> fromKyiv = new ArrayList<>();
        List<Client> fromLviv = new ArrayList<>();
        List<Client> fromOdesa = new ArrayList<>();

        for (Client client : clients) {
            switch (client.getLocation()) {
                case KYIV:
                    fromKyiv.add(client);
                    break;
                case LVIV:
                    fromLviv.add(client);
                    break;
                case ODESA:
                    fromOdesa.add(client);
            }
        }

        Map<Client.Location, List<Client>> clientsByLocation = new HashMap<>();
        clientsByLocation.put(Client.Location.KYIV, fromKyiv);
        clientsByLocation.put(Client.Location.LVIV, fromLviv);
        clientsByLocation.put(Client.Location.ODESA, fromOdesa);

        return clientsByLocation;
    }

    private Client addClient() {
        Client client = clientService.registerNewClient();

        if (client != null) {
            registerPets(client);
            System.out.println(client);
        }

        return client;
    }

    private void registerPets(Client client) {
        String message = "Do you want to add more pets for the current client? (y/n): ";
        do {
            addPet(client);
        } while (verifyRepeating(message));
    }

    private void addPet(Client client) {
        System.out.println("Adding a new pet.");

        Pet pet = petService.registerNewPet();
        if (pet != null) {
            client.addPet(pet);
            pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
            System.out.println("Pet has been added.");
        }
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
