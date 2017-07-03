package com.example.golu.registrationunive;


import android.content.SharedPreferences;
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
public class RegistrationFragment extends Fragment {

EditText eno,ename,eemail,epw,ecpw,ephint;
    Button res,log;
    MainActivity m;
    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_registration, container, false);
        eno=(EditText)v.findViewById(R.id.eno);
        ename=(EditText)v.findViewById(R.id.ename);
        eemail=(EditText)v.findViewById(R.id.email);
        epw=(EditText)v.findViewById(R.id.password);
        ecpw=(EditText)v.findViewById(R.id.cnfrmpswrd);
        ephint=(EditText)v.findViewById(R.id.pwhint);

        res=(Button)v.findViewById(R.id.register);
        log=(Button)v.findViewById(R.id.login);

        m= (MainActivity) getActivity();

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String empNo=eno.getText().toString();
                String name=ename.getText().toString();
                String email=eemail.getText().toString();
                String pw=epw.getText().toString();
                String cpw=ecpw.getText().toString();
                String phint=ephint.getText().toString();

                if(empNo.equals("")||name.equals("")||email.equals("")||pw.equals("")||cpw.equals("")||phint.equals("")){
                    Toast.makeText(getActivity(), "Do not leave Anything Empty", Toast.LENGTH_SHORT).show();
                }
                if(pw.equals(cpw)==false){
                    Toast.makeText(getActivity(),"Confirm Password is not match",Toast.LENGTH_SHORT).show();
                }
                SharedPreferences sp=getActivity().getSharedPreferences("credential", 0);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("enumber",empNo);
                editor.putString("ename",name);
                editor.putString("email",email);
                editor.putString("epassword",pw);
                editor.putString("passwordhint",phint);
                editor.commit();
                m.callLogin();
            }
        });

        return v;
    }

}
