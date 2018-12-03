package hn.techcom.com.hnapp;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        NestedScrollView nestedScrollView = findViewById(R.id.nested_scroll_view);
        nestedScrollView.setScrollbarFadingEnabled(false);

        AppCompatSpinner genderSpinner = findViewById(R.id.spinner_gender);
        AppCompatSpinner countrySpinner = findViewById(R.id.spinner_country);

        ArrayAdapter<CharSequence> genderSpinnerAdapter = ArrayAdapter.createFromResource(this,R.array.genders_array,android.R.layout.simple_spinner_item);
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderSpinnerAdapter);

        ArrayAdapter<CharSequence> countrySpinnerAdapter = ArrayAdapter.createFromResource(this,R.array.countries_array,android.R.layout.simple_spinner_item);
        countrySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countrySpinnerAdapter);

        CardView registerButton = findViewById(R.id.second_card_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,Home.class));
            }
        });
    }
}
