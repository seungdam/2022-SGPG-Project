package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework;

import android.content.Context;

import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game.HorzBackGround;

public class GameView extends View implements Choreographer.FrameCallback {
    public static GameView view;
    private long lastTimeNanos;
    private int framesPerSecond;
    private boolean initialized;
    private boolean running;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = this;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Metrics.width = w;
        Metrics.height = h;

        if (!initialized) {
            initView();
            initialized = true;
        }
    }
    public void initView() {



    }
    @Override
    public void doFrame(long currentTimeNanos) {
        if(!running) {
            return;
        }
        long now = currentTimeNanos;

        int elapsed = (int) (now - lastTimeNanos);
        if(elapsed != 0) {
            framesPerSecond = 1_000_000_000 / elapsed;
            MainGame game = MainGame.getInstance();
            game.update(elapsed);
            invalidate();
        }
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
