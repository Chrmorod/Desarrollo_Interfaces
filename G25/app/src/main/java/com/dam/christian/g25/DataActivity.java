package com.dam.christian.g25;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    PrefActivity prefAct =new PrefActivity();
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        // Define TextView
        TextView delmsg = findViewById(R.id.textMsg);
        TextView limit = findViewById(R.id.textChar);
        TextView usedata = findViewById(R.id.textUseData);
        TextView operator = findViewById(R.id.textOperator);

        // Recover the Shared Preferences Object
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        // Register variables
        boolean deletemsg = sharedPref.getBoolean("pref_sync",true);
        String limite = sharedPref.getString("pref_editText","");
        boolean usodatos = sharedPref.getBoolean("pref_switch",true);
        String operador = sharedPref.getString("pref_operador","");

        // Show info
        delmsg.setText(""+deletemsg);
        limit.setText(limite);
        usedata.setText(""+usodatos);
        operator.setText(operador);


    }
}
