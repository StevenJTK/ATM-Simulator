import atm.simulator.Balance;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalanceTest {

    @Test
    public void totalBalance() {
        Balance balance = new Balance(new ArrayList<>());
        assertEquals(0.0, balance.getBalance());
    }

    @Test
    public void checkIfValuesArePassed() {
        List<Double> balances = new ArrayList<>();
        Balance balance = new Balance(balances);
        assertEquals(100.0, balance.getBalance());
    }

    @Test
    void insertDeposit() {
        List<Double> balances = new ArrayList<>();
        Balance balance = new Balance(balances);
        balance.deposit(100.0);
        assertEquals(100.0, balance.getBalance());
    }

    @Test
    void withdrawAmount() {
        List<Double> balances = new ArrayList<>();
        Balance balance = new Balance(balances);
        balance.deposit(100.0);
        balance.withdraw(20.0);
        assertEquals(80.0, balance.getBalance());
    }

    @Test
    void withdrawAmountWithFundsInWallet() {
        List<Double> balances = new ArrayList<>();
        Balance balance = new Balance(balances);
        balance.withdraw(20.0);
        assertEquals(50.0, balance.getBalance());
    }

    @Test
    void depositAndThenWithdrawAmount() {
        List<Double> balances = new ArrayList<>();
        Balance balance = new Balance(balances);
        balance.deposit(20.0);
        balance.withdraw(10.0);
        assertEquals(10.0, balance.getBalance());
    }
}