package com.shellcore.android.anothertipcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cesar on 15/06/2017.
 */
public class TipCalculatorTest {
    public static final double AMOUNT = 100.0;

    private TipCalculator tipCalculator;

    @Before
    public void setUp() throws Exception {
        tipCalculator = new TipCalculator();
    }

    @Test
    public void calculateTip_15() throws Exception {
        Double tip = 0.15;
        String totalExpected = "115.0";

        String totalAmount = tipCalculator.calculateTip(AMOUNT, tip);

        // expected: 100 + (100 * 0.15) = 115.0
        assertEquals(totalExpected, totalAmount);
    }

    @Test
    public void calculateTip_20() throws Exception {
        Double tip = 0.20;
        String totalExpected = "120.0";

        String totalAmount = tipCalculator.calculateTip(AMOUNT, tip);

        // expected: 100 + (100 * 0.20) = 120.0
        assertEquals(totalExpected, totalAmount);
    }

    @Test
    public void calculateTip_30() throws Exception {
        Double tip = 0.30;
        String totalExpected = "130.0";

        String totalAmount = tipCalculator.calculateTip(AMOUNT, tip);

        // expected: 100 + (100 * 0.30) = 130.0
        assertEquals(totalExpected, totalAmount);
    }

    @Test
    public void calculateTip_40() throws Exception {
        Double tip = 0.40;
        String totalExpected = "140.0";

        String totalAmount = tipCalculator.calculateTip(AMOUNT, tip);

        // expected: 100 + (100 * 0.40) = 140.0
        assertEquals(totalExpected, totalAmount);
    }

    @Test
    public void parseTipPi() throws Exception {
        String stringAmount = "3.14159";
        Double amountExpected = 3.14159;
        Double amount = tipCalculator.parseTip(stringAmount);

        assertEquals(amountExpected, amount);
    }

    @Test
    public void parseTipStringError() throws Exception {
        String stringAmount = "vsdnjcdv";
        Double amountExpected = null;
        Double amount = tipCalculator.parseTip(stringAmount);

        assertEquals(amountExpected, amount);
    }
}