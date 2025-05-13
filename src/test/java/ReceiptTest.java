import atm.simulator.Account;
import org.junit.jupiter.api.*;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptTest {

    @BeforeEach
    public void cleanReceiptsFolder() {
        File dir = new File("receipts");
        if (dir.exists()) {
            for (File file : dir.listFiles()) {
                file.delete(); // Rensa gamla kvitton
            }
        }
    }

    @Test
    public void testReceiptIsGeneratedAfterWithdrawal() {
        Account account = new Account("123456", 1000, "1234");
        account.withdraw(200);

        File receiptDir = new File("receipts");
        File[] receipts = receiptDir.listFiles((dir, name) -> name.startsWith("123456"));

        assertNotNull(receipts, "Receipts folder should not be null");
        assertTrue(receipts.length > 0, "Receipt file should be created after withdrawal");
    }
}
