package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.GameView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(new GameView(this,null));
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
}