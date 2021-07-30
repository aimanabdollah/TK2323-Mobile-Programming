package com.example.labuimycafeapp_a175054;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnMinus, btnCheckout;
    TextView tvQuantity;
    EditText etName;

    int quantity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the Button with View's ID
        btnAdd = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_minus);
        btnCheckout = findViewById(R.id.btn_check_out);

        // initialize the Text View with View's ID
        tvQuantity = findViewById(R.id.tv_quantity);

        // initialize the Edit Text with View's ID
        etName = findViewById(R.id.et_name);

        // initialize quantity to 1
        quantity = 1;

        // create event listener btnAdd
        btnAdd. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                tvQuantity.setText(""+quantity);
            }
        });

        // create event listener btnMinus
        btnMinus. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity--;
                tvQuantity.setText(""+quantity);
            }
        });

        // create event listener btnCheckout
        btnCheckout. setOnClickListener(new View.OnClickListener() {
            String name;

            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                Toast.makeText(MainActivity.this,"Thank you " +name+ " for order: " +quantity+ " Latte", Toast.LENGTH_SHORT).show();



            }
        });
    }
}