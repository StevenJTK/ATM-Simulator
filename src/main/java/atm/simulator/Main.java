package atm.simulator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Balance balance = new Balance(new ArrayList<>());
        Account account = new Account("123456", "1234");
        Bank bank = new Bank();
        ATMMachine atm = new ATMMachine(bank);
        Scanner scanner = new Scanner(System.in);
        bank.addAccount(account);

        System.out.println("Welcome to STI Bank");
        System.out.println("Logging in with account number: " + account.getAccountNumber());
        account.verifyPin("1234");
        System.out.println("Your total balance is: " + balance.getBalance());
        System.out.println("Would you like to deposit or withdraw?");
        balance.deposit(scanner.nextDouble());
        System.out.println("Your total balance is: " + balance.getBalance());
        System.out.println("Would you like to withdraw?");
        balance.withdraw(scanner.nextDouble());
        System.out.println("Your total balance is: " + balance.getBalance());
        System.out.println("Thank you for using STI Bank");

    }
}
