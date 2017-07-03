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
public class LoginFragment extends Fragment {

EditText uname,pw;
    Button login;
    MainActivity m;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_login, container, false);
        uname=(EditText)v.findViewById(R.id.uname);
        pw=(EditText)v.findViewById(R.id.pw);
        login=(Button)v.findViewById(R.id.login);
        m= (MainActivity) getActivity();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=uname.getText().toString();
                String password=pw.getText().toString();

                SharedPreferences sp=getActivity().getSharedPreferences("credential",0);
                String original_name=sp.getString("ename",null);
                String origibnal_pw=sp.getString("epassword",null);

                if(name.equals(original_name) && password.equals(origibnal_pw)){
                    Toast.makeText(getActivity(),"Welcome Sir!",Toast.LENGTH_SHORT).show();
                     m.callHomeFragment();

                }
                else{
                    Toast.makeText(getActivity(),"User unauthorized ,Retry",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }

}
