package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

public class Sprite implements GameObject{
    protected Bitmap bitmap;
    protected RectF dstRect = new RectF();
    protected float x , y;

    public Sprite(float x,float y,int bitmapResId) {
        this.x = x;
        this.y = y;

    }
    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap,null,dstRect,null);
    }

    public void setDstRect(float width,float height) {
        dstRect.set(x - width / 2 , y - height / 2 , x + width / 2 , y - height / 2);
    }
}
