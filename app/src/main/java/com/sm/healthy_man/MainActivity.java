package com.sm.healthy_man;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.sm.healthy_man.Menu.PrivatePolicyURLActivity;
import com.sm.healthy_man.Menu.ProducentsInfoActivity;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;


import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;


import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;


    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "GoogleActivity";


    private int Connected;
    private String id;
    private String userName;

    private FirebaseDatabase firebaseDatabase;
    private ArrayList<Entry> dataVals;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();
        dataVals = new ArrayList<>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Button loginGoogle = findViewById(R.id.LoginGoogle);

        loginGoogle.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(this, R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.google_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.google);
                    break;
                }
            }
            return false;
        });

       loginGoogle.setOnClickListener(view -> signIn());


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());

                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);

                // [START_EXCLUDE]
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sign_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        MediaPlayer clickAlert1 =MediaPlayer.create(MainActivity.this, R.raw.click);
        clickAlert1.start();
        if (id == R.id.private_policy) {

            Intent intent = new Intent(MainActivity.this, PrivatePolicyURLActivity.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.producents_info) {

            Intent intent = new Intent(MainActivity.this, ProducentsInfoActivity.class);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void firebaseAuthWithGoogle(String idToken) {

        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {

                        Log.d(TAG, "signInWithCredential:success");
                        getNameAndId();
                        ReadOrInitFromFirebase();
                    }
                });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityIfNeeded(signInIntent, RC_SIGN_IN);
    }



    private void ReadOrInitFromFirebase()
    {
        try {
            firebaseDatabase.getReference().child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if ((int) dataSnapshot.getChildrenCount() != 0) {
                        Person newPerson = dataSnapshot.getValue(Person.class);
                        assert newPerson != null;
                        Connected = newPerson.Connected;

                        if (Connected == 1)
                        {
                            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else if (Connected ==0)
                        {
                            Intent intent = new Intent(MainActivity.this, StartingPage1.class);
                            startActivity(intent);

                        }

                    } else {

                        Person person = new Person(userName, id, 0, 0, 0, "brak", 0, 0, 0, 0, 0, 0, 1,0,0, 0,0 ,false, dataVals);
                        firebaseDatabase.getReference().child("users").child(id).setValue(person);

                        Intent intent = new Intent(MainActivity.this, StartingPage1.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();

        }
    }

    private void getNameAndId()
    {
        String  idNumber;
        String firebaseEmail = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
        userName = StringUtils.substringBefore(firebaseEmail, "@");
        idNumber = FirebaseAuth.getInstance().getCurrentUser().getUid();
        id =userName + idNumber;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            getNameAndId();
            ReadOrInitFromFirebase1();
        }
    }

    private void ReadOrInitFromFirebase1() {

        try {
            firebaseDatabase.getReference().child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        Person newPerson = dataSnapshot.getValue(Person.class);
                    assert newPerson != null;
                    Connected = newPerson.Connected;

                        if (Connected == 1)
                        {
                            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else if (Connected ==0)
                        {

                            FirebaseAuth.getInstance().signOut();
                        }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MediaPlayer clickAlert =MediaPlayer.create(MainActivity.this, R.raw.click);
        clickAlert.start();
    }
}