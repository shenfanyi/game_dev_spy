package xyz.everstar.app.whoisspy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

public class CreateGameActivity extends AppCompatActivity {

    private final int MIN_NUMS_PLAYER = 4;
    private final int MAX_NUMS_PLAYER = 11;

    @BindView(R.id.CG_text_numsPlayer)AppCompatTextView textNumsPlayer;
    @BindView(R.id.CG_seekBar_numsPlayer)SeekBar seekBarNumsPlayer;
    @BindView(R.id.judge_select_spinner) AppCompatSpinner judgeSelectSpinner;
    @BindView(R.id.CG_btn_startGame) MaterialButton btn_startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_game);
        ButterKnife.bind(this);

        initLayout();
    }

    private void initLayout() {
        // Title Bar settings
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getResources().getString(R.string.title_create_game));
            // Display top-left Back Button
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

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
