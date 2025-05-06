package com.atm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(new Account("123456", 1000.0, "1234"));
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
            System.out.println("Ditt saldo: " + balance.getTotal());

            System.out.print("Ange belopp att ta ut: ");
            double amount = scanner.nextDouble();

            System.out.println("Ditt saldo: " + balance.getTotal());

        } else {
            System.out.println("Ditt kontonummer eller PIN var felaktig");
        }

        atm.logout();
        scanner.close();
    }
}