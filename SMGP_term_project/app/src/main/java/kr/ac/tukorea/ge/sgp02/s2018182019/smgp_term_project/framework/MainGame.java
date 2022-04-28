package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game.BackGround;

// 객체의 생성은 모두 여기서 관리
public class MainGame {
    private static MainGame singleton;
    private  static final String TAG = MainGame.class.getSimpleName();
    public float frameTime;
    public boolean scrolling = true;
    public static float mouseX, mouseY;
    private GameObject backGround;
    public static MainGame getInstance() {
        if (singleton == null) {
            singleton = new MainGame();
        }
        return singleton;
    }

    public void init() {
        backGround = new BackGround(R.mipmap.test,1);
    }

    // 특정 위치에 도달하면 애니메이션 발생
    public boolean onMoveEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                scrolling=true;
            case MotionEvent.ACTION_MOVE:
                mouseX = event.getX();
                mouseY = event.getY();
                return true;
        }
        return false;
    }

    public void update(int elapsedNanos) {

        backGround.update();
        frameTime = (float)(elapsedNanos / 1_000_000_000f);

    }
    public void draw(Canvas canvas){
        backGround.draw(canvas);
    }

    private MainGame() {

    }


}
