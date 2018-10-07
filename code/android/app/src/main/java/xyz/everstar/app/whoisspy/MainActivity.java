package xyz.everstar.app.whoisspy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * App Main Entry
 * Everything Start From Here !
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Main_toolBar) Toolbar toolbar;
    @BindView(R.id.Main_CollapsingToolBarLayout) CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.Main_Btn_create) MaterialButton btn_create;
    @BindView(R.id.Main_Btn_join) MaterialButton btn_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Don't touch
        setUpLanguage();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        // 实现沉浸式状态栏
        Window w = getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(R.color.primary_dark));

        // Setup Title Text
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.app_name));
        collapsingToolbarLayout.setExpandedTitleColor(
                getResources().getColor(R.color.layout_expandedTitle_textColor)
        );
        collapsingToolbarLayout.setCollapsedTitleTextColor(
                getResources().getColor(R.color.layout_collapsedTitle_textColor)
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Top Right Menu Button
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Top Right Menu Item Behavior when clicked
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Set up language at the beginning
     */
    public void setUpLanguage() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String language = preferences.getString(getString(R.string.pref_key_language), "0");
        Resources res = getBaseContext().getResources();
        Configuration config = res.getConfiguration();
        switch (language) {
            case "0": config.setLocale(Locale.ENGLISH); break;
            case "1": config.setLocale(Locale.CHINESE); break;
            default: break;
        }
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

    /**
     * Create A Game Room, here we will create a new activity
     */
    public void createRoom(View target) {
        startActivity(new Intent(this, CreateGameActivity.class));
    }

    /**
     * Join A Game Room, here we will create a new activity
     */
    public void joinRoom(View target) {
        Snackbar.make(target, "此功能正在施工中", Snackbar.LENGTH_SHORT).show();
        // Now do Nothing
    }
}
