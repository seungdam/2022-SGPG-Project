package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework;

import android.content.res.Resources;
import android.util.TypedValue;

import kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.R;

public class Metrics {
    public static int width;
    public static int height;

    public static float size(int dimenResId) {
        Resources res = GameView.view.getResources();
        float size = res.getDimension(dimenResId);
        return size;
    }
    public static float floatValue(int dimenResId) {
        Resources res = GameView.view.getResources();
        TypedValue outValue = new TypedValue();

        res.getValue(dimenResId,outValue,true);
        float value = outValue.getFloat();
        return value;
    }
}
