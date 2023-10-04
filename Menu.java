import java.util.Scanner;

import controllers.UserController;
import helpers.InputValidator;

public class Menu {
    private UserController userController;
    private InputValidator inputValidator;

    public Menu(
    ) {
        this.userController = new UserController();
        this.inputValidator = InputValidator.getInstance();
    }


    private void options() {
        System.out.println("===== Menu =====");
        System.out.println("1. Create User");
        System.out.println("2. Read Users");
        System.out.println("3. Update User");
        System.out.println("4. Delete User");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void run() {        
        while (true) {
            this.options();
    
            int choice;
            try {
                choice = this.inputValidator.getInt("Type the option: ", 1, 5);
            } catch (Exception e) {
                choice = 6;
            }

            switch (choice) {
                case 1:
                    this.userController.add();
                    break;
                case 2:
                    this.userController.getAll();
                    break;
                case 3:
                    this.userController.update();
                    break;
                case 4:
                    this.userController.delete();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    this.inputValidator.closeScanner();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
