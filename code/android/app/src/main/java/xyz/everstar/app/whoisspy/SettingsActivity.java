package xyz.everstar.app.whoisspy;

import android.app.ActionBar;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import java.util.List;

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
        }
    }
}
