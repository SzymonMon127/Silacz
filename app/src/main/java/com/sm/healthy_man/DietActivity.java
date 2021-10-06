package com.sm.healthy_man;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class DietActivity extends AppCompatActivity {

    public static final String EXTRA_DIET_ID = "dietId";

    private FirebaseDatabase firebaseDatabase;
    private String id;
    private int Diet1;
    private int dietId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        firebaseDatabase = FirebaseDatabase.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        dietId = (Integer)getIntent().getExtras().get(EXTRA_DIET_ID);

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            getNameAndId();
            ReadOrInitFromFirebase1();
        }

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void getNameAndId()
    {
        String  idNumber;
        String firebaseEmail = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
        String userName = StringUtils.substringBefore(firebaseEmail, "@");
        idNumber = FirebaseAuth.getInstance().getCurrentUser().getUid();
        id = userName + idNumber;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private static class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position)
            {

                case 0:

                    return new DietDetailFragment();
                case 1:

                    return new DietDetailFragment2();
                case 2:

                    return new DietDetailFragment3();
                case 3:

                    return new DietDetailFragment4();
            }
            return null;
        }
    }

    private void ReadOrInitFromFirebase1() {

        try {
            firebaseDatabase.getReference().child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if ((int) dataSnapshot.getChildrenCount() != 0) {
                        Person newPerson = dataSnapshot.getValue(Person.class);

                        assert newPerson != null;
                        Diet1 = newPerson.Diet;

                        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
                        ViewPager pager = findViewById(R.id.pager);
                        pager.setAdapter(pagerAdapter);
                    } else {
                        Toast.makeText(DietActivity.this, "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(DietActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();
        }
    }

    public int getDietId() {
        return dietId;
    }

    public int getDiet1() {
        return Diet1;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MediaPlayer clickAlert =MediaPlayer.create(DietActivity.this, R.raw.click);
        clickAlert.start();
    }

    }

