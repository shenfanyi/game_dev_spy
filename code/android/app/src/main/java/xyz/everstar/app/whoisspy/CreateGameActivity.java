package xyz.everstar.app.whoisspy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class CreateGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_game);

        ActionBar actionBar = getActionBar();
        Log.e("bar", "begin");
        if (actionBar != null) {
            Log.e("bar", "here");
            actionBar.setTitle(getResources().getString(R.string.title_settings));
            // Display top-left Back Button
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
