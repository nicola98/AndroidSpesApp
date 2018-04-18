package com.example.corsista.androidspesapp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.data.Product;
import com.example.corsista.androidspesapp.logic.DetailDataAccessUtils;

import java.util.List;

/**
 * Created by Corsista on 18/04/2018.
 */

public class AddProduct extends Activity{
    EditText nomeEditText;
    long position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product_layout);
        Intent intent = getIntent();
        position = Long.parseLong(intent.getStringExtra("position2"));
        nomeEditText = (EditText) findViewById(R.id.edit_name);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProduct(position);
            }
        });

    }


    private void saveProduct(long position) {

        Product newProduct = new Product(nomeEditText.getText().toString());

        DetailDataAccessUtils.addItemToDataSource(getApplicationContext(), newProduct, position);
        finish();
    }
}
