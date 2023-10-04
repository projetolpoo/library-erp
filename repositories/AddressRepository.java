package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Address;

public class AddressRepository implements IRepository<Address>{
    
    private static AddressRepository instance;
    private Map<Integer, Address> addresses = new HashMap<>();
    private int addressIdCounter = 1;

    public static AddressRepository getInstance() {
        if (instance == null) {
            return new AddressRepository();
        }

        return instance;
    }

    // Create
    public void add(Address address) {
        address.setId(addressIdCounter++);
        addresses.put(address.getId(), address);
    }

    // Read
    public Address getById(int addressId) {
        return addresses.get(addressId);
    }

    public List<Address> getAll() {
        return new ArrayList<>(addresses.values());
    }

    // Update
    public boolean update(Address updatedAddress) {
        if (addresses.containsKey(updatedAddress.getId())) {
            addresses.put(updatedAddress.getId(), updatedAddress);
            return true;
        }
        return false; // Address not found
    }

    // Delete
    public boolean delete(int addressId) {
        if (addresses.containsKey(addressId)) {
            addresses.remove(addressId);
            return true;
        }
        return false; // Address not found
    }
}
