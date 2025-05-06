package com.atm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account account = new Account("123456", 1000.0, "1234");
        bank.addAccount(account);
        Balance balance = new Balance(new ArrayList<>());


        ATMMachine atm = new ATMMachine(bank);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välkommen till ATM");
        System.out.print("Ange kontonummer: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Ange PIN: ");
        String pin = scanner.nextLine();

        if (atm.authenticateUser(accountNumber, pin)) {
            System.out.println("Inloggning lyckades!");
            System.out.println("Ditt saldo: " + atm.checkBalance());

            atm.deposit(account);


//            System.out.println("Ditt saldo: " + totalBalance);

            System.out.println("Ditt saldo: " + atm.checkBalance());

        } else {
            System.out.println("Ditt kontonummer eller PIN var felaktig");
        }

        atm.logout();
        scanner.close();
    }
}