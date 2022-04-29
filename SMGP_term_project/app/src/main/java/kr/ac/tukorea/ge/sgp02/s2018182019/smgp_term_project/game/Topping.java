package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.game;

import android.graphics.Canvas;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;
import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework.Sprite;

public class Topping extends Sprite {
    float x, y;

    public Topping(float x, float y) {
        super(x, y, R.dimen.topping_radius, R.mipmap.peperoni);
    }

    public void setPosition(float x,float y) {
        this.x = x;
        this.y = y;
    }
    public void update() {

    }

    public void draw(Canvas canvas) {

    }

    public void fire() {

    }
}