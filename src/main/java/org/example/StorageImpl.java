package org.example;

import java.util.*;

public class StorageImpl implements Storage {

private final Map<String, Contact> contacts = new HashMap<>();

    public Contact get(String email) {
        Contact contact = contacts.get(email);
        if (contact == null) {
            System.out.println("contact is not found");
        }
         return contact;
    }

    public List<Contact> getAll() {
        Collection<Contact> values = contacts.values();
        if (values.size() == 0) {
            System.out.println("contacts are empty");
        } return new ArrayList<>(values);

    }

    public void save(Contact contact) {
        contacts.put(contact.getEmail(), contact);
        System.out.println("contact saved");


    }


    public void delete(String email) {

        contacts.remove(email);
        System.out.println("contact deleted");}
}
