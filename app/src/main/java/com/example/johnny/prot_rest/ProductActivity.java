package com.example.johnny.prot_rest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import objects.Plato;

public class ProductActivity extends AppCompatActivity {

    int[] quantities = new int[10];

    String[] nombres = {"Alitas BBQ", "Banana Split", "Bolon de verde", "Ceviche de Camaron",
            "Churrasco", "Ensalada Cesar", "Filete Mignon", "Guatita", "Mini Pizza", "Yapingacho"};
    double[] precios = {4.99f, 5.99f, 8.99f, 3.99f, 4.99f, 12.99f, 15.99f, 12.99f, 4.99f, 3.99f};
    int[] imgs = {R.drawable.alitasbbq, R.drawable.banana_split,R.drawable.bolon_de_verde1,
            R.drawable.ceviche_camaron,R.drawable.churrasco,R.drawable.ensalada_cesar,
            R.drawable.filet_mignon, R.drawable.guatita, R.drawable.mini_pizza,
            R.drawable.yapingacho};
    int index=0;
    Plato[] platos = new Plato[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        setPlatos();
        retrieveqty();
        updateView();
        Log.d("debug qty: ", Arrays.toString(quantities));
    }



    public void setPlatos(){

        for(int i = 0; i < 10; i++){
            platos[i] = new Plato(nombres[i], imgs[1], precios[1]);

        }
    }

    public void changePlato(View v){
        index++;
        ImageView platosImageView = (ImageView) findViewById(R.id.platosImageView);
        TextView textView = (TextView) findViewById(R.id.namePlato);
        TextView priceTextView = (TextView) findViewById(R.id.priceTextView);
        platosImageView.setImageResource(imgs[index]);
        textView.setText(nombres[index]);
        priceTextView.setText(String.format("$ %.2f", precios[index]));

        if(index == 10){
            index = 0;
        }
    }

    public void selectQty(View v){
        Intent i = new Intent(this, QuantityActivity.class);
        i.putExtra("index", index);
        i.putExtra("quantities", quantities);
        startActivity(i);
    }

    public void retrieveqty(){

        int currentIndex = getIntent().getIntExtra("index", -1);
        int qty = getIntent().getIntExtra("qty", 0);
        Bundle extras =  getIntent().getExtras();
        index = currentIndex;
        if (extras != null){
        int[] currentQtyes = getIntent().getExtras().getIntArray("quantities");

        quantities = currentQtyes;
        Log.d("Quantity retrieved: ", Integer.toString(qty));
        if (index >= 0){
            quantities[index] = qty;
        }
        }
    }

    public void sendAllData(View v){
        //send names, prices and quantities
        Intent intent = new Intent(this, FacturaActivity.class);
        intent.putExtra("cantidades", quantities);
        startActivity(intent);
    }

    public void updateView(){
        if (index != -1){
        ImageView platosImageView = (ImageView) findViewById(R.id.platosImageView);
        TextView textView = (TextView) findViewById(R.id.namePlato);
        TextView priceTextView = (TextView) findViewById(R.id.priceTextView);
        platosImageView.setImageResource(imgs[index]);
        textView.setText(nombres[index]);
        priceTextView.setText(String.format("$ %.2f", precios[index]));}
    }
}
