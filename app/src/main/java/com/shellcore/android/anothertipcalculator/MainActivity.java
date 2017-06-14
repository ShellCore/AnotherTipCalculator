package com.shellcore.android.anothertipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtBillAmount;
    private Button btnTip15;
    private Button btnTip20;
    private TextView txtTotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtBillAmount = (EditText) findViewById(R.id.edt_bill_amount);
        btnTip15 = (Button) findViewById(R.id.btn_15_tip);
        btnTip20 = (Button) findViewById(R.id.btn_20_tip);
        txtTotalAmount = (TextView) findViewById(R.id.txt_total_amount);

        btnTip15.setOnClickListener(this);
        btnTip20.setOnClickListener(this);
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

        }
    }

    private void calculateTip(double tip) {
        Double tipDoubleValue = parseTip(edtBillAmount.getText().toString());
        if (tipDoubleValue != null) {
            tipDoubleValue += tipDoubleValue * tip;
            txtTotalAmount.setText(tipDoubleValue.toString());
        }
    }

    private Double parseTip(String billAmount) {
        try {
            return Double.parseDouble(billAmount);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
