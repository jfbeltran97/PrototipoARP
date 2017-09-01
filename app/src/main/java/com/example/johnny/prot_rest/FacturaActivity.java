package com.example.johnny.prot_rest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FacturaActivity extends AppCompatActivity {
    private PlatosAdapter adapter;
    private String[] names = {"Alitas BBQ", "Banana Split", "Bolon de verde", "Ceviche de Camaron",
            "Churrasco", "Ensalada Cesar", "Filete Mignon", "Guatita", "Mini Pizza", "Yapingacho"};
    private int[] qties;
    private double[] prices  = {4.99f, 5.99f, 8.99f, 3.99f, 4.99f, 12.99f, 15.99f, 12.99f, 4.99f, 3.99f};

    private String[] namesDef;
    private int[] qtiesDef;
    private double[] pricesDef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);
        qties = getIntent().getExtras().getIntArray("cantidades");

        filtrar();

        adapter = new PlatosAdapter(this, namesDef, qtiesDef, pricesDef);

        ListView listView = (ListView) findViewById(R.id.platosListView);
        listView.setAdapter(adapter);

        TextView totalTextView = (TextView) findViewById(R.id.totalTextView);
        double total = 0;
        for (int i = 0; i < qtiesDef.length; i++){
            total+= qtiesDef[i]*pricesDef[i];
        }
        totalTextView.setText(String.format("Total (IVA incluido): %.2f", total*1.12));
    }

    public void filtrar(){
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();
        for(int i = 0; i < qties.length; i++){
            if (qties[i] > 0){
                nombres.add(names[i]);
                quantities.add(qties[i]);
                precios.add(prices[i]);
            }
        }

        namesDef = new String[quantities.size()];
        qtiesDef = new int[quantities.size()];
        pricesDef = new double[quantities.size()];

        for(int i = 0; i < quantities.size(); i++){
            namesDef[i] = nombres.get(i);
            qtiesDef[i] = quantities.get(i);
            pricesDef[i] = precios.get(i);
        }
    }
}
