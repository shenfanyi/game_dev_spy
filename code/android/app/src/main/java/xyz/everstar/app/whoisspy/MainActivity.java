package xyz.everstar.app.whoisspy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.volley.Response;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * App Main Entry
 * Everything Start From Here !
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Main_toolBar) Toolbar toolbar;
    @BindView(R.id.Main_CollapsingToolBarLayout) CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.Main_Btn_create) QMUIRoundButton btnCreate;
    @BindView(R.id.Main_Btn_join) QMUIRoundButton btnJoin;

    @BindView(R.id.Main_Text_Username) TextView textUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Don't touch
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
        int titleColor = getResources().getColor(R.color.layout_collapsedTitle_textColor);
        collapsingToolbarLayout.setExpandedTitleColor(titleColor);
        collapsingToolbarLayout.setCollapsedTitleTextColor(titleColor);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Network test
        Api.initRequestQueue(this);
        Api.fetchUserId(new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    int code = response.getInt("code");
                    JSONObject data = response.getJSONObject("data");
                    if (code != 0 || data == null) {
                        return;
                    }
                    String uid = data.getString("uid");
                    textUsername.setText(uid);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Api.verifyUserId(new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String msg = textUsername.getText() + " : " + response;
                        textUsername.setText(msg);
                    }
                });
            }
        });
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
