package com.asuper.testwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {

    Spinner data[] = {"m","t","W","t","f","s","S"};
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        ArrayAdapter<String> adapter
                = new ArrayAdapter<> (
                    this,
                    android.R.layout.simple_list_item_1,
                    data
                );
        Spinner spinner = (Spinne
        'r) findViewById(R.id.textResult);
        spinner.setAdapter(adapter);
        textView = (TextView) findViewById(R.id.textResult);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedValue = data[position];
                textView.setText(selectedValue);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
