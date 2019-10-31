package com.example.farmval;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chaquo.python.Python;
import com.chaquo.python.PyObject;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    private Button mSubmitButton;
    EditText input1, input2, input3, input4, input5, input6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mSubmitButton = (Button) findViewById(R.id.submit_button);

        input1 = (EditText) findViewById(R.id.editText1);
        input2 = (EditText) findViewById(R.id.editText2);
        input3 = (EditText) findViewById(R.id.editText3);
        input4 = (EditText) findViewById(R.id.editText4);
        input5 = (EditText) findViewById(R.id.editText5);
        input6 = (EditText) findViewById(R.id.editText6);


        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input1.getText().toString().isEmpty()
                        || input2.getText().toString().isEmpty()
                        || input3.getText().toString().isEmpty()
                        || input4.getText().toString().isEmpty()
                        || input5.getText().toString().isEmpty()
                        || input6.getText().toString().isEmpty()
                ) {
                    Toast.makeText(getApplicationContext(), "Enter the Data",
                            Toast.LENGTH_SHORT).show();
                } else {

                    if(!Python.isStarted()){
                        Python.start(new AndroidPlatform(getApplicationContext()));
                    }

                    Python py = Python.getInstance();

                    PyObject pyf = py.getModule("soil");

                    PyObject obj = pyf.callAttr(
                            "test", input1.getText().toString(), input2.getText().toString(),
                             input3.getText().toString(), input4.getText().toString(),
                             input5.getText().toString(), input6.getText().toString());

                    Log.i("testing", obj.toString());

                }
            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
