package com.example.gripcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

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
    RadioButton bilateralRadioButton;
    RadioButton unilateralRadioButton;
    TextView rightTextView;
    TextView leftTextView;

    Boolean isUni = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.calculate_button);
        rightOne = findViewById(R.id.right_first_edit_text);
        rightTwo = findViewById(R.id.right_second_edit_text);
        rightThree = findViewById(R.id.right_third_edit_text);
        leftOne = findViewById(R.id.left_first_edit_text);
        leftTwo = findViewById(R.id.left_second_edit_text);
        leftThree = findViewById(R.id.left_third_edit_text);
        rightAvg = findViewById(R.id.right_avg);
        leftAvg = findViewById(R.id.left_avg);
        bilateralRadioButton = findViewById(R.id.bilateral_radio_button);

        unilateralRadioButton = findViewById(R.id.unilateral_radio_button);
        rightTextView = findViewById(R.id.right_text_view);
        leftTextView = findViewById(R.id.left_text_view);
    }


    public void doBilateralCalculation() {

        String l1 = leftOne.getText().toString();
        String l2 = leftTwo.getText().toString();
        String l3 = leftThree.getText().toString();
        String r1 = rightOne.getText().toString();
        String r2 = rightTwo.getText().toString();
        String r3 = rightThree.getText().toString();

        if (l1.trim().isEmpty() || l2.trim().isEmpty() || l3.trim().isEmpty() || r1.trim().isEmpty()
                || r2.trim().isEmpty() || r3.trim().isEmpty()) {
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Error");
            alert.setMessage("Please fill in all blanks.");
            alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            alert.show();
        } else {

            double leftFirst = Double.parseDouble(l1);
            double leftSecond = Double.parseDouble(l2);
            double leftThird = Double.parseDouble(l3);

            double rightFirst = Double.parseDouble(r1);
            double rightSecond = Double.parseDouble(r2);
            double rightThird = Double.parseDouble(r3);

            double leftAverage = (leftFirst + leftSecond + leftThird) / 3;
            double leftTwoDecimal = Math.round(leftAverage * 100.0) / 100.0;
            String leftFinal = Double.toString(leftTwoDecimal);

            double rightAverage = ((rightFirst + rightSecond + rightThird) / 3);
            double rightTwoDecimal = Math.round(rightAverage * 100.0) / 100.0;
            String rightFinal = Double.toString(rightTwoDecimal);


            leftAvg.setText(leftFinal);
            rightAvg.setText(rightFinal);
        }
    }

    public void doUnilateralCalculation() {

        String r1 = rightOne.getText().toString();
        String r2 = rightTwo.getText().toString();
        String r3 = rightThree.getText().toString();

        if (r1.trim().isEmpty() || r2.trim().isEmpty() || r3.trim().isEmpty()) {
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Error");
            alert.setMessage("Please fill in all blanks.");
            alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            alert.show();
        } else {

            double rightFirst = Double.parseDouble(r1);
            double rightSecond = Double.parseDouble(r2);
            double rightThird = Double.parseDouble(r3);

            double rightAverage = ((rightFirst + rightSecond + rightThird) / 3);
            double rightTwoDecimal = Math.round(rightAverage * 100.0) / 100.0;
            String rightFinal = Double.toString(rightTwoDecimal);

            rightAvg.setText(rightFinal);
        }
    }


    public void calculateClick(View view) {
        if (isUni){
            doUnilateralCalculation();
        } else {
            doBilateralCalculation();
        }
    }

    public void bilatRadioListener(View view) {
        rightTextView.setText("RIGHT");
        leftTextView.setText("LEFT");
        leftAvg.setText("0.0");
        leftOne.setEnabled(true);
        leftTwo.setEnabled(true);
        leftThree.setEnabled(true);
        leftOne.setText("0");
        leftTwo.setText("0");
        leftThree.setText("0");
        System.out.println(isUni);
        isUni = false;
        System.out.println(isUni);
    }

    public void uniRadioListener(View view) {
        rightTextView.setText("HAND");
        leftTextView.setText(" ");
        leftAvg.setText(" ");
        leftOne.getText().clear();
        leftTwo.getText().clear();
        leftThree.getText().clear();
        leftOne.setEnabled(false);
        leftTwo.setEnabled(false);
        leftThree.setEnabled(false);
        System.out.println(isUni);
        isUni = true;
        System.out.println(isUni);
    }
}