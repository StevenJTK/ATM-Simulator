import atm.simulator.ATMMachine;
import atm.simulator.Account;
import atm.simulator.Bank;
import org.junit.jupiter.api.Test;

public class MainTest {

    boolean isActive;


    @Test
    public void testUserLoop() {
        Account account = new Account("123456", 2000.0, "1234");
        Bank bank = new Bank();
        bank.addAccount(account);
        ATMMachine atm = new ATMMachine(bank);
        isActive = true;
        String input;

        while(isActive) {
            System.out.println("Welcome");
            System.out.println("Please enter your account number");
            input = account.getAccountNumber();

        }
    }
}
