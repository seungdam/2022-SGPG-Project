package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;

public class Sprite implements GameObject{
    protected Bitmap bitmap;
    protected RectF dstRect = new RectF();
    protected float x , y,radius;

    public Sprite(float x,float y,int radiusDimeResId,int bitmapResId) {
        this.x = x;
        this.y = y;
        this.radius = Metrics.size(radiusDimeResId);
        dstRect.set(x - radius, y -radius , x + radius , y +radius);
        bitmap = BitmapPool.get(bitmapResId);
    }

    public Sprite(float x, float y, float w, float h, int bitmapResId) {
        this.x = x;
        this.y = y;
        this.radius = w / 2;
        dstRect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2);
        bitmap = BitmapPool.get(bitmapResId);
    }

    public Sprite(int bitmapResId) {
        dstRect.set(0, 0, Metrics.width, Metrics.height);
        bitmap = BitmapPool.get(bitmapResId);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap,null,dstRect,null);
    }

    public void setDstRect(float x , float y, float width,float height) {
        dstRect.set(x - width / 2 , y - height / 2 , x + width / 2 , y - height / 2);
    }
}
