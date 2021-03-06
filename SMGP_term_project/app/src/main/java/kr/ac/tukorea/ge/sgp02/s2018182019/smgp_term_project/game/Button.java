package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.MotionEvent;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.BitmapPool;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Metrics;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Sprite;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Touchable;

public class Button extends Sprite implements Touchable {
    private static final String TAG = Button.class.getSimpleName();
    protected final Callback callback;
    private final Bitmap normalBitmap;
    private Bitmap pressedBitmap;
    private boolean pressed;

    public enum Action {
        pressed, released,
    }
    public interface Callback {
        public boolean onTouch(Action action);
    }
    public Button(float x, float y, float w, float h, int bitmapResId, int pressedResId, Callback callback) {
        super((Metrics.width) * 1.1f, (Metrics.height * 0.1f) + (Metrics.width / 10 * y) ,
                Metrics.width / 10, Metrics.width / 10, bitmapResId);
        normalBitmap = bitmap;
        if (pressedResId != 0) {
            pressedBitmap = BitmapPool.get(pressedResId);
        }
        this.callback = callback;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        if (!pressed && !dstRect.contains(x, y)) {
            return false;
        }
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                pressed = true;
                bitmap = pressedBitmap;
                Log.d(TAG, "Down: " + pressedBitmap);
                callback.onTouch(Action.pressed);
                return true;
            case MotionEvent.ACTION_UP:
                pressed = false;
                bitmap = normalBitmap;
                Log.d(TAG, "Up: " + normalBitmap);
                return callback.onTouch(Action.released);
            case MotionEvent.ACTION_MOVE:
                return pressed;
        }
        return false;
    }
}
