package com.example.golu.registrationunive;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialog3 extends DialogFragment {
StudentFragment studentFragment;

    public MyDialog3(StudentFragment studentFragment) {
      this.studentFragment=studentFragment;
    }

    public MyDialog3(){

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d=null;
        Calendar calendar=Calendar.getInstance();
        int year =calendar.get(Calendar.YEAR);//give Current Year when user open Application
        int month =calendar.get(Calendar.MONTH);//gives Current Month
        int date =calendar.get(Calendar.DATE);//give current date

        DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfDay, int day) {

                String date=""+day+"-"+(monthOfDay+1)+"-"+year;

                //MainActivity m= (MainActivity) getActivity();

                studentFragment.setDate(date);

                //Toast.makeText(getActivity(),"Today is "+day+"-"+(monthOfDay+1)+"-"+year,Toast.LENGTH_SHORT).show();

            }
        }, year, month, date);

        d=datePickerDialog;



        return d;
    }

}
