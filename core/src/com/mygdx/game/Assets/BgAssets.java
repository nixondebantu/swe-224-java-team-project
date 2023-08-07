package com.mygdx.game.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class BgAssets {
    public static Texture bgLvl1_1 = new Texture("bg/bgLvl1.1.jpg");
    public static Texture bgLvl1_2 = new Texture("bg/bgLvl1.2.jpg");
    public static Texture bgLvl2_1 = new Texture("bg/bgLvl2.1.jpg");
    public static Texture bgLvl2_2 = new Texture("bg/bgLvl2.2.jpg");
    public static Texture bgLvl3_1 = new Texture("bg/bgLvl3.1.jpg");
    public static Texture bgLvl3_2 = new Texture("bg/bgLvl3.2.jpg");
    public static Texture bgMenu = new Texture("bg/bgMenu.jpg");
    public static Texture activeInsBtn = new Texture("menuBtn/activeInsBtn.png");
    public static Texture laserB = new Texture("bg/LaserB.png");
    public static Texture laserG = new Texture("bg/LaserG.png");
    public static Sound clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.mp3"));
    public static Music explosion  = Gdx.audio.newMusic(Gdx.files.internal("sounds/explosion.mp3"));
    public static Music point = Gdx.audio.newMusic(Gdx.files.internal("sounds/points.mp3"));
    public static Music Bg_music = Gdx.audio.newMusic(Gdx.files.internal("sounds/bg_music.mp3"));
    public static Texture bgWin = new Texture("bg/bgWin.png");
    public static Texture homeBtn = new Texture("bg/homeBtn.png");
    public static Texture bgOver = new Texture("bg/bgOver.png");
    public static Texture restartBtn = new Texture("bg/restartBtn.png");


    public static Texture[] asteroids = new Texture[7];
//    asteroids[0] = new Texture("bg/LaserG.png");

    public static Texture coin = new Texture("coin.png");
    public static BitmapFont font = new BitmapFont(Gdx.files.internal("font/score.fnt"));
    public static int score = 0;

}
