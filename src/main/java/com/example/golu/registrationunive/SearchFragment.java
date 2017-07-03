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
public class SearchFragment extends Fragment {

    EditText name,cell;
    TextView stdname,semail,mobi,sub;
    Button namego,cellgo;
    MainActivity m;
    MyDataBase db;
    Cursor cursor;

/*public SearchFragment(MyDataBase myDataBase){
    this.db=new MyDataBase(getActivity());
}*/
    public SearchFragment() {
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
        View v= inflater.inflate(R.layout.fragment_search, container, false);
        stdname=(TextView)v.findViewById(R.id.sname);
        semail=(TextView)v.findViewById(R.id.email);
        mobi=(TextView)v.findViewById(R.id.smobile);
        sub=(TextView)v.findViewById(R.id.subject);

        name=(EditText)v.findViewById(R.id.name);
        cell=(EditText)v.findViewById(R.id.cell);
        namego=(Button) v.findViewById(R.id.namego);
        cellgo=(Button) v.findViewById(R.id.cellgo);


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
        namego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cell.setText(" ");
                String sname=name.getText().toString();
                 cursor=db.searchStudent(sname);
                if(cursor!=null && cursor.moveToFirst()==true){

                        stdname.setText(cursor.getString(2));
                        semail.setText(cursor.getString(4));
                        mobi.setText(cursor.getString(3));
                        sub.setText(cursor.getString(5));


                }
                else{
                Toast.makeText(getActivity(),"We do n't have any information about "+sname,Toast.LENGTH_SHORT).show();
                    name.setText("");
                    stdname.setText("");
                    semail.setText("");
                    mobi.setText("");
                    sub.setText("");
                    name.requestFocus();
                }


            }
        });
        return v;
    }

    public void details(String sname, String mobile, String email, String subject) {

        stdname.setText("Name   :" +sname);
         semail.setText("Email  :" +email);
           mobi.setText("Mobile :" +mobile);
            sub.setText("Name :" +subject);

    }

    public void notFound() {
        stdname.setText("DATA NOT FOUND");
    }
}
