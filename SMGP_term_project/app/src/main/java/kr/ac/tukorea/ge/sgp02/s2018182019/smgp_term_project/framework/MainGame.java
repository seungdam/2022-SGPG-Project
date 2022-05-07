package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game.BackGround;

// 객체의 생성은 모두 여기서 관리
public class MainGame {
    private static MainGame singleton;
    private  static final String TAG = MainGame.class.getSimpleName();
    public float frameTime;
    public boolean scrolling = true;
    public static float mouseX, mouseY;

    protected ArrayList<ArrayList<GameObject>> layers;
    public enum Layer {bg , pizza,topping, COUNT };

    private GameObject backGround;



    // 게임 오브젝트 레이아웃 진행
    private void initLayers(int count) {
        layers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            layers.add(new ArrayList<>());
        }
    }

    public void add(Layer layer, GameObject gameObject) {
        GameView.view.post(new Runnable() {
            @Override
            public void run() {
                ArrayList<GameObject> gameObjects = layers.get(layer.ordinal());
                gameObjects.add(gameObject);
            }
        });
    }
    // --------------------------

    public static MainGame getInstance() {
        if (singleton == null) {
            singleton = new MainGame();
        }
        return singleton;
    }
    public void init() {
        initLayers(Layer.COUNT.ordinal());
        add(Layer.bg,new BackGround(R.mipmap.kitchen,1));
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

        frameTime = (float)(elapsedNanos / 1_000_000_000f);
        for (ArrayList<GameObject> gameObjects : layers) {
            for (GameObject gobj : gameObjects) {
                gobj.update();
            }
        }

    }
    public void draw(Canvas canvas){
        for (ArrayList<GameObject> gameObjects : layers) {
            for (GameObject gobj : gameObjects) {
                gobj.draw(canvas);
            }
        }
    }

    private MainGame() {

    }


}
