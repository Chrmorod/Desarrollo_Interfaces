package com.dam.christian.g25;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Create main activity
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    // Create the options menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // Ver datos de las preferencias.
            case R.id.verdatos_menu:
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        Intent intent = new Intent(MainActivity.this, DataActivity.class);
                        startActivity(intent);
                        return true;
                    }
                });
                return true;
            // Ver panel de ajustes
            case R.id.ajustes_menu:
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        Intent intent = new Intent(MainActivity.this, PrefActivity.class);
                        startActivity(intent);
                        return true;
                    }
                });
                return true;
            // Ver opción de ayuda
            case R.id.ayuda_menu:
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        Toast.makeText(MainActivity.this, "Christian Molina Rodríguez", Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                return true;
        }
        return true;
    }

}
