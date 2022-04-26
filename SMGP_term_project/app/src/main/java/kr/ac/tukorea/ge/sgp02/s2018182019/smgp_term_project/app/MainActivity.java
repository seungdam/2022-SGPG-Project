package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnStart(View view) {
//        Log.d("tag", "onBtnStart()");
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}