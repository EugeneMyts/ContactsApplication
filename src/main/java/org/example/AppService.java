package org.example;

import java.util.List;
import java.util.Scanner;

@org.springframework.stereotype.Service
public class AppService {

    private final Scanner scanner;
    private int data;
    private final ContactService contactService;

    public AppService(Scanner scanner, ContactService contactService) {
        this.scanner = scanner;
        this.contactService = contactService;
    }

    public void start() {
        System.out.println(" 1.Add contact \n 2.Find by email \n 3.Print all contacts \n 4.Delete by email \n 5.Save all contacts");
        data = scanner.nextInt();
        scanner.nextLine();

        switch (data) {
            case 1:
                System.out.println("Enter contact data");
                String dataFromConsole = scanner.nextLine();
                if (dataFromConsole.split(";").length ==3) {
                    Contact contactFromConsole = createContact(dataFromConsole);
                    contactService.save(contactFromConsole);
                } else {
                    System.out.println("bad format");
                }
                start();

            case 2:
                System.out.println("Enter email");
                String email = scanner.nextLine();
                Contact contactFromDB = contactService.get(email);
                System.out.println(contactFromDB);
                start();

            case 3:
                printAll();
                start();

            case 4:
                String emailToDelete = scanner.nextLine();
                contactService.delete(emailToDelete);
                System.out.println("If email found, it was deleted");
                start();

            case 5:
                contactService.parse();
                System.out.println("All contacts were saved");
                start();

            default:
                System.out.println("Wrong command, try again");
        }




    }

    private Contact createContact(String dataFromConsole) {
        String[] fragments = dataFromConsole.split(";");
        return new Contact(fragments[0], fragments[1], fragments[2]);
    }

    private void printAll() {
        List<Contact> all = contactService.getAll();
        for (Contact contact : all) {
            System.out.println(contact);
        }
    }

    @Override
    public String toString() {
        return "AppService";
    }
}
