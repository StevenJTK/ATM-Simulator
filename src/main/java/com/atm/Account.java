package com.atm;

public class Account {
    private final String accountNumber;
    private final String pin;
    private double balance;

    public Account(String accountNumber, double initialBalance, String pin) {
        validateAccountNumber(accountNumber);
        validatePin(pin);
        validateBalance(initialBalance);

        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = pin;
    }

    private void validateAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        if (!accountNumber.matches("\\d{6,10}")) {
            throw new IllegalArgumentException("Account number must be 6-10 digits");
        }
    }

    private void validatePin(String pin) {
        if (pin == null || pin.trim().isEmpty()) {
            throw new IllegalArgumentException("PIN code cannot be empty");
        }
        if (!pin.matches("\\d{4}")) {
            throw new IllegalArgumentException("PIN code must be 4 digits");
        }
    }

    private void validateBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean verifyPin(String inputPin) {
        if (inputPin == null) {
            return false;
        }
        return this.pin.equals(inputPin);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}