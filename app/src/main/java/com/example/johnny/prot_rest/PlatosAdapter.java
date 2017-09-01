package com.example.johnny.prot_rest;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by johnny on 01/09/17.
 */

public class PlatosAdapter extends BaseAdapter {
    private String[] names;
    private double[] prices;
    private int[] qties;
    private LayoutInflater inflater;


    public PlatosAdapter(Context context, String[] names, int[] qties, double[] prices){
        this.names = names;
        this.prices = prices;
        this.qties = qties;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

            View v = inflater.inflate(R.layout.item_plato, viewGroup, false);
            TextView name = (TextView) v.findViewById(R.id.nameFactTextView);
            TextView qty = (TextView) v.findViewById(R.id.qtyFactTextView);
            TextView price = (TextView) v.findViewById(R.id.priceFactTextView);

            name.setText(names[i]);
            qty.setText(Integer.toString(qties[i]));
            price.setText(String.format("$ %.2f", prices[i]*qties[i]));
            return v;

    }


}
