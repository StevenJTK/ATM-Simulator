package com.atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(new Account("123456", 1000.0, "1234"));


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

            System.out.print("Ange belopp att ta ut: ");
            double amount = scanner.nextDouble();

        } else {
            System.out.println("Ditt kontonummer eller PIN var felaktig");
        }

        atm.logout();
        scanner.close();
    }
}