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
    private float imageHeight , imageWidth;
    private  static final String TAG = MainGame.class.getSimpleName();
    private Rect srcRect = new Rect();
    private int height;
    public BackGround(int bitmapResId,int speed) {
        super(Metrics.width/2, Metrics.height/2, Metrics.width, Metrics.height, bitmapResId);
        scrollSpeed = speed;

        height = bitmap.getHeight() * Metrics.width / bitmap.getWidth();
    }


    @Override
    public void update() {
        Log.d(TAG, "스피드값 : " + scrollSpeed  + "마우스 y 값 :"  + MainGame.getInstance().mouseX + " " + Metrics.height );
       if (MainGame.getInstance().mouseX > Metrics.height  * 0.9) {
            scrollSpeed += 1;
       }
    }

    @Override
    public void draw(Canvas canvas) {
        srcRect.set(scrollSpeed, 0 , bitmap.getWidth() / 4 + scrollSpeed, bitmap.getHeight());
        canvas.drawBitmap(bitmap, srcRect, dstRect, null);
    }
}
