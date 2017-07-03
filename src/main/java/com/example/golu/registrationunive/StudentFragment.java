package com.example.golu.registrationunive;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends Fragment {
EditText no,name,mobile,email,sub,des,date;
    Button submit,back,datePicker;

    MainActivity m;
    MyDataBase db;




    public StudentFragment() {
        // Required empty public constructor
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        db.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_student, container, false);
        no=(EditText)v.findViewById(R.id.no);
        name=(EditText)v.findViewById(R.id.name);
        mobile=(EditText)v.findViewById(R.id.mobi);
        email=(EditText)v.findViewById(R.id.email);
        sub=(EditText)v.findViewById(R.id.sub);
        des=(EditText)v.findViewById(R.id.des);

        datePicker=(Button)v.findViewById(R.id.datePicker);

        date=(EditText)v.findViewById(R.id.date);




        submit=(Button)v.findViewById(R.id.save);
        back=(Button)v.findViewById(R.id.back);
        m= (MainActivity) getActivity();

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDialog3 myDialog3 = new MyDialog3(StudentFragment.this);

                myDialog3.show(getActivity().getSupportFragmentManager(), null);


            }
        });

        db=new MyDataBase(getActivity());
        db.open();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String sno=no.getText().toString();
                String sname=name.getText().toString();
                String smobile=mobile.getText().toString();
                String semail=email.getText().toString();
                String subject=sub.getText().toString();
                String description=des.getText().toString();
                String sdate=date.getText().toString();

                if(sno.equals("")|| sname.equals("")|| smobile.equals("")|| semail.equals("")|| subject.equals("")|| description.equals("")|| sdate.equals("")){
                    Toast.makeText(getActivity(), "Do not leave Anything Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                db.insertStudent(sno,sname,smobile,semail,subject,description,sdate);

                no.setText("");
                name.setText("");
                mobile.setText("");
                email.setText("");
                sub.setText("");
                des.setText("");
                date.setText("");
                no.requestFocus();
                Toast.makeText(getActivity(),"Student Details inserted",Toast.LENGTH_SHORT).show();



            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.callHomeFragment();
            }
        });

        return v;
    }

    public void setDate(String s1) {

        date.setText(s1);

    }
}
