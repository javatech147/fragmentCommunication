package com.waytojava.countrydescriptionapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Manish Kumar on 11/16/2018
 */
public class MainActivity extends AppCompatActivity implements OnCountrySelectedListener {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        addCountryListFragment();

    }

    private void addCountryListFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        CountriesFragment countriesFragment = new CountriesFragment();
        countriesFragment.setOnCountrySelectedListener(this);

        fragmentTransaction.add(R.id.fragmentContainer, countriesFragment);
        fragmentTransaction.commit();
    }

    private void addCountryDescriptionFragment(String countryName) {
        fragmentTransaction = fragmentManager.beginTransaction();
        CountryDescriptionFragment countryDescriptionFragment = new CountryDescriptionFragment();

        Bundle bundle = new Bundle();
        bundle.putString(OnCountrySelectedListener.KEY_SELECTED_COUNTRY, countryName);
        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainer, countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onCountrySelected(String countryName) {
        addCountryDescriptionFragment(countryName);
    }
}
