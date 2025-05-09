import atm.simulator.Balance;
import atm.simulator.Bank;
import atm.simulator.Account;
import atm.simulator.ATMMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
public class AccountBalanceTest {
    private Bank bank;
    private ATMMachine atm;
    private Account account;
    private Balance balance;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        this.account = new Account("123456", "1234");
        atm = new ATMMachine(bank);
        balance = new Balance(new ArrayList<>());
        bank.addAccount(account);
    }

    @Test
    @DisplayName(value = "Checking balance with authentication")
    void testAuthenticationSuccess() {
        boolean authResult = atm.authenticateUser("123456789", "1234");
        assertTrue(authResult, "Authentication should succeed");
    }

    @Test
    @DisplayName(value = "Checking balance without authentication")
    void testCheckBalanceWithoutAuthentication() {
        assertThrows(IllegalStateException.class, () -> {
            atm.checkBalance();
        }, "Should throw exception when checking balance without authentication");
    }

    @Test
    // Passes as expected
    // Refactor stage
    void testInvalidPinFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Account("123456", "123");
        }, "should throw exception for 3 digit PIN");
    }

    // Verifies 4 digit pin format works
    @Test
    void testValidPinFormat() {
        assertDoesNotThrow(() -> new Account("123456", "1234"));
        }




    @Test
    // Test passes
    // Refactor - Split into multiple tests
    // Refactor - Hard coded values?
    void testInvalidAccountNumberFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Account("123", "1234");
        }, "Should throw exception for too short account number");

        assertThrows(IllegalArgumentException.class, () -> {
            new Account("12345678901", "1234");
        }, "Should throw exception for too long account number");

        assertThrows(IllegalArgumentException.class, () -> {
            new Account("abcdef", "1234");
        }, "Should throw exception for non-numeric account number");
    }

    @Test
    // Refactor might not be needed here.
    void testLogoutFunctionality() {
        atm.authenticateUser("123456", "1234");
        assertTrue(atm.isAuthenticated());

        atm.logout();
        assertFalse(atm.isAuthenticated());
    }
}