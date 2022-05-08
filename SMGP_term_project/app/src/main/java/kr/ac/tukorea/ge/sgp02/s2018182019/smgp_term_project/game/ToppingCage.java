package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game;

import android.graphics.Canvas;
import android.graphics.Rect;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.MainGame;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Metrics;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Sprite;

public class ToppingCage extends Sprite {
    float x, y;
    float scrollSpeed = 10;
    float pastX;

    public ToppingCage(float y,int bitmapResId) {
        super((Metrics.width) * 1.1f, (Metrics.height * 0.1f) + (Metrics.width / 10 * y) , Metrics.width / 10, Metrics.width / 10, bitmapResId);
        pastX = (Metrics.width) *  1.1f;
        srcRect.set(0, 0 , bitmap.getWidth(), bitmap.getHeight());
    }


    public void update() {
        if(MainGame.getInstance().curScene == 1) {

        }
    }

    public void draw(Canvas canvas) {
        if(MainGame.getInstance().curScene == 1)
            canvas.drawBitmap(bitmap, srcRect, dstRect, null);
    }

    private void scrollAnimate() {
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

            // 만약 한 씬이 넘어갔더라면..
            if (Math.abs(pastX - x) >= Metrics.width) {
                if(MainGame.getInstance().scrollRight) {

                    MainGame.getInstance().scrollRight = false;
                }
                else if(MainGame.getInstance().scrollLeft){

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

}