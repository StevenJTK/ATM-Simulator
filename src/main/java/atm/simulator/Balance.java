package atm.simulator;
import java.util.List;

public class Balance {

    private final List<Double> balances;

    // Holds total balance in account
    public Balance(List<Double> balances) {
        this.balances = balances;
    }

    // Fetches total balance and displays values
    public double getBalance() {
        if(balances.isEmpty())
            return 0.0;
        return getTotal();
    }

    // Checks value of balance
    public double getTotal() {
        double total = 0.0;
        for (double b: balances) {
            total += b;
            }
        return total;
    }


    public void deposit(double amount) {
        if (amount >= 0) {
            balances.add(amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            double currentBalance = getBalance();

            if (currentBalance >= amount) {
                balances.add(-amount);
            } else {
                System.out.println("Not enough funds to withdraw.");
            }
        } else {
            System.out.println("Invalid withdraw amount.");
        }
    }
}

