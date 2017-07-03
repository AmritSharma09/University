package com.example.golu.registrationunive;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
WelcomeFragment welcomeFragment;
    LoginFragment loginFragment;
    RegistrationFragment registrationFragment;
    HomeFragment homeFragment;
    StudentFragment studentFragment;
    ListFragment list;
    SearchFragment searchFragment;
    DeleteFragment deleteFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mgr =getSupportFragmentManager();
        FragmentTransaction trans = mgr.beginTransaction();
        welcomeFragment = new WelcomeFragment();
        trans.add(R.id.container, welcomeFragment);
        trans.commit();
    }

    public void callLogin() {
        FragmentManager mgr =getSupportFragmentManager();
        FragmentTransaction trans = mgr.beginTransaction();
        loginFragment = new LoginFragment();
        trans.replace(R.id.container, loginFragment);
        trans.addToBackStack(null);
        trans.commit();


    }

    public void callRegistration() {
        FragmentManager mgr =getSupportFragmentManager();
        FragmentTransaction trans = mgr.beginTransaction();
        registrationFragment = new RegistrationFragment();
        trans.replace(R.id.container, registrationFragment);
        trans.addToBackStack(null);
        trans.commit();

    }


    public void callHomeFragment() {
        FragmentManager mgr =getSupportFragmentManager();
        FragmentTransaction trans = mgr.beginTransaction();
        homeFragment = new HomeFragment();
        trans.replace(R.id.container, homeFragment);
        trans.addToBackStack(null);
        trans.commit();
    }

    public void callStudentFragment() {
        FragmentManager mgr =getSupportFragmentManager();
        FragmentTransaction trans = mgr.beginTransaction();
        studentFragment = new StudentFragment();
        trans.replace(R.id.container, studentFragment);
        trans.addToBackStack(null);
        trans.commit();
    }

    public void callView() {
        FragmentManager mgr =getSupportFragmentManager();
        FragmentTransaction trans = mgr.beginTransaction();
        list = new ListFragment();
        trans.replace(R.id.container, list);
        trans.addToBackStack(null);
        trans.commit();
    }


    public void callSearch() {
        FragmentManager mgr =getSupportFragmentManager();
        FragmentTransaction trans = mgr.beginTransaction();
        searchFragment = new SearchFragment();
        trans.replace(R.id.container, searchFragment);
        trans.addToBackStack(null);
        trans.commit();
    }

    public void callDeleteFragment() {
        FragmentManager mgr =getSupportFragmentManager();
        FragmentTransaction trans = mgr.beginTransaction();
        deleteFragment = new DeleteFragment();
        trans.replace(R.id.container, deleteFragment);
        trans.addToBackStack(null);
        trans.commit();
    }

/*
    public void passDate(String date) {
    }
*/
}
