package com.example.silacz;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class DietListFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView dietListRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_diet_list, container, false);

        int[] imageId = new int[DietListGraphics.dietListGraphics.length];
        for (int i = 0; i < imageId.length; i++) {
            imageId[i] = DietListGraphics.dietListGraphics[i].getImageId();
        }

        String[] captions = new String[DietListGraphics.dietListGraphics.length];
        for (int i = 0; i < imageId.length; i++) {
            captions[i] = "hmm" + i;
        }

        String[] stringDay = new String[TraningListGraphics.traningListGraphics.length];
        for (int i = 0; i < stringDay.length; i++)
        {
            stringDay[i] = "Day " + (i+1);
        }


        CaptionedImagesAdapter2 adapter = new CaptionedImagesAdapter2(captions, imageId, stringDay);
        dietListRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        dietListRecycler.setLayoutManager(layoutManager);
        adapter.setListener(position -> {
                Intent intent = new Intent(getActivity(), DietActivity.class);
                intent.putExtra(DietActivity.EXTRA_DIET_ID, position);
                requireActivity().startActivity(intent);
        });

        return dietListRecycler;

    }
}