package xyz.everstar.app.whoisspy;

import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.norbsoft.typefacehelper.ActionBarHelper;
import com.norbsoft.typefacehelper.TypefaceHelper;

public class CreateGameActivity extends AppCompatActivity {

    private final int MIN_NUMS_PLAYER = 4;
    private final int MAX_NUMS_PLAYER = 11;

    @BindView(R.id.CG_text_numsPlayer)AppCompatTextView textNumsPlayer;
    @BindView(R.id.CG_seekBar_numsPlayer)AppCompatSeekBar seekBarNumsPlayer;
    @BindView(R.id.judge_select_spinner) Spinner judgeSelectSpinner;
    @BindView(R.id.CG_btn_startGame) Button btn_startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_game);
        ButterKnife.bind(this);

        initLayout();
        TypefaceHelper.typeface(this);
    }

    private void initLayout() {
        // Title Bar settings
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
//            actionBar.setTitle(getResources().getString(R.string.title_create_game));
            ActionBarHelper.setTitle(actionBar, TypefaceHelper.typeface(this, R.string.title_create_game));
            // Display top-left Back Button
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

//        textNumsPlayer.setText(String.valueOf(MIN_NUMS_PLAYER + progress));
        // Bind seekBar & textView
        seekBarNumsPlayer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textNumsPlayer.setText(String.valueOf(MIN_NUMS_PLAYER + progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        seekBarNumsPlayer.setMax(MAX_NUMS_PLAYER); // Max Value
        textNumsPlayer.setText(String.valueOf(MIN_NUMS_PLAYER)); // Default value

        // Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.judge_exist_selection, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        judgeSelectSpinner.setAdapter(adapter);
    }

    /**
     * Finished Settings & start a game
     */
    public void startGame(View target) {
        Snackbar.make(btn_startGame, "此功能正在施工中", Snackbar.LENGTH_SHORT).show();
    }
}
