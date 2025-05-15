package atm.simulator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Balance {

    private final List<Double> balances;

    public Balance(List<Double> balances) {
        this.balances = balances;
    }

    public double getBalance() {
        if (balances.isEmpty())
            return 0.0;
        return getTotal();
    }

    private double getTotal() {
        double total = 0.0;
        for (double b : balances) {
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
                printReceipt();
            } else {
                System.out.println("Not enough funds to withdraw.");
            }
        } else {
            System.out.println("Invalid withdraw amount.");
        }
    }

    public void validateBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }

    public void printReceipt() {
        File folder = new File("receipts");
        if (!folder.exists()) {
            folder.mkdir();
        }

        File file = new File(folder, "receipt.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("----- STI Bank Receipt -----\n");
            writer.write("Transactions:\n");

            for (Double b : balances) {
                if (b >= 0) {
                    writer.write(String.format("Deposit: $%.2f%n", b));
                } else {
                    writer.write(String.format("Withdrawal: $%.2f%n", -b));
                }
            }

            writer.write(String.format("Current Balance: $%.2f%n", getBalance()));
            writer.write("-----------------------------------\n");

            System.out.println("Receipt saved at: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Failed to print receipt: " + e.getMessage());
        }
    }

}



