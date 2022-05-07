package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.app.MainActivity;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.MainGame;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Metrics;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Sprite;

public class BackGround extends Sprite {
    private static int scrollSpeed;
    private  static final String TAG = MainGame.class.getSimpleName();
    private Rect srcRect = new Rect();
    private int height;
    public BackGround(int bitmapResId,int speed) {
        super(Metrics.width/2, Metrics.height/2, Metrics.width, Metrics.height, bitmapResId);
        scrollSpeed = speed;

        height = bitmap.getHeight() * Metrics.width / bitmap.getWidth();
        srcRect.set(0, 0 , bitmap.getWidth(), bitmap.getHeight());

    }

    @Override
    public void update() {



    }

    @Override
    public void draw(Canvas canvas) {
        Log.d(TAG,"" + bitmap.getWidth());

        canvas.drawBitmap(bitmap, srcRect, dstRect, null);
    }
}
