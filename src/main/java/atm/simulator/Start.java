package atm.simulator;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    Balance balance = new Balance(new ArrayList<>());
    Bank bank = new Bank();
    ATMMachine atm = new ATMMachine(bank);
    Account acc = new Account("123456", 200.0, "1234");
    Scanner sc = new Scanner(System.in);
    boolean running = true;


    public void startProgram() throws InterruptedException {

        System.out.println("Welcome to STI Bank!");
        System.out.println("Please insert your pin.");

        if (acc.verifyPin(sc.nextLine())) {
            System.out.println("Your account has been successfully verified.");

        } else {
            System.out.println("Wrong pin.");
        }

        while (running) {
            System.out.println("You can deposit, withdraw or exit.");

            String input = sc.nextLine();
            switch(input) {
                case "deposit":
                    System.out.println("How much would you like to deposit?");
                    balance.deposit(sc.nextDouble());
                    sc.nextLine();
                    Thread.sleep(1000);
                    System.out.println("Your total balance is now: " + balance.getBalance() + " kr");
                    Thread.sleep(1000);
                    break;

                case "withdraw":
                    System.out.println("How much would you like to withdraw?");
                    balance.withdraw(sc.nextDouble());
                    sc.nextLine();
                    Thread.sleep(1000);
                    System.out.println("You have: " + balance.getBalance() + " kr left.");
                    Thread.sleep(1000);
                    break;

                case "exit":
                    System.out.println("Thank you for using STI Bank!");
                    running = false;

            }

        }
    }
}
