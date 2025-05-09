package atm.simulator;

import java.util.Scanner;

public class ATMMachine {
    private static final String NO_AUTHENTICATED_USER_MSG = "No authenticated user";

    private final Bank bank;
    private Account currentAccount;
    Scanner scanner = new Scanner(System.in);
    public ATMMachine(Bank bank) {
        if (bank == null) {
            throw new IllegalArgumentException("Bank cannot be null");
        }
        this.bank = bank;
    }

    public boolean authenticateUser(String accountNumber, String pin) {
        if (bank.authenticate(accountNumber, pin)) {
            currentAccount = bank.findAccount(accountNumber);
            return true;
        }
        currentAccount = null;
        return false;
    }

    public double checkBalance() {
        verifyAuthenticatedUser();
        return currentAccount.getBalance();
    }

    private void verifyAuthenticatedUser() {
        if (currentAccount == null) {
            throw new IllegalStateException(NO_AUTHENTICATED_USER_MSG);
        }
    }

    public void logout() {
        currentAccount = null;
    }

    public boolean isAuthenticated() {
        return currentAccount != null;
    }

    public void deposit(Account account) {
        System.out.println("Ange hur mycket du vill sätta in:");
        String input = scanner.nextLine();
        double amount = Double.parseDouble(input);
        if(amount <= 0 ) {
            throw new IllegalArgumentException("Amount should be greater than 0");
        }
        double balance = account.getBalance();
        account.setBalance(balance + amount);
        //return account.getBalance();
    }

}