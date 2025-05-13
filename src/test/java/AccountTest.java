import atm.simulator.Balance;
import atm.simulator.Bank;
import atm.simulator.Account;
import atm.simulator.ATMMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Bank bank;
    private ATMMachine atm;
    private Account account;
    private Balance balance;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        this.account = new Account("123456", 200.0, "1234");
        atm = new ATMMachine(bank);
        balance = new Balance(new ArrayList<>());
        bank.addAccount(account);
    }

    @Test
    @DisplayName(value = "Checking balance with authentication")
    void testAuthenticationSuccess() {
        boolean authResult = atm.authenticateUser("123456", "1234");
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
    void testInvalidPinFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Account("123456", 200.0, "1234");
        }, "Expecting throw exception for 3 digit PIN");
    }

    // Verifies 4 digit pin format works
    @Test
    void testValidPinFormat() {

        assertDoesNotThrow(() -> new Account("123456", 200.0, "1234"));
        }

    @Test
    void testInvalidAccountNumberFormat() {
        String[][] invalidAccountNumbers = {
                {"123", "This is too short."},
                {"12345645633", "This is too long."},
                {"dhvtd", "This is an invalid format."}
        };

        for(String[] invalidFormat: invalidAccountNumbers) {
            String accountNumber = invalidFormat[0];
            String description = invalidFormat[1];

            assertThrows(IllegalArgumentException.class, () -> {
                new Account(accountNumber, 200.0, "1234");
            }, "Expecting throw exception for: " + description);
        }
    }

    @Test
    void testLogoutFunctionality() {
        atm.authenticateUser("123456", "1234");
        assertTrue(atm.isAuthenticated());

        atm.logout();
        assertFalse(atm.isAuthenticated());
    }
}


