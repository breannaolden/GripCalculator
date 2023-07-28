package com.example.gripcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText rightOne;
    EditText rightTwo;
    EditText rightThree;
    EditText leftOne;
    EditText leftTwo;
    EditText leftThree;
    TextView rightAvg;
    TextView leftAvg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.calculate_button);
        rightOne = findViewById(R.id.right_first_edit_text);
        rightTwo = findViewById(R.id.right_second_edit_text);
        rightThree = findViewById(R.id.right_third_edit_text);
        leftOne = findViewById(R.id.left_first_edit_text);
        leftTwo = findViewById(R.id.left_second_edit_text);
        leftThree = findViewById(R.id.left_third_edit_text);
        rightAvg = findViewById(R.id.right_avg);
        leftAvg = findViewById(R.id.left_avg);


    }

    public void doCalculation() {

        String l1 = leftOne.getText().toString();
        String l2 = leftTwo.getText().toString();
        String l3 = leftThree.getText().toString();
        String r1 = rightOne.getText().toString();
        String r2 = rightTwo.getText().toString();
        String r3 = rightThree.getText().toString();

        double leftFirst = Double.parseDouble(l1);
        double leftSecond = Double.parseDouble(l2);
        double leftThird = Double.parseDouble(l3);

        double rightFirst = Double.parseDouble(r1);
        double rightSecond = Double.parseDouble(r2);
        double rightThird = Double.parseDouble(r3);

        double leftAverage = (leftFirst + leftSecond + leftThird)/3;
        double leftTwoDecimal = Math.round(leftAverage * 100.0)/100.0;
        String leftFinal = Double.toString(leftTwoDecimal);
        leftAvg.setText(leftFinal);

        double rightAverage = ((rightFirst + rightSecond + rightThird)/3);
        double rightTwoDecimal = Math.round(rightAverage * 100.0)/100.0;
        String rightFinal = Double.toString(rightTwoDecimal);
        rightAvg.setText(rightFinal);
    }




    public void calculateClick(View view) {
        doCalculation();
    }
}