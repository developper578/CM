package com.example.developper578.cm.utils;


import android.app.Activity;

import android.text.InputType;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * - Initialize layouts
 *
 * Layout structures:
 *  - SignupField
 */
public class LayoutInitializer {

    public static final String TAG = "LayoutInitializer";

    public static void InitializeSignupFields(String fieldIds[], String fieldNames[], int inputTypes[], Activity act) throws Exception {
        if(fieldIds.length != fieldNames.length) {
            throw new Exception();
        }

        for(int i = 0; i < fieldNames.length; i++) {

            int resId = act.getResources().getIdentifier(fieldIds[i], "id", act.getPackageName());

            ViewGroup vg = (ViewGroup) act.findViewById(resId);
            TextView tv = (TextView)vg.getChildAt(0);
            tv.setText(fieldNames[i]);

            EditText edt = (EditText)vg.getChildAt(1);
            edt.setInputType(inputTypes[i]);
        }
    }
}
