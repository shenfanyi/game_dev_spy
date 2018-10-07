package xyz.everstar.app.whoisspy;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable @android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Recover the top Action bar
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getResources().getString(R.string.title_settings));
            // Display top-left Back Button
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_headers, target);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return SettingsUserFragment.class.getName().equals(fragmentName)
                || SettingsSystemFragment.class.getName().equals(fragmentName);
    }

    /*
     * User Settings
     */
    public static class SettingsUserFragment extends PreferenceFragment {
        @Override
        public void onCreate(@Nullable @android.support.annotation.Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_user);
        }
    }

    /*
     * System Settings
     */
    public static class SettingsSystemFragment extends PreferenceFragment {
        @Override
        public void onCreate(@Nullable @android.support.annotation.Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_system);

            // language setting take effect
            Preference langPref = findPreference(getString(R.string.pref_key_language));
            langPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Resources res = getActivity().getBaseContext().getResources();
                    Configuration config = res.getConfiguration();
                    switch (newValue.toString()) {
                        case "0": config.setLocale(Locale.ENGLISH); break;
                        case "1": config.setLocale(Locale.CHINESE); break;
                        default: break;
                    }

                    res.updateConfiguration(config, res.getDisplayMetrics());
                    return true;
                }
            });
        }
    }
}
