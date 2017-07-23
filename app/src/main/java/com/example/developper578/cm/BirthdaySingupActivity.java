package com.example.developper578.cm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;

import com.example.developper578.cm.utils.LayoutInitializer;


public class BirthdaySingupActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_signup);
    }

    public void onClickValidate(View view) {
        Intent i = new Intent(this, UsernameSignupActivity.class);
        startActivity(i);
    }


}
