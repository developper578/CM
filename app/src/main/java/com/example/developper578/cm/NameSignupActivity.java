package com.example.developper578.cm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NameSignupActivity extends AppCompatActivity {

    public static String TAG = "NameSignupActivity";
    private static final String[] FIELDS_IDS = {"fieldFirstname", "fieldLastname"};
    private static final String[] FIELDS_NAMES = {"FIRST NAME", "LAST NAME"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_signup);

        try {
            initializeField(FIELDS_IDS, FIELDS_NAMES);
        } catch (Exception e) {

        }
    }

    private void initializeField(String fieldIds[], String fieldNames[]) throws Exception {
        if(fieldIds.length != fieldNames.length) {
            throw new Exception();
        }

        for(int i = 0; i < fieldNames.length; i++) {

            int resId = getResources().getIdentifier(fieldIds[i], "id", getPackageName());
            ViewGroup vg = (ViewGroup)findViewById(resId);
            TextView tv = (TextView)vg.getChildAt(0);

            tv.setText(fieldNames[i]);
        }
    }
}
