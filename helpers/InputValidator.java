package helpers;

import java.util.Scanner;

public class InputValidator {
    
    private static InputValidator instance;
    
    private Scanner scanner;

    public static InputValidator getInstance() {
        if (instance == null) {
            return new InputValidator();
        }

        return instance;
    }

    public InputValidator() {
        this.scanner = new Scanner(System.in);
    }

    public int getInt(String prompt, int min, int max) throws Exception {
        int value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());

                if (value < min || value > max) {
                    throw new Exception("value is invalid");
                }

                break; // Input is valid, exit the loop
            } catch (NumberFormatException e) {
                throw new Exception("Invalid input. Please enter a valid integer.");
            } catch (Exception e) {
                throw e;
            }
        }
        return value;
    }

    public double getDouble(String prompt, int min, int max) throws Exception {
        double value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(scanner.nextLine());

                if (value < min || value > max) {
                    throw new Exception("value is invalid");
                }

                break; // Input is valid, exit the loop
            } catch (NumberFormatException e) {
                throw new Exception("Invalid input. Please enter a valid double.");
            } catch (Exception e) {
                throw e;
            }
        }
        return value;
    }

    public String getString(String prompt, int min, int max) throws Exception {
        String value;
        try {
            System.out.print(prompt);
            value = scanner.nextLine();

            if (value.isBlank() || value.length() < min || value.length() > max) {
                throw new Exception("value is invalid");
            }
        } catch (Exception e) {
            throw e;
        }

        return value;
    }

    public void closeScanner() {
        scanner.close();
    }
}
