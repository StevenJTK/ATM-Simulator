package atm.simulator;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    Balance balance = new Balance(new ArrayList<>());
    Account acc = new Account("123456", 200.0, "1234");
    Scanner sc = new Scanner(System.in);

    boolean running = true;


    public void startProgram() throws InterruptedException {

        System.out.println("Welcome to STI Bank!");
        System.out.println("Please insert your pin.");

        if (acc.verifyPin(sc.nextLine())) {
            System.out.println("Your account has been successfully verified.");

        } else {
            System.out.println("Wrong pin. Try again.");
        }
        // Implement fix when invalid input, return a statement rather than crashing
        while (running) {
            System.out.println("You can check your balance, deposit, withdraw or exit.");

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

                case "exit", "Exit":
                    System.out.println("Thank you for using STI Bank!");
                    running = false;
            }
        }
    }
}
