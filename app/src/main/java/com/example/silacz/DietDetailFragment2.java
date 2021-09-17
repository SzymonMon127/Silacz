package com.example.silacz;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;




public class DietDetailFragment2 extends Fragment {

    private int Id;
    private int Diet1;


    private FirebaseDatabase firebaseDatabase;

    private String ProductsList;
    private String name;

    private TextView nameView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_diet_detail2, container, false);

        nameView = (TextView) layout.findViewById(R.id.name);
        Button productsView = (Button) layout.findViewById(R.id.producsList);

        productsView.setOnClickListener(v -> showList());

        firebaseDatabase = FirebaseDatabase.getInstance();

        if (savedInstanceState != null)
        {
            Diet1 = savedInstanceState.getInt("diet1");
            Id = savedInstanceState.getInt("id");
        }
        else
        {
            DietActivity  activity = (DietActivity) getActivity();
            assert activity != null;
            Id = activity.getDietId();
            Diet1 = activity.getDiet1();
        }


        LoadDiet();


        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("diet1", Diet1);
        savedInstanceState.putInt("id", Id);
    }

    private void showList()
    {

        AlertDialog.Builder alert = new AlertDialog.Builder(requireContext());

        final EditText edittext = new EditText(getContext());
        edittext.setInputType(3);
        alert.setMessage(ProductsList);
        alert.setTitle(" Products:");



        alert.setPositiveButton("Powrót", (dialog, whichButton) -> {


        });


        AlertDialog dialog = alert.create();
        dialog.setIcon(R.mipmap.icon_launcher);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.password_background);
        dialog.show();
    }
    private void LoadDiet()
    {
        if (Diet1 ==1)
        {
            if (Id%7 == 0)
            {

                firebaseDatabase.getReference().child("diet").child("reduction").child("day1").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }

            if (Id%7 == 1)
            {
                firebaseDatabase.getReference().child("diet").child("reduction").child("day2").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            if (Id%7 == 2)
            {
                firebaseDatabase.getReference().child("diet").child("reduction").child("day3").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            if (Id%7 == 3)
            {
                firebaseDatabase.getReference().child("diet").child("reduction").child("day4").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            if (Id%7 == 4)
            {
                firebaseDatabase.getReference().child("diet").child("reduction").child("day5").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            if (Id%7 == 5)
            {
                firebaseDatabase.getReference().child("diet").child("reduction").child("day6").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            if (Id%7 == 6)
            {
                firebaseDatabase.getReference().child("diet").child("reduction").child("day7").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        }

        if (Diet1 ==2)
        {
            if (Id%7 == 0)
            {
                firebaseDatabase.getReference().child("diet").child("mass").child("day1").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            if (Id%7 == 1)
            {
                firebaseDatabase.getReference().child("diet").child("mass").child("day2").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            if (Id%7 == 2)
            {
                firebaseDatabase.getReference().child("diet").child("mass").child("day3").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            if (Id%7 == 3)
            {
                firebaseDatabase.getReference().child("diet").child("mass").child("day4").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            if (Id%7 == 4)
            {
                firebaseDatabase.getReference().child("diet").child("mass").child("day5").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            if (Id%7 == 5)
            {
                firebaseDatabase.getReference().child("diet").child("mass").child("day6").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            if (Id%7 == 6)
            {
                firebaseDatabase.getReference().child("diet").child("mass").child("day7").child("meal2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if ((int) dataSnapshot.getChildrenCount() != 0) {
                            Products products = dataSnapshot.getValue(Products.class);

                            assert products != null;
                            ProductsList = products.products;
                            name = products.name;
                            nameView.setText(name);

                        }
                        else
                        {
                            Toast.makeText(getContext(), "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        }


    }

}