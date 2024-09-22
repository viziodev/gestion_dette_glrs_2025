package com.ism.view;

import java.util.List;
import java.util.Scanner;

import com.ism.core.factory.Factory;
import com.ism.entities.Client;
import com.ism.services.ClientService;
import com.ism.services.impl.ClientServiceImpl;

public class Main {
    public static void main(String[] args) {
        int choix;
        Scanner scanner = new Scanner(System.in);


        // Couplage Fort

        ClientService clientServiceImpl = new ClientServiceImpl(
                Factory.getInstanceClientRepository(),
                Factory.getInstanceUserRepository());
        Client client;
        do {
            System.out.println("1-Creer Client");
            System.out.println("2-Lister Client");
            System.out.println("3-Rechercher  Client Par Telephone");
            System.out.println("4-Creer un Compte User");
            System.out.println("5-Lister les comptes User");
            System.out.println("6-Quitter");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    // Entite
                    client = new Client();
                    System.out.println("Entrer le surnom");
                    String surname = scanner.nextLine();
                    if (clientServiceImpl.searchClientBySurname(surname) != null) {
                        System.out.println("Le surname esxiste deja");
                    } else {
                        client.setSurname(surname);
                        System.out.println("Entrer le Telephone");
                        client.setTelephone(scanner.nextLine());
                        System.out.println("Entrer l'adresse");
                        client.setAdresse(scanner.nextLine());
                        clientServiceImpl.createClient(client);
                    }
                    // Hydrater

                    break;
                case 2:
                    List<Client> list = clientServiceImpl.findAllClient();
                    list.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Entrer le Telephone");
                    String tel = scanner.nextLine();
                    client = clientServiceImpl.searchClient(tel);
                    if (client == null) {
                        System.out.println("Pas de client");
                    } else {
                        System.out.println(client);
                    }

                    break;

                default:
                    break;
            }

        } while (choix != 6);

        scanner.close();
    }
}