package com.dam.christian.g25;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class PrefActivity extends AppCompatActivity {
    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
            // Control chars bound
            EditTextPreference controLimit = (EditTextPreference) findPreference("pref_editText");

            controLimit.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    try {
                        int number = Integer.parseInt((String) newValue);
                        if (number <= 0) {
                            Toast.makeText(getActivity(), "Error en Limite Introducido", Toast.LENGTH_LONG).show();
                            return false;
                        } else {
                            return true;
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(getActivity(), "Error de Formato en Limite", Toast.LENGTH_LONG).show();
                        return false;
                    }

                }
            });

        }
    }
        // Create Fragment
        @Override
        public void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new SettingsFragment())
                    .commit();
        }



}
