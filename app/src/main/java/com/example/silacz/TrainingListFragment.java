package com.example.silacz;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class TrainingListFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView trainingListRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_training_list, container, false);

        int[] imageId = new int[TraningListGraphics.traningListGraphics.length];
        for (int i = 0; i < imageId.length; i++) {
            imageId[i] = TraningListGraphics.traningListGraphics[i].getImageId();
        }

        String[] captions = new String[TraningListGraphics.traningListGraphics.length];
        for (int i = 0; i < captions.length; i++) {
            captions[i] = "hmm" + i;
        }

        String[] stringDay = new String[TraningListGraphics.traningListGraphics.length];
        for (int i = 0; i < stringDay.length; i++)
        {
            stringDay[i] = "Day " + (i+1);
        }


        CaptionedImagesAdapter2 adapter = new CaptionedImagesAdapter2(captions, imageId, stringDay);
        trainingListRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        trainingListRecycler.setLayoutManager(layoutManager);
        adapter.setListener(position -> {
            Intent intent = new Intent(getActivity(), TrainingActivity.class);
            intent.putExtra(TrainingActivity.EXTRA_TRAINING_ID, position);
            requireActivity().startActivity(intent);
        });

        return trainingListRecycler;

    }
}