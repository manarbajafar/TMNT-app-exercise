package com.ma.lap3;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;


public class MainFragment extends Fragment {
    public static final int REQUEST_CODE_DETAILS_ACTIVITY=1234;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //
        RadioGroup group=(RadioGroup) getActivity().findViewById(R.id.turtle_group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                updateTurtleImage();
            }
        });

        //
        ImageButton img =(ImageButton) getActivity().findViewById(R.id.turtle);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDetailsAboutTurtle();
            }
        });
    }

    public void showDetailsAboutTurtle(){
        RadioGroup group=(RadioGroup) getActivity().findViewById(R.id.turtle_group);
        int id=group.getCheckedRadioButtonId();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            DetailsFragment frag=(DetailsFragment) getFragmentManager().findFragmentById(R.id.fragment2);
            frag.setTurtleId(id);
        } else{
            Intent intent= new Intent(getActivity(), DetailsActivity.class);
            intent.putExtra("turtle_id",id);
            startActivityForResult(intent, REQUEST_CODE_DETAILS_ACTIVITY);

        }

    }

    private void updateTurtleImage(){
        ImageButton img =(ImageButton) getActivity().findViewById(R.id.turtle);
        RadioGroup group=(RadioGroup) getActivity().findViewById(R.id.turtle_group);

        int checkedID= group.getCheckedRadioButtonId();
        if(checkedID == R.id.leo){
            img.setImageResource(R.drawable.leo);
        }else if (checkedID == R.id.mike){
            img.setImageResource(R.drawable.mike);
        }else if (checkedID == R.id.don){
            img.setImageResource(R.drawable.don);
        }else if (checkedID == R.id.raph){
            img.setImageResource(R.drawable.raph);
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showDetailsAboutTurtle();
        }
    }
}