package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Address> addresses = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", addresses=" + addresses.toString() + "]";
    }
}