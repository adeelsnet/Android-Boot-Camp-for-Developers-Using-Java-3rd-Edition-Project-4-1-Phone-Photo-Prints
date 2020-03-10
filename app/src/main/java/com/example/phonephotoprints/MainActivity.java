package com.example.phonephotoprints;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText noOfPrints;
    private RadioButton fourBySix, fiveBySeven, eightByTen;
    private Double parseInputValToInt, result;
    private TextView displayResult;
    private DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        noOfPrints = findViewById(R.id.NumOfPrints);
        fourBySix = findViewById(R.id.fourBySix);
        fiveBySeven = findViewById(R.id.fiveBySeven);
        eightByTen = findViewById(R.id.eightByTen);
        displayResult = findViewById(R.id.resultDisplay);
        formatter = new DecimalFormat("$#.##");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputVal = noOfPrints.getText().toString();

                if (inputVal.equals("")) {
                    Toast.makeText(MainActivity.this,
                            "Please enter a number first!",
                            Toast.LENGTH_LONG).show();
                } else {
                    parseInputValToInt = Double.parseDouble(inputVal);

                    if (fourBySix.isChecked()) {
                        result = parseInputValToInt * 0.19;
                        displayResult.setText("The Order Cost is " + formatter.format(result));
//                        noOfPrints.setText("");
                    } else if (fiveBySeven.isChecked()) {
//                        noOfPrints.setText("");
                        result = parseInputValToInt * 0.49;
                        displayResult.setText("The Order Cost is " + formatter.format(result));
                    } else if (eightByTen.isChecked()) {
//                        noOfPrints.setText("");
                        result = parseInputValToInt * 0.79;
                        displayResult.setText("The Order Cost is " + formatter.format(result));
                    } else {
                        Toast.makeText(MainActivity.this,
                                "Please choose either\n\n4x6 OR 5x7 OR 8x10",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
