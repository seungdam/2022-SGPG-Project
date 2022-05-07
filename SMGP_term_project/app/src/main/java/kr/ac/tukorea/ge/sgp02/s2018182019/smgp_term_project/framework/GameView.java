package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework;

import android.content.Context;

import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GameView extends View implements Choreographer.FrameCallback {
    public static GameView view;
    private long lastTimeNanos;
    private int framesPerSecond;
    private boolean initialized;
    private boolean running = true;
    public static final String TAG = GameView.class.getSimpleName();

    protected ArrayList<ArrayList<GameObject>> layers;
    public enum Layer  {kitchen_bg, counter_bg, cutting_bg}


    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = this;
    }

    // 게임 오브젝트 레이어 관련
    private void initLayers(int count) {
        layers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            layers.add(new ArrayList<>());
        }
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
        MainGame game = MainGame.getInstance();
        game.init();
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override
    public void doFrame(long currentTimeNanos) {

        long now = currentTimeNanos;
        if(lastTimeNanos == 0) {
            lastTimeNanos =now;
        }
        int elapsed = (int) (now - lastTimeNanos);
        if(elapsed != 0) {

            framesPerSecond = 1_000_000_000 / elapsed;
            MainGame.getInstance().update(elapsed);
            invalidate();
        }

        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        MainGame.getInstance().draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return MainGame.getInstance().onMoveEvent(event);

    }
}
