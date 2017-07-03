package com.example.golu.registrationunive;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment {
    EditText name,cell;
    TextView stdname,semail,mobi,sub;
    Button namego,cellgo,delete;
    MainActivity m;
    MyDataBase db;
    Cursor cursor;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_delete, container, false);

        stdname=(TextView)v.findViewById(R.id.dsname);
        semail=(TextView)v.findViewById(R.id.demail);
        mobi=(TextView)v.findViewById(R.id.dsmobile);
        sub=(TextView)v.findViewById(R.id.dsubject);

        name=(EditText)v.findViewById(R.id.dname);
        cell=(EditText)v.findViewById(R.id.dcell);
        namego=(Button) v.findViewById(R.id.dnamego);
        cellgo=(Button) v.findViewById(R.id.dcellgo);
        delete=(Button)v.findViewById(R.id.ddelete);


        db=new MyDataBase(getActivity());
        db.open();
        cellgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                String cellText=cell.getText().toString();
                cursor=db.searchStudentMobi(cellText);
                if(cursor!=null && cursor.moveToFirst()==true){

                    stdname.setText(cursor.getString(2));
                    semail.setText(cursor.getString(4));
                    mobi.setText(cursor.getString(3));
                    sub.setText(cursor.getString(5));
                    delete.setVisibility(View.VISIBLE);

                }
                else{
                    Toast.makeText(getActivity(),"We do n't have any information about "+cellText,Toast.LENGTH_SHORT).show();
                    cell.setText("");
                    name.setText("");
                    stdname.setText("");
                    semail.setText("");
                    mobi.setText("");
                    sub.setText("");
                    name.requestFocus();
                }

            }
        });

    delete.setOnClickListener(new View.OnClickListener() {
        @Override
           public void onClick(View view) {
            cell.setText("");
            String dname=stdname.getText().toString();
            cursor=db.deleteStudent(dname);

            name.setText("");
            stdname.setText("");
            semail.setText("");
            mobi.setText("");
            sub.setText("");
            delete.setVisibility(View.INVISIBLE);
            Toast.makeText(getActivity(),dname+" all information deleted",Toast.LENGTH_SHORT).show();

          }
        });
        namego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname=name.getText().toString();
                cursor=db.searchStudent(sname);
                if(cursor!=null && cursor.moveToFirst()==true){

                    stdname.setText(cursor.getString(2));
                    semail.setText(cursor.getString(4));
                    mobi.setText(cursor.getString(3));
                    sub.setText(cursor.getString(5));
                    delete.setVisibility(View.VISIBLE);
                }
                else{
                    name.setText("");
                    stdname.setText("");
                    semail.setText("");
                    mobi.setText("");
                    sub.setText("");
                    delete.setVisibility(View.INVISIBLE);
                    name.requestFocus();
                    Toast.makeText(getActivity(),"We do n't have any information about "+sname,Toast.LENGTH_SHORT).show();}
            }
        });

        return v;
    }

}
