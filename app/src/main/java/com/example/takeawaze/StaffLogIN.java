package com.example.takeawaze;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class StaffLogIN extends AppCompatActivity {
    MainActivity m;
    ArrayList<Staff> staffs = m.staffs;
    public static Staff loggedStaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }

    public void staffLogIn(View v) {
        boolean LoginToken = false;
        EditText n = (EditText) findViewById(R.id.staffNum);
        EditText p = (EditText) findViewById(R.id.staffName);
        String custLoginName = n.getText().toString();
        String custLoginPhone = p.getText().toString();
        String STAFF_NAME = null;
        String STAFF_PASSWORD = null;
        for (int i = 0; i < staffs.size(); i++) {
            STAFF_NAME = staffs.get(i).STAFF_NAME;
            STAFF_PASSWORD = staffs.get(i).STAFF_PASSWORD;
            if (custLoginName.equals(STAFF_NAME) && custLoginPhone.equals(STAFF_PASSWORD)) {
                LoginToken = true;
                loggedStaff = staffs.get(i);
                break;
            }
        }
        if (LoginToken) {
            Intent intent = new Intent(this, StaffDashboard.class);
            startActivity(intent);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Invalid Login Details :(";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
    public void signUp(View v)
    {
        Intent intent = new Intent(this, StaffSignUp.class);
        startActivity(intent);
    }

}