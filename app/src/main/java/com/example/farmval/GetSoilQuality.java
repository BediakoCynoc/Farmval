package com.example.farmval;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GetSoilQuality extends AppCompatActivity {

    private Button mSubmitButton;
    private Button mBackButton;
    EditText input1, input2, input3, input4, input5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSubmitButton = findViewById(R.id.submit_button);

        input1 = (EditText) findViewById(R.id.editText1);
        input2 = (EditText) findViewById(R.id.editText2);
        input3 = (EditText) findViewById(R.id.editText3);
        input4 = (EditText) findViewById(R.id.editText4);
        input5 = (EditText) findViewById(R.id.editText5);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input1.getText().toString().isEmpty()
                        || input2.getText().toString().isEmpty()
                        || input3.getText().toString().isEmpty()
                        || input4.getText().toString().isEmpty()
                        || input5.getText().toString().isEmpty()
                ) {
                    Toast.makeText(getApplicationContext(), "Enter the Data",
                            Toast.LENGTH_SHORT).show();
                } else {

                }
            }

//
        });

    }
}