import atm.simulator.Balance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptTest {

    @BeforeEach
    public void cleanReceiptsFolder() {
        File dir = new File("receipts");
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
    }

    @Test
    public void testReceiptIsGeneratedAfterWithdrawal() {

        List<Double> transactions = new ArrayList<>();
        transactions.add(1000.0);  // initial deposit
        Balance balance = new Balance(transactions);


        balance.withdraw(200);
        balance.printReceipt();

        File receiptDir = new File("receipts");
        File receiptFile = new File(receiptDir, "receipt.txt");

        assertTrue(receiptFile.exists(), "Receipt file should be created after withdrawal");
    }
}



