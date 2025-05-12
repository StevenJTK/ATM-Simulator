package atm.simulator;

public class Account {
    private final String accountNumber;
    private final String pin;


    public Account(String accountNumber, String pin) {
        validateAccountNumber(accountNumber);
        validatePin(pin);

        this.accountNumber = accountNumber;
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



    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                '}';
    }
}