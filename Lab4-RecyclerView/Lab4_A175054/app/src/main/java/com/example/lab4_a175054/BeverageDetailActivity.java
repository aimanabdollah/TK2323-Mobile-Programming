package com.example.lab4_a175054;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BeverageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage_detail);

        Intent intent = getIntent();

        TextView tvName = findViewById(R.id.tv_beverage_name_detail);
        tvName.setText(intent.getStringExtra("beverageName"));

    }
}