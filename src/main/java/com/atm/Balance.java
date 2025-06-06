package com.atm;

import java.util.List;

public class Balance {

        private final List<Double> balances;

        // Holds total balance in account
        public Balance(List<Double> balances) {
            this.balances = balances;
        }

        // Fetches total balance and displays values
        public double checkTotal() {
            if(balances.isEmpty())
                return 0.0;
            return getTotal();
        }

        // Checks value of balance
        public double getTotal() {
            double total = 0.0;
            for (double b: balances) {
                if (b > 0) { // Removes negative numbers
                    total += b;
                }
            }
            return total;
        }
    }