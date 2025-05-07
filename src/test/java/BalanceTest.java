import atm.simulator.Balance;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalanceTest {

    @Test
    public void totalBalance() {
        Balance balance = new Balance(new ArrayList<>());
        assertEquals(100.0, balance.getBalance());

    }

    @Test
    public void totalBalance2() {
        Balance balance = new Balance(new ArrayList<>());
        balance.getBalance();
        assertEquals(0, balance.getBalance());
    }

    @Test
    public void checkIfValuesArePassed() {
        List<Double> balances = List.of(100.0);
        Balance balance = new Balance(balances);
        assertEquals(100.0, balance.getBalance());
    }

}
