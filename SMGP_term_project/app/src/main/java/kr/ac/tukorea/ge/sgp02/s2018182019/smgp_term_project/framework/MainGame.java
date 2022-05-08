package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game.BackGround;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game.ToppingCage;

// 객체의 생성은 모두 여기서 관리
public class MainGame {
    private static MainGame singleton;
    private  static final String TAG = MainGame.class.getSimpleName();
    public float frameTime;
    public boolean scrollLeft = false;
    public boolean scrollRight = false;
    public static float mouseX, mouseY;
    public static int curScene = 0;
    protected ArrayList<ArrayList<GameObject>> layers;
    public enum Layer {bg, customer ,fg, pizza,topping, COUNT };
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
        add(Layer.bg,new BackGround(R.mipmap.floor,0));
        add(Layer.fg,new BackGround(R.mipmap.counter2,0));
        add(Layer.fg,new BackGround(R.mipmap.kitchen2,1));
        add(Layer.fg,new BackGround(R.mipmap.cutting,2));
        add(Layer.topping, new ToppingCage(0,R.mipmap.olivecage));
        add(Layer.topping, new ToppingCage(1,R.mipmap.peperonicage));
        add(Layer.topping, new ToppingCage(2,R.mipmap.mushroomcage));
        add(Layer.topping, new ToppingCage(3,R.mipmap.meatcage));
    }

    // 특정 위치에 도달하면 애니메이션 발생
    public boolean onMoveEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mouseX = event.getX();
                mouseY = event.getY();
                if(mouseX < Metrics.width * 0.1) {
                    if(curScene != 0 && !scrollLeft)
                        curScene -=1;
                        scrollLeft = true;

                }
                else if(mouseX > Metrics.width * 0.9) {
                    if (curScene != 2 && !scrollRight)
                        curScene += 1;
                        scrollRight = true;


            }
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
