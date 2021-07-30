package com.example.mylocation_a175054;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.security.cert.CertPathBuilder;

public class MainActivity extends AppCompatActivity {

    TextView tvLocation;
    FusedLocationProviderClient mFusedLocationClient;
    LocationRequest mLocationRequest;
    LocationCallback mLocationCallback;

    LocationSettingsRequest.Builder mLocationSettingsBuilder;
    SettingsClient client;
    Task<LocationSettingsResponse> task;
    private static final int REQUEST_CHECK_SETTINGS = 0x1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLocation = findViewById(R. id. tv_location);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
               if(locationResult == null)
               {
                   return;
               } else
                   tvLocation.append("\n"+"Latitude: " +locationResult.getLastLocation().getLatitude() +" Longitude" +
                           locationResult.getLastLocation().getLongitude());
            }
        };

        setLocationRequestSettings();


    }

    @Override
    protected void onResume() {
        super.onResume();
        //startLocationUpdates();
        requestLocationUpdate();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(mFusedLocationClient !=null)
        {
            mFusedLocationClient.removeLocationUpdates(mLocationCallback);
          //  Toast.makeText(MainActivity.this, "Listener is Removed",Toast.LENGTH_SHORT).show();


        }
    }


    private void requestLocationUpdate()
    {
        mLocationSettingsBuilder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);
        client = LocationServices.getSettingsClient(MainActivity.this);


        task = client.checkLocationSettings(mLocationSettingsBuilder.build());

        task.addOnSuccessListener(MainActivity.this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {

                startLocationUpdates();

            }
        });

        task.addOnFailureListener(MainActivity.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(e instanceof ResolvableApiException)
                {
                    try
                        {
                            ResolvableApiException resolvable = (ResolvableApiException)e;
                            resolvable.startResolutionForResult(MainActivity.this, REQUEST_CHECK_SETTINGS);

                        }
                    catch (IntentSender.SendIntentException sendEx)
                    {

                    }
                }
            }
        });
    }

    private void setLocationRequestSettings()
    {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(3000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


    }

    private void startLocationUpdates()
    {
       if (ContextCompat.checkSelfPermission(MainActivity.this,
               Manifest.permission.ACCESS_FINE_LOCATION)
               != PackageManager.PERMISSION_GRANTED) {

           if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                   Manifest.permission.ACCESS_FINE_LOCATION)) {

               showExplanation();

           } else {
               ActivityCompat.requestPermissions(MainActivity.this,
                       new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                       0);
           }
       } else {

           mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, null);
         //  Toast.makeText(MainActivity.this, "Location Permission was granted",Toast.LENGTH_SHORT).show();
           
           }
       
    }

    private void showExplanation()
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Requires Location Permission");
        builder.setMessage("This app needs location permission to get the location information");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        0);

            }
        });

        builder.setNegativeButton("Cancel" , new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             //   Toast.makeText(MainActivity.this, "Sorry this function can not be worked until the permission is granted",
              //          Toast.LENGTH_SHORT).show();

            }
        });
        builder.show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case REQUEST_CHECK_SETTINGS:

                switch (resultCode)
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(MainActivity.this, "Location setting has turn on" , Toast.LENGTH_LONG).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(MainActivity.this, "Location setting has not turn on" , Toast.LENGTH_LONG).show();
                        break;



                }

        }
    }
}