package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.app.MainActivity;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.MainGame;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Metrics;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Sprite;

public class BackGround extends Sprite {

    private  static final String TAG = MainGame.class.getSimpleName();
    private Rect srcRect = new Rect();
    private float fTimeElapsed;
    private float scrollSpeed ;
    private int height;
    private float curX,curY;
    private int curScene;
    public BackGround(int bitmapResId,int scene) {
        super(Metrics.width/2  + (Metrics.width * scene), Metrics.height/2, Metrics.width, Metrics.height, bitmapResId);

        scrollSpeed = Metrics.size(R.dimen.slide_speed);
        height = bitmap.getHeight() * Metrics.width / bitmap.getWidth();
        srcRect.set(0, 0 , bitmap.getWidth(), bitmap.getHeight());
        curX = x;
        curY = y;
        curScene = MainGame.getInstance().curScene;
    }

    @Override
    public void update() {

            if(MainGame.getInstance().scrollLeft) {
                x -= scrollSpeed;
                if( Math.abs(curX - x) > Metrics.width / 2 ) {
                    scrollSpeed -= 1;
                }
                else {
                    scrollSpeed += 1;
                }
            }
            else if (MainGame.getInstance().scrollRight) {
                x += scrollSpeed;
                if( Math.abs(curX - x) > Metrics.width / 2 ) {
                    scrollSpeed -= 1;
                }
                else {
                    scrollSpeed += 1;
                }
            }

            if (Math.abs(curX - x) > Metrics.width) {
                MainGame.getInstance().scrollRight = false;
                MainGame.getInstance().scrollLeft = false;
            }
            else {
                setDstRect(x, y, Metrics.width / 2, Metrics.height / 2);
            }
    }



    @Override
    public void draw(Canvas canvas) {
        Log.d(TAG,"" + bitmap.getWidth());

        canvas.drawBitmap(bitmap, srcRect, dstRect, null);
    }
}
