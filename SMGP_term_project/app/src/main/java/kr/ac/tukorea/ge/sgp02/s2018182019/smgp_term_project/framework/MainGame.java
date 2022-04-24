package kr.ac.tukorea.ge.sgp02.s2018182019.smgp_term_project.framework;

public class MainGame {

    public static MainGame getInstance() {
        if (singleton == null) {
            singleton = new MainGame();
        }
        return singleton;
    }

    private MainGame() {

    }

    private static MainGame singleton;
}
