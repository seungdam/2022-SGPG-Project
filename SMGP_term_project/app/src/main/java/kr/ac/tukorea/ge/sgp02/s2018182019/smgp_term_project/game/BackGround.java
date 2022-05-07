package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.MainGame;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Metrics;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Sprite;

public class BackGround extends Sprite {

    private  static final String TAG = MainGame.class.getSimpleName();
    private Rect srcRect = new Rect();
    private float scrollSpeed ;
    private int height;
    private float pastX;
    private static int curScene;
    public BackGround(int bitmapResId,int scene) {
        super(Metrics.width/ 2  +  (Metrics.width * scene), Metrics.height/ 2, Metrics.width, Metrics.height, bitmapResId);

        scrollSpeed = 10.0f;
        height = bitmap.getHeight() * Metrics.width / bitmap.getWidth();
        srcRect.set(0, 0 , bitmap.getWidth(), bitmap.getHeight());
        pastX = x;
        curScene = MainGame.getInstance().curScene;
    }

    @Override
    public void update() {


        if(MainGame.getInstance().scrollLeft || MainGame.getInstance().scrollRight) {
            if(MainGame.getInstance().scrollLeft) {
                x += scrollSpeed;
                if( Math.abs(pastX - x) >= Metrics.width / 2 ) {
                    scrollSpeed -= 1.0f;
                }
                else {
                    scrollSpeed += 1.0f;
                }
            }
            else if (MainGame.getInstance().scrollRight) {
                x -= scrollSpeed;
                if( Math.abs(x - pastX) >= Metrics.width / 2 ) {
                    scrollSpeed -= 1.0f;
                }
                else {
                    scrollSpeed += 1.0f;
                }
            }
            Log.d(TAG,"" +Metrics.width);
            // 만약 한 씬이 넘어갔더라면..
            if (Math.abs(pastX - x) >= Metrics.width) {
                if(MainGame.getInstance().scrollRight) {

                    MainGame.getInstance().curScene += 1;
                    MainGame.getInstance().scrollRight = false;
                }
                else if(MainGame.getInstance().scrollLeft){

                    MainGame.getInstance().curScene -=1;
                    MainGame.getInstance().scrollLeft = false;
                }
                scrollSpeed = 10.0f;

            }
            else
                setDstRect(x, y, Metrics.width, Metrics.height);
        }
        else {
            pastX = x;
        }

    }

    @Override
    public void draw(Canvas canvas) {
       // Log.d(TAG,"" + x + ", " +y);

        canvas.drawBitmap(bitmap, srcRect, dstRect, null);
    }
}
