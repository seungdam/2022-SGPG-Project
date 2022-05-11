package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework;

import android.graphics.Canvas;

// 토핑 오브젝트에 대한 인터페이스 구현
public interface GameObject {
    public void update(float frameTime);
    public void draw(Canvas canvas);

}
