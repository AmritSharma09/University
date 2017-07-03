package com.example.golu.registrationunive;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

Button phd,mphill,btech,mca;
    ImageView view,search,delete;
    MainActivity m;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        phd=(Button)v.findViewById(R.id.phd);
        mphill=(Button)v.findViewById(R.id.mphill);
        btech=(Button)v.findViewById(R.id.btech);
        view=(ImageView)v.findViewById(R.id.view);

        search=(ImageView)v.findViewById(R.id.search);

        delete=(ImageView)v.findViewById(R.id.delete);
        mca=(Button)v.findViewById(R.id.mca);
        m= (MainActivity) getActivity();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.callDeleteFragment();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m.callView();

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.callSearch();
            }
        });


        phd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               m.callStudentFragment();
            }
        });
        mphill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.callStudentFragment();
            }
        });
        btech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.callStudentFragment();
            }
        });
        mca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.callStudentFragment();
            }
        });
        return v;
    }

}
