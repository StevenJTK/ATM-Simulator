package atm.simulator;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    Balance balance = new Balance(new ArrayList<>());
    Account acc = new Account("123456", 200.0, "1234");
    Scanner sc = new Scanner(System.in);
    Bank bank = new Bank();

    boolean running = true;
    boolean loggedIn = false;
    String input;

    public void startProgram() throws InterruptedException {

        while (running) {
            System.out.println("Welcome to STI Bank!");
            System.out.println("Please insert your pin or exit the program.");

            input = sc.nextLine();
            if (acc.verifyPin(input)) {
                System.out.println("Your account has been successfully verified.");
                loggedIn = true;

            } else if (input.equalsIgnoreCase("exit")) {
                System.out.println("Shutting down. Thank you for using STI Bank!");
                running = false;
            } else {
                System.out.println("Wrong pin. Try again.");
            }
            // Implement fix when invalid input, return a statement rather than crashing
            while (loggedIn) {
                System.out.println("You can check your balance, deposit, withdraw or logout.");

                String input = sc.nextLine();
                switch(input) {
                    case "balance", "Balance":
                        System.out.println("Your total balance is: " + balance.getBalance());
                        break;

                    case "deposit", "Deposit":
                        System.out.println("How much would you like to deposit?");
                        balance.deposit(sc.nextDouble());
                        sc.nextLine();
                        Thread.sleep(1000);
                        System.out.println("Your total balance is now: " + balance.getBalance() + " kr");
                        Thread.sleep(1000);
                        break;

                    case "withdraw", "Withdraw":
                        System.out.println("How much would you like to withdraw?");
                        balance.withdraw(sc.nextDouble());
                        sc.nextLine();
                        Thread.sleep(1000);
                        System.out.println("You have: " + balance.getBalance() + " kr left.");
                        Thread.sleep(1000);
                        break;

                    case "logout", "Logout":
                        System.out.println("Logging out. Thank you for using STI Bank!");
                        Thread.sleep(1000);
                        loggedIn = false;
                }
            }
        }
    }
}