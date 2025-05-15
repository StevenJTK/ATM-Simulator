package atm.simulator;
import java.util.ArrayList;

public class Account {
    private final String accountNumber;
    private final String pin;
    private double balance;

    Balance bal = new Balance(new ArrayList<>());

    public Account(String accountNumber, double initialBalance, String pin) {
        validateAccountNumber(accountNumber);
        validatePin(pin);
        bal.validateBalance(initialBalance);

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

    public String getAccountNumber() {
        return accountNumber;
    }


    public boolean verifyPin(String inputPin) {
        if (inputPin == null) {
            return false;
        }
        return this.pin.equals(inputPin);
    }

    public double getBalance() {
        return bal.getBalance();
    }
}