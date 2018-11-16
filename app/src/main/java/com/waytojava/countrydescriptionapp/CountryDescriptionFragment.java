package com.waytojava.countrydescriptionapp;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountryDescriptionFragment extends Fragment {

    private TextView tvCountryDescriptionFragment;
    private String countryDescription;
    private String countryName;
    private Context context;
    private MainActivity mainActivity;

    public CountryDescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_country_description, container, false);
        initUi(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        countryName = bundle.getString(OnCountrySelectedListener.KEY_SELECTED_COUNTRY);
        countryDescription = getCountryDescription(countryName);
    }

    private String getCountryDescription(String countryName) {
        if (countryName.equals("India")) {
            return getString(R.string.india);
        } else if (countryName.equals("USA")) {
            return getString(R.string.usa);
        } else if (countryName.equals("England")) {
            return getString(R.string.england);
        } else if (countryName.equals("Australia")) {
            return getString(R.string.australia);
        } else if (countryName.equals("Bangladesh")) {
            return getString(R.string.bangladesh);
        } else if (countryName.equals("Newzeland")) {
            return getString(R.string.newzeland);
        } else if (countryName.equals("West Indies")) {
            return getString(R.string.westindies);
        } else if (countryName.equals("South Africa")) {
            return getString(R.string.south_africa);
        } else if (countryName.equals("China")) {
            return getString(R.string.china);
        } else if (countryName.equals("Russia")) {
            return getString(R.string.russia);
        } else if (countryName.equals("Srilanka")) {
            return getString(R.string.srilanka);
        }
        return null;
    }

    @Override
    public void onResume() {
        super.onResume();
        mainActivity.getSupportActionBar().setTitle(countryName);
        tvCountryDescriptionFragment.setText(countryDescription);
    }

    private void initUi(View view) {
        tvCountryDescriptionFragment = view.findViewById(R.id.tvCountryDescription);
        context = getContext();
        mainActivity = (MainActivity) context;
    }
}