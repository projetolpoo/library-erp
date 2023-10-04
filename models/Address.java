package models;

public class Address {
    private int id;
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", street=" + street + ", city=" + city + "]";
    }
    
}
