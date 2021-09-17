package com.example.silacz;


import android.Manifest;
import android.annotation.SuppressLint;

import android.app.AlertDialog;

import android.app.NotificationChannel;
import android.app.NotificationManager;



import android.content.Intent;
import android.content.pm.PackageManager;

import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.Locale;



public class WalkingActivity extends AppCompatActivity implements OnMapReadyCallback {



    private ProgressBar progressBar;
    private LocationManager locationManager;
    private double speed;
    private int seconds;
    private boolean running;
    private double distance;
    private LatLng latLng;
    private Marker markerProfil;
    private MarkerOptions markerOptions;

    private static final String CHANNEL_ID = "1";
    private NotificationManager notificationManager;
    private NotificationCompat.Builder builder;

    GoogleMap map;

    private TextView time, distanceText, speedView;
    private   Button btnPause, btnStart, btnReset, btnMap;
    private int p=2;
    private int i;
    private LocationCallback mLocationCallback;
    private Handler handler;
    private Handler handler1;
    private int seconds1;


    private double onPause;

    private static Location lastLocation, lastLocationPause, lStart, lEnd, lStartPause, lEndPause;


    int hours;
    int minutes;
    int secs;
    String time1;

    private boolean mapClicked;
    private int buttonInt;


    FusedLocationProviderClient fusedLocationProviderClient;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);

        seconds1 =0;

        builder = new NotificationCompat.Builder(WalkingActivity.this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(distance + " xx")
                .setContentText(time1)
                .setLargeIcon(BitmapFactory.decodeResource(WalkingActivity.this.getResources(), R.drawable.ic_icon_large))
                .setPriority(NotificationCompat.PRIORITY_HIGH);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.CHANNEL_NEWS);
            String description = getString(R.string.CHANNEL_DESCRIPTION);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);



        }



        checkGPS();

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,}, 1000);
        }


        init();

        btnMap.setOnClickListener(v -> {
            if (!mapClicked)
            {
                updateUi();
                mapClicked = true;
            }
            else
            {
                deUpdateUi();
                mapClicked = false;
            }
        });



        btnStart.setOnClickListener(v -> {

            checkGPS();
            locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
            {
                return;
            }
            onPause = 0.0;
            seconds = 0;
            distance = 0.0;





            btnReset.setVisibility(View.GONE);
            btnStart.setVisibility(View.GONE);
            btnPause.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);


            running = true;

            p=0;
            buttonInt = 1;
            btnStart.setVisibility(View.GONE);
            btnPause.setBackgroundResource(R.drawable.pause_button);
        });

        btnPause.setOnClickListener(v -> {
            if (buttonInt ==1)
            {
                buttonInt = 2;
                running = false;
                p=1;
                btnPause.setBackgroundResource(R.drawable.pause_button_x);
            }
            else if (buttonInt == 2)
            {
                checkGPS();
                locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                {
                    return;
                }
                running = true;
                buttonInt =1;
                p=0;
                btnPause.setBackgroundResource(R.drawable.pause_button);
            }
        });

        btnReset.setOnClickListener(v -> {

            if (running) {
                running = false;

            }
            lStart = null;
            lStartPause = null;
            p=2;
            seconds = 0;
            distance = 0.0;
            buttonInt = 1;
            btnStart.setVisibility(View.VISIBLE);
            btnPause.setVisibility(View.GONE);
            btnPause.setBackgroundResource(R.drawable.pause_button);

        });




        displayDistance();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

    }


    private void checkGPS() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            showGPSDisabledAlert();
        }

    }

    private void showGPSDisabledAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Enable GPS to use application").setCancelable(false).setPositiveButton("ENABLE GPS", (dialog, which) -> {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        });
        alertDialogBuilder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());


        AlertDialog alert = alertDialogBuilder.create();
        alert.setIcon(R.mipmap.icon_launcher);
        alert.getWindow().setBackgroundDrawableResource(R.drawable.password_background);
        alert.show();

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putDouble("speed", speed);
        savedInstanceState.putDouble("training1", distance);
        savedInstanceState.putInt("secs", seconds);
        savedInstanceState.putBoolean("running", running);
        super.onSaveInstanceState(savedInstanceState);
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;





                NewLocation();


    }


    @Override
    protected void onResume() {
        super.onResume();
        i =0;
        checkGPS();
        getLastLocation();
    }

    @Override
    public void onBackPressed() {

        if (running)
        {
            if (i==0)
            {
                Toast.makeText(WalkingActivity.this, "Wyłącz gps'a lub stuknij 2-krotnie, aby wrócić", Toast.LENGTH_SHORT).show();
            }

            if (i >=2)
            {
                try {
                    LocationServices.getFusedLocationProviderClient(WalkingActivity.this).removeLocationUpdates(mLocationCallback);
                }
                catch (Exception ignored)
                {

                }
                if (handler1!=null)
                {
                    handler1.removeCallbacksAndMessages(null);
                    handler1 = null;
                }
                handler.removeCallbacksAndMessages(null);
                super.onBackPressed();
            }
            i++;
        }
        else
        {
            try {
                LocationServices.getFusedLocationProviderClient(WalkingActivity.this).removeLocationUpdates(mLocationCallback);
            }
            catch (Exception ignored)
            {

            }
            if (handler1!=null)
            {
                handler1.removeCallbacksAndMessages(null);
                handler1 = null;
            }
            handler.removeCallbacksAndMessages(null);
            super.onBackPressed();

        }
    }

    private void getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(task -> {
                Location location = task.getResult();


                if (location != null) {

                    if (markerProfil != null) {
                        markerProfil.remove();
                    }

                    if (progressBar.getVisibility() == View.VISIBLE)
                    {
                            progressBar.setVisibility(View.GONE);
                        btnReset.setVisibility(View.VISIBLE);
                        btnStart.setVisibility(View.VISIBLE);
                        btnPause.setVisibility(View.VISIBLE);
                    }


                    BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.locate);
                    latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    markerOptions = new MarkerOptions().position(latLng).title("location").icon(icon);
                    CameraPosition cameraPosition = new CameraPosition(latLng, 17, 0, 0);
                    map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    markerProfil = map.addMarker(markerOptions);

                }
            });
        }
        else
        {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,}, 1000);
        }

    }


    private void init()
    {
        btnPause = findViewById(R.id.stop_button);
        btnReset = findViewById(R.id.reset_button);
        btnStart = findViewById(R.id.start_button);
        distanceText = findViewById(R.id.distance);
        time = findViewById(R.id.time_view);
        speedView = findViewById(R.id.speed_view);
        btnMap = findViewById(R.id.MapButn);
        btnPause.setVisibility(View.GONE);
        progressBar = findViewById(R.id.ProgressBar);
    }

    private void updateUi() {
        distanceText.setVisibility(View.GONE);
        speedView.setVisibility(View.GONE);
        time.setVisibility(View.GONE);
        btnStart.setVisibility(View.GONE);
        btnReset.setVisibility(View.GONE);
        btnPause.setVisibility(View.GONE);
        btnMap.setBackgroundResource(R.drawable.minimize);
    }

    private void deUpdateUi() {
        distanceText.setVisibility(View.VISIBLE);
        speedView.setVisibility(View.VISIBLE);
        time.setVisibility(View.VISIBLE);
        if (!running && buttonInt!=2)
        {
            btnStart.setVisibility(View.VISIBLE);
        }
        if (p==2)
        {
            btnPause.setVisibility(View.GONE);
        }
        else {
            btnPause.setVisibility(View.VISIBLE);
        }
        btnReset.setVisibility(View.VISIBLE);
        btnMap.setBackgroundResource(R.drawable.enlarge);

    }

    private void displayDistance() {
        final TextView timeView = findViewById(R.id.time_view);
        handler = new Handler();
        handler.post(new Runnable() {
            @SuppressLint("DefaultLocale")
            @Override
            public void run() {



                timeView.setText(time1);

                if (progressBar.getVisibility() == View.GONE && running) {

                    seconds++;
                    hours = seconds/3600;
                    minutes = (seconds%3600)/60;
                    secs = seconds%60;
                    time1 =  String.format("%d:%02d:%02d",hours, minutes, secs);

                    String speedString = String.format("%1$,.2f m/s", speed);
                    String distanceStr = String.format(Locale.getDefault(),
                            "%1$,.2f kilometra", distance);

                    builder = new NotificationCompat.Builder(WalkingActivity.this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.ic_notification)
                            .setContentTitle(time1)
                            .setContentText(distanceStr + "\n" + speedString)
                            .setLargeIcon(BitmapFactory.decodeResource(WalkingActivity.this.getResources(), R.drawable.ic_icon_large))
                            .setPriority(NotificationCompat.PRIORITY_HIGH);




                    notificationManager.notify(1, builder.build());

                }

                handler.postDelayed(this, 1000);

            }
        });
    }


    private void NewLocation()
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            {

                LocationRequest mLocationRequest = LocationRequest.create();

                    mLocationRequest.setInterval(5000);
                    mLocationRequest.setFastestInterval(1000);


                mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                 mLocationCallback = new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        if (locationResult == null) {
                            return;
                        }

                            for (Location location : locationResult.getLocations()) {
                                if (location != null) {

                                    if (progressBar.getVisibility() == View.VISIBLE)
                                    {     btnPause.setVisibility(View.VISIBLE);
                                        btnReset.setVisibility(View.VISIBLE);
                                        progressBar.setVisibility(View.GONE);
                                        if (handler1 !=null)
                                        {
                                            handler1.removeCallbacksAndMessages(null);
                                            handler1 = null;
                                        }
                                    }


                                    if (p == 0)
                                    {
                                        lastLocation=location;
                                        if (lStart==null)
                                        {
                                            lStart = lEnd = lastLocation;
                                        }
                                        else
                                        {
                                            lEnd = lastLocation;
                                        }
                                        updateKmSpeedInfo();
                                        getLastLocation();
                                        Toast.makeText(WalkingActivity.this, distance + " m" + " xx   p =" + p, Toast.LENGTH_SHORT).show();
                                    }

                                    if(p == 1)
                                    {

                                        lastLocationPause=location;
                                        if (lStartPause==null)
                                        {
                                            lStart = lEnd = lastLocationPause;
                                        }
                                        else
                                        {
                                            lEndPause = lastLocationPause;
                                        }
                                    }


                                }
                            }
                        }

                };

                LocationServices.getFusedLocationProviderClient(WalkingActivity.this).requestLocationUpdates(mLocationRequest, mLocationCallback, null);

            }

        } else {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,}, 1000);

                handler1 = new Handler();
                handler1.post(new Runnable() {
                    @SuppressLint("DefaultLocale")
                    @Override
                    public void run() {

                        if (running)
                        {
                            seconds1++;
                        }
                        if (seconds1>10 && progressBar.getVisibility() == View.VISIBLE && running)
                        {
                            try {
                                LocationServices.getFusedLocationProviderClient(WalkingActivity.this).removeLocationUpdates(mLocationCallback);
                            }
                            catch (Exception ignored)
                            {
                            }
                            NewLocation();
                        }

                        handler1.postDelayed(this, 1000);

                    }
                });
        }
    }

    private void updateKmSpeedInfo()
    {
        if (lStartPause != null)
        {
            onPause = (lStartPause.distanceTo(lEndPause))/1000;
        }
        distance = (distance+(lStart.distanceTo(lEnd))/1000 ) - onPause;


        int sec = seconds;

        speed = (distance*1000)/sec;
        speed = Math.round(speed*100);
        speed = speed/100;



        @SuppressLint("DefaultLocale") String speedString = String.format("%1$,.2f m/s", speed);
        speedView.setText(speedString);


        String distanceStr = String.format(Locale.getDefault(),
                "%1$,.2f kilometra", distance);
        distanceText.setText(distanceStr);
        lStart = lEnd;
    }

}