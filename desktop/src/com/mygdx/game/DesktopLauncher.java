package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.Assets.BgAssets;
import com.mygdx.game.MyGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main (String[] arg) {
        // hello this is shaeakh and nixon
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("Arcane Adventure");
        config.setWindowedMode(MyGame.WIDTH, MyGame.HEIGHT);
        config.setResizable(false);
        new Lwjgl3Application(new MyGame(), config);

    }
}
