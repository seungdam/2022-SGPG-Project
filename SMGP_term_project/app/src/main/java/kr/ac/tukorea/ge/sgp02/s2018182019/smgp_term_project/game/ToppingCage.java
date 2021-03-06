package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.MainScene;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Metrics;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Sprite;

public class ToppingCage extends Sprite {
    float scrollSpeed = 10;
    float pastX;
    RectF boundingBox;
    Paint paint = new Paint();
    public ToppingCage(float y,int bitmapResId) {
        super((Metrics.width) * 1.1f, (Metrics.height * 0.1f) + (Metrics.width / 10 * y) , Metrics.width / 10, Metrics.width / 10, bitmapResId);
        pastX = (Metrics.width) *  1.1f;
        srcRect.set(0, 0 , bitmap.getWidth(), bitmap.getHeight());

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        boundingBox = dstRect;
    }


    public void update() {
        scrollAnimate();
    }

    public void draw(Canvas canvas) {
            canvas.drawBitmap(bitmap, srcRect, dstRect, null);
            canvas.drawRect(boundingBox,paint);
    }

    private void scrollAnimate() {
        if(MainScene.getInstance().scrollLeft || MainScene.getInstance().scrollRight) {
//            if(MainScene.getInstance().scrollLeft) {
//                x += scrollSpeed;
//                if( Math.abs(pastX - x) >= Metrics.width / 2 ) {
//                    scrollSpeed -= 1.0f;
//                }
//                else {
//                    scrollSpeed += 1.0f;
//                }
//            }
//            else if (MainScene.getInstance().scrollRight) {
//                x -= scrollSpeed;
//                if( Math.abs(x - pastX) >= Metrics.width / 2 ) {
//                    scrollSpeed -= 1.0f;
//                }
//                else {
//                    scrollSpeed += 1.0f;
//                }
//            }
//
//            // ?????? ??? ?????? ??????????????????..
//            if (Math.abs(pastX - x) >= Metrics.width) {
//                if(MainScene.getInstance().scrollRight) {
//
//                    MainScene.getInstance().scrollRight = false;
//                }
//                else if(MainScene.getInstance().scrollLeft){
//
//                    MainScene.getInstance().scrollLeft = false;
//                }
//                scrollSpeed = 10.0f;
//            }
//            else {
//                setDstRect(x, y, Metrics.width / 10, Metrics.width / 10);
//                boundingBox = dstRect;
//                }


        }
        else {
            pastX = x;
        }
    }

}