package com.waytojava.countrydescriptionapp;

/**
 * Created by Manish Kumar on 11/16/2018
 */
public interface OnCountrySelectedListener {
    public static final String KEY_SELECTED_COUNTRY = "SELECTED_COUNTRY";

    void onCountrySelected(String countryName);
}
