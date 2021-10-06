package com.sm.healthy_man;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;




public class TrainingDetailFragment7 extends Fragment {

    private int Id;
    private TextView trainingTextView;

    private int Diet1;
    private int Training1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layout = inflater.inflate(R.layout.fragment_training_detail7, container, false);

        trainingTextView = (TextView) layout.findViewById(R.id.trainingDetailText7);


        if (savedInstanceState != null)
        {
            Diet1 = savedInstanceState.getInt("diet1");
            Training1 = savedInstanceState.getInt("training1");
            Id = savedInstanceState.getInt("id");
        }
        else {
            TrainingActivity  activity = (TrainingActivity) getActivity();
            assert activity != null;
            Id = activity.trainingId();
            Diet1 = activity.getDiet1();
            Training1 = activity.getTraining1();
        }


       readTraining();
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("diet1", Diet1);
        savedInstanceState.putInt("training1", Training1);
        savedInstanceState.putInt("id", Id);
    }

    private void readTraining()
    {
        String trainingText;
        if (Diet1 == 2)
        {
            if (Training1==1)
            {
                trainingText = TrainingDayMassEasy.trainingDayMassEasy[Id].getTraining7();
                trainingTextView.setText(trainingText);
            }
            else if (Training1==2)
            {
                trainingText = TrainingDayMassMedium.trainingDayMassMedium[Id].getTraining7();
                trainingTextView.setText(trainingText);
            }
            else if (Training1 ==3)
            {
                trainingText = TrainingDayMassHard.trainingDayMassHard[Id].getTraining7();
                trainingTextView.setText(trainingText);
            }
        }
        else if (Diet1 ==1)
        {
            if (Training1==1)
            {
                trainingText = TrainingDayReductionEasy.trainingDayReductionEasy[Id].getTraining7();
                trainingTextView.setText(trainingText);
            }
            else if (Training1==2)
            {
                trainingText = TrainingDayReductionMedium.trainingDayReductionMedium[Id].getTraining7();
                trainingTextView.setText(trainingText);
            }
            else if (Training1 ==3)
            {
                trainingText = TrainingDayReductionHard.trainingDayReductionHard[Id].getTraining7();
                trainingTextView.setText(trainingText);
            }
        }

    }




}