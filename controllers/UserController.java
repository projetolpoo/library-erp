package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import helpers.InputValidator;
import models.Address;
import models.User;
import repositories.AddressRepository;
import repositories.UserRepository;

public class UserController {

    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private InputValidator inputValidator;

    public UserController()
    {
        this.userRepository = UserRepository.getInstance();
        this.addressRepository = AddressRepository.getInstance();
        this.inputValidator = InputValidator.getInstance();
    }

    public void add() {
        try {
            String name = this.inputValidator.getString("Type the name: ", 5, 15);

            User user = new User(name);

            while (true) {
                int opt = this.inputValidator.getInt("Type 1 - for add; 2 - to stop: ", 1, 2);
                if (opt == 1) {
                    String street = this.inputValidator.getString("Type the address street: ", 3, 256);
                    String city = this.inputValidator.getString("Type the address city: ", 3, 256);

                    Address address = new Address(street, city);
                    this.addressRepository.add(address);
                    user.addAddress(address);
                } else {
                    break;
                }
            }

            this.userRepository.add(user);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getById() {}

    public void getAll() {
        try {
            for (User user: this.userRepository.getAll()) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(){}

    public void delete(){}

}
