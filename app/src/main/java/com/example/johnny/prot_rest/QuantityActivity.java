package com.example.johnny.prot_rest;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class QuantityActivity extends AppCompatActivity {
    int currentIndex;
    int[] quantities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);
        currentIndex = getIntent().getIntExtra("index", 0);
        quantities = getIntent().getExtras().getIntArray("quantities");
        Log.d("quantities in QA: ", Arrays.toString(quantities));
    }

    public void sendData(View v){
        Intent i = new Intent(this, ProductActivity.class);
        EditText qtyText = (EditText) findViewById(R.id.qtyText);
        int number = Integer.parseInt(qtyText.getText().toString());
        i.putExtra("qty", number);
        i.putExtra("index", currentIndex);
        i.putExtra("quantities", quantities);
        startActivity(i);

    }
}
