package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Log;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.MainGame;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Metrics;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Sprite;

public class HorzBackGround extends Sprite {
    public HorzBackGround(int bitmapResId) {
        super(Metrics.width / 2 , Metrics.height / 2,Metrics.width,Metrics.height,bitmapResId);
    }
    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {

    }
}
