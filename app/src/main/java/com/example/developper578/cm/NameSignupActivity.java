package com.example.developper578.cm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;

import com.example.developper578.cm.utils.LayoutInitializer;

public class NameSignupActivity extends AppCompatActivity {

    public static String TAG = "NameSignupActivity";


    private static final String[] FIELDS_IDS = {"fieldFirstname", "fieldLastname"};
    private static final String[] FIELDS_NAMES = {"FIRST NAME", "LAST NAME"};
    private static final int[] INPUT_TYPES = {InputType.TYPE_CLASS_TEXT, InputType.TYPE_CLASS_TEXT};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_signup);

        try {
            LayoutInitializer.InitializeSignupFields(FIELDS_IDS, FIELDS_NAMES, INPUT_TYPES, this);
        } catch (Exception e) {

        }
    }

    public void onSignupClick(View view) {
        Intent i = new Intent(this, BirthdaySingupActivity.class);
        startActivity(i);
    }
}
