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
    Scanner scanner = new Scanner(System.in);


    @BeforeEach
    void setUp() {
        bank = new Bank();
        this.account = new Account("123456", 1000.0, "1234");
        atm = new ATMMachine(bank);
        bank.addAccount(account);
    }

    @Test
    @DisplayName(value = "Checking balance with authentication")
    void testCheckBalanceAfterAuthentication() {
        boolean authResult = atm.authenticateUser("123456789", "1234");
        assertTrue(authResult, "Authentication should succeed");

        double balance = atm.checkBalance();
        assertEquals(1000.0, balance,
                "Balance should be 1000.0 after authentication");
    }

    @Test
    @DisplayName(value = "Checking balance without authentication")
    void testCheckBalanceWithoutAuthentication() {
        assertThrows(IllegalStateException.class, () -> {
            atm.checkBalance();
        }, "Should throw exception when checking balance without authentication");
    }

    @Test
    void testInvalidPinFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Account("123456", 1000.0, "123");
        }, "should throw exception for 3 digit PIN");

        assertThrows(IllegalArgumentException.class, () -> {
            new Account("123456", 1000.0, "12345");
        }, "should throw exception for 5 digit PIN");

        assertThrows(IllegalArgumentException.class, () -> {
            new Account("123456", 1000.0, "abcd");
        }, "should throw exception for non numeric PIN");
    }

    @Test
    void testInvalidAccountNumberFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Account("123", 1000.0, "1234");
        }, "Should throw exception for too short account number");

        assertThrows(IllegalArgumentException.class, () -> {
            new Account("12345678901", 1000.0, "1234");
        }, "Should throw exception for too long account number");

        assertThrows(IllegalArgumentException.class, () -> {
            new Account("abcdef", 1000.0, "1234");
        }, "Should throw exception for non-numeric account number");
    }

    @Test
    void testLogoutFunctionality() {
        atm.authenticateUser("123456", "1234");
        assertTrue(atm.isAuthenticated());

        atm.logout();
        assertFalse(atm.isAuthenticated());

        assertThrows(IllegalStateException.class, () -> {
            atm.checkBalance();
        }, "Should throw exception when checking balance after logout");
    }
}