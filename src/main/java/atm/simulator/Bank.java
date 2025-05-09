package atm.simulator;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, atm.simulator.Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        if (accounts.containsKey(account.getAccountNumber())) {
            throw new IllegalStateException("Account with this number already exists");
        }
        accounts.put(account.getAccountNumber(), account);
    }

    public atm.simulator.Account findAccount(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            return null;
        }
        return accounts.get(accountNumber);
    }

    public boolean authenticate(String accountNumber, String pin) {
        Account account = findAccount(accountNumber);
        return account != null && account.verifyPin(pin);
    }
}