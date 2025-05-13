import atm.simulator.Account;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AccountReceiptTest {

    @Test
    public void testReceiptIsGeneratedAfterWithdrawal() throws IOException {
        // Skapa konto och gör uttag
        Account account = new Account("123456", 1000.0, "1234");
        account.withdraw(200);

        File receiptDir = new File("receipts");
        File[] receipts = receiptDir.listFiles((dir, name) -> name.startsWith("123456"));

        assertNotNull(receipts, "Receipts folder should not be null");
        assertTrue(receipts.length > 0, "Receipt file should be created after withdrawal");
    }
}