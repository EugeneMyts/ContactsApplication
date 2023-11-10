package org.example;

import java.util.List;

public interface Storage {

    public Contact get(String email);

    public List<Contact> getAll();

    public void save(Contact contact);

    public void delete(String email);

}
