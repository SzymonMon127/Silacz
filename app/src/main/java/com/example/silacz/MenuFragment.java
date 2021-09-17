package com.example.silacz;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;



import com.github.mikephil.charting.data.Entry;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Objects;


public class MenuFragment extends Fragment {

    private FirebaseDatabase firebaseDatabase;

    private String id;
    private String userName;
    private ArrayList<Entry> dataVals;

    public MenuFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseDatabase = FirebaseDatabase.getInstance();

        dataVals = new ArrayList<>();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {

            getNameAndId();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView menuRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_menu, container, false);


        int[] imageId = new int[MenuGraphics.menuResource.length];
        for (int i = 0; i < imageId.length; i++) {
            imageId[i] = MenuGraphics.menuResource[i].getImageId();
        }

        String[] captions = new String[MenuGraphics.menuResource.length];
        for (int i = 0; i < imageId.length; i++) {
            captions[i] = "hmm" + i;
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, imageId);
        menuRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        menuRecycler.setLayoutManager(layoutManager);
        adapter.setListener(position -> {
            switch (position) {
                case 0:
                    Intent intent0 = new Intent(getContext(), TrainingListActivity.class);
                    startActivity(intent0);
                    break;

                case 1:
                    Intent intent1 = new Intent(getContext(), DietListActivity.class);
                    startActivity(intent1);
                    break;

                case 2:
                    Intent intent2 = new Intent(getContext(), WalkingActivity.class);
                    startActivity(intent2);
                    break;

                case 3:
                    Intent intent3 = new Intent(getContext(), ChartActivity.class);
                    startActivity(intent3);
                    break;

                case 4:
                    Intent intent4 = new Intent(getContext(), WaterActivity.class);
                    startActivity(intent4);
                    break;

                case 5:
                    Intent intent5 = new Intent(getContext(), SettingsActivity.class);
                    startActivity(intent5);
                    break;

                case 6:
                    ResetAlert();
                    break;


                case 7:
                    System.exit(0);
                    break;

            }
        });

        return menuRecycler;

    }


    private void SaveInFirebase() {


        try {
            firebaseDatabase.getReference().child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    Person person = new Person(userName, id, 0, 0, 0, "brak", 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, false, dataVals);
                    firebaseDatabase.getReference().child("users").child(id).setValue(person);

                    goToLogin();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Błąd z bazą danych", Toast.LENGTH_SHORT).show();

        }
    }

    public void goToLogin() {




        FirebaseAuth.getInstance().signOut();

        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }

    private void getNameAndId() {
        String idNumber;
        String firebaseEmail = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
        userName = StringUtils.substringBefore(firebaseEmail, "@");
        idNumber = FirebaseAuth.getInstance().getCurrentUser().getUid();
        id = userName + idNumber;

    }

    private void ResetAlert() {

        AlertDialog.Builder alert = new AlertDialog.Builder(requireContext());

        alert.setMessage("Nie będzie odwrotu od tej decyzji.");
        alert.setTitle("Na pewno chcesz wyzerować appkę?");

        alert.setPositiveButton("Kontynuuj", (dialog, whichButton) -> SaveInFirebase());

        alert.setNegativeButton("Anuluj", (dialog, which) -> {

        });
        AlertDialog dialog = alert.create();
        dialog.setIcon(R.mipmap.icon_launcher);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.password_background);
        dialog.show();

    }
}