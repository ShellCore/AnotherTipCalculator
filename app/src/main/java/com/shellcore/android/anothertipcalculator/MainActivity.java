package com.shellcore.android.anothertipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TOTAL_KEY = "totalAmount";

    private EditText edtBillAmount;
    private Button btnTip15;
    private Button btnTip20;
    private Button btnTip30;
    private Button btnTip40;
    private TextView txtTotalAmount;
    private TipCalculator tipCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipCalculator = new TipCalculator();

        String initialValue = "";
        if (savedInstanceState != null) {
            initialValue = savedInstanceState.getString(TOTAL_KEY);
        }

        edtBillAmount = (EditText) findViewById(R.id.edt_bill_amount);
        btnTip15 = (Button) findViewById(R.id.btn_15_tip);
        btnTip20 = (Button) findViewById(R.id.btn_20_tip);
        btnTip30 = (Button) findViewById(R.id.btn_30_tip);
        btnTip40 = (Button) findViewById(R.id.btn_40_tip);
        txtTotalAmount = (TextView) findViewById(R.id.txt_total_amount);

        btnTip15.setOnClickListener(this);
        btnTip20.setOnClickListener(this);
        btnTip30.setOnClickListener(this);
        btnTip40.setOnClickListener(this);

        txtTotalAmount.setText(initialValue);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_15_tip:
                calculateTip(0.15);
                break;
            case R.id.btn_20_tip:
                calculateTip(0.20);
                break;
            case R.id.btn_30_tip:
                calculateTip(0.30);
                break;
            case R.id.btn_40_tip:
                calculateTip(0.40);
                break;
        }
    }

    private void calculateTip(double tip) {
        Double tipDoubleValue = tipCalculator.parseTip(edtBillAmount.getText().toString());
        if (tipDoubleValue != null) {
            txtTotalAmount.setText(tipCalculator.calculateTip(tipDoubleValue, tip));
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(TOTAL_KEY, txtTotalAmount.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
