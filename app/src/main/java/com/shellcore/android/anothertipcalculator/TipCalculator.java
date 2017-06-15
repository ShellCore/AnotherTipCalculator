package com.shellcore.android.anothertipcalculator;

/**
 * Created by Cesar on 15/06/2017.
 */

public class TipCalculator {

    public String calculateTip(double amount, double tip) {
        amount += amount * tip;
        return Double.toString(amount);
    }

    public Double parseTip(String billAmount) {
        try {
            return Double.parseDouble(billAmount);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
