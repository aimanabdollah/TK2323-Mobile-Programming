package com.example.lab3_a175054;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R. id. toolbar_main);
        setSupportActionBar(toolbar);

        // ActionBar myActionBar = getSupportActionBar();
        // myActionBar.setDisplayHomeAsUpEnabled(false);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;
        switch (item.getItemId())
        {
            case R.id.menu_notification:
                Toast.makeText(MainActivity.this,"Notification", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(intent);

                break;

            case R.id.menu_sync:
                Toast.makeText(MainActivity.this,"Sync", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this,SyncActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_setting:
                Toast.makeText(MainActivity.this,"Setting", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}