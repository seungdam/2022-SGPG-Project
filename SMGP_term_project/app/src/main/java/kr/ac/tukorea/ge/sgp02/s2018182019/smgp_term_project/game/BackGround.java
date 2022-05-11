package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.MainScene;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Metrics;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Sprite;

public class BackGround extends Sprite {

    private  static final String TAG = MainScene.class.getSimpleName();
    private Rect srcRect = new Rect();
    private float scrollSpeed;
    private float scrollOffset= 1.0f;
    private int height;
    private float pastX;
    private static int curScene;
    public BackGround(int bitmapResId,int scene) {
        super(Metrics.width/ 2  +  (Metrics.width * scene), Metrics.height/ 2, Metrics.width, Metrics.height, bitmapResId);

        scrollSpeed = 10.0f;
        height = bitmap.getHeight() * Metrics.width / bitmap.getWidth();
        srcRect.set(0, 0 , bitmap.getWidth(), bitmap.getHeight());
        pastX = x;
        curScene = MainScene.getInstance().curScene;
    }

    @Override
    public void update(float elapsedNanos) {
        scrollAnimate();
    }

    private void scrollAnimate() {
        if(MainScene.getInstance().scrollLeft || MainScene.getInstance().scrollRight) {
//            if(MainScene.getInstance().scrollLeft) {
//                x += scrollSpeed;
//                if( Math.abs(pastX - x) >= Metrics.width / 2 ) {
//                    scrollSpeed -= scrollOffset;
//                }
//                else {
//                    scrollSpeed += scrollOffset;
//                }
//            }
//            else if (MainScene.getInstance().scrollRight) {
//                x -= scrollSpeed;
//                if( Math.abs(x - pastX) >= Metrics.width / 2 ) {
//                    scrollSpeed -= scrollOffset;
//                }
//                else {
//                    scrollSpeed += scrollOffset;
//                }
//            }
//
//            // 만약 한 씬이 넘어갔더라면..
//            if (Math.abs(pastX - x) >= Metrics.width) {
//                if(MainScene.getInstance().scrollRight) {
//                    MainScene.getInstance().scrollRight = false;
//                    MainScene.getInstance().curScene +=1;
//                }
//                else if(MainScene.getInstance().scrollLeft){
//                    MainScene.getInstance().scrollLeft = false;
//                    MainScene.getInstance().curScene -=1;
//                }
//                scrollSpeed = 10.0f;
//            }
//            else
//                setDstRect(x, y, Metrics.width, Metrics.height);
            ValueAnimator scrollAnimate = ValueAnimator.ofFloat(0.0f,Metrics.width);
            scrollAnimate.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float deltaX = (float) animation.getAnimatedValue();
                    setDstRect(x, y, Metrics.width, Metrics.height);
                    x += deltaX;
                }
            });
            scrollAnimate.setDuration(1000);
        }
        else {
            pastX = x;
            setDstRect(pastX, y, Metrics.width, Metrics.height);
        }
    }

    @Override
    public void draw(Canvas canvas) {
       // Log.d(TAG,"" + x + ", " +y);

        canvas.drawBitmap(bitmap, srcRect, dstRect, null);
    }
}
