package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework;

import android.view.MotionEvent;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game.HorzBackGround;

// 객체의 생성은 모두 여기서 관리
public class MainGame {
    private static MainGame singleton;
    private HorzBackGround bg;
    public float frameTime;
    public float mouseX, mouseY;
    public static MainGame getInstance() {
        if (singleton == null) {
            singleton = new MainGame();
        }
        return singleton;
    }

    public void init() {
        MainGame game = MainGame.getInstance();
        game.init();

    }

    // 특정 위치에 도달하면 애니메이션 발생
    public boolean onMoveEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                mouseX = event.getX();
                mouseY = event.getY();
                return true;
        }
        return false;
    }

    public void update(int elapsedNanos) {
        frameTime = (float)(elapsedNanos / 1_000_000_000f);

    }
    private MainGame() {

    }


}
