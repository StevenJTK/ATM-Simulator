package atm.simulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Skapar ett konto
        Account account = new Account("123456", 1000, "1234");

        System.out.println("Välkommen till ATM!");

        System.out.print("Ange PIN-kod: ");
        String inputPin = scanner.nextLine();

        if (!account.verifyPin(inputPin)) {
            System.out.println("Fel PIN-kod.");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\nVälj ett alternativ:");
            System.out.println("1. Se saldo");
            System.out.println("2. Ta ut pengar");
            System.out.println("3. Avsluta");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Ditt saldo är: $" + account.getBalance());
                    break;
                case "2":
                    System.out.print("Ange belopp att ta ut: ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    if (amount > account.getBalance()) {
                        System.out.println("Otillräckligt saldo.");
                    } else {
                        account.withdraw(amount);
                        System.out.println("Uttag genomfört. Kvitto genererat.");
                    }
                    break;
                case "3":
                    System.out.println("Tack för att du använde ATM!");
                    running = false;
                    break;
                default:
                    System.out.println("Ogiltigt val.");
            }
        }
        scanner.close();
    }
}