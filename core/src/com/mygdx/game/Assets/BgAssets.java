package com.mygdx.game.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class BgAssets {
    public static Texture bgLvl1_1 = new Texture("bg/bgLvl1.1.jpg");
    public static Texture bgLvl1_2 = new Texture("bg/bgLvl1.2.jpg");
    public static Texture bgLvl2 = new Texture("bg/bgLvl2.jpg");
    public static Texture bgLvl3 = new Texture("bg/bgLvl3.jpg");
    public static Texture bgMenu = new Texture("bg/bgMenu.jpg");
    public static Texture activeInsBtn = new Texture("menuBtn/activeInsBtn.png");
    public static Texture laserB = new Texture("bg/LaserB.png");
    public static Texture laserG = new Texture("bg/LaserG.png");
    public static Sound clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.mp3"));
    public static Texture[] asteroids = new Texture[6];
//    asteroids[0] = new Texture("bg/LaserG.png");

    public static Texture coin = new Texture("coin.png");

}
