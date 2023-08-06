package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Assets.BgAssets;
import com.mygdx.game.MyGame;


import java.util.ArrayList;
import java.util.Random;

public class Level1 implements Screen {

    MyGame game;
    public static float speed = 220;
    public int score;
    private boolean notPause = true;
    Random random = new Random();

    float x,y;

    //coin
    float coin_x = 590, coin_y = 360;


    //bg
    float bg_x1=0,bg_x2=1280;
    int bg_speed = 4;

    //lasers
    float xL[] = {MyGame.WIDTH,MyGame.WIDTH*1.5f,MyGame.WIDTH*2f,MyGame.WIDTH*2.5f};
    int yL[] = new int[4];

    //explosion
    ArrayList<explosions> Explosions;

    Texture ship = new Texture("ship.png");
    public Level1(MyGame game){
        this.game = game;
        x = 30;
        y = MyGame.HEIGHT/2f - 100f;
        for(int i=0 ; i<4 ; i++){
            yL[i] = random.nextInt(440) - 10;
        }

        BgAssets.asteroids[0] = new Texture("bg/LaserB.png");
        BgAssets.asteroids[2] = new Texture("bg/LaserG.png");
        BgAssets.asteroids[1] = new Texture("asteroids/1.png");
        BgAssets.asteroids[3] = new Texture("coin.png");

        Explosions = new ArrayList<explosions>();


    }
    @Override
    public void show() {
        BgAssets.Bg_music.play();
    }

    @Override
    public void render(float delta) {

        if (notPause){
            //buttons
            if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
                if (y < MyGame.HEIGHT - 115) y += speed * Gdx.graphics.getDeltaTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
                if (y > 0) y -= speed * Gdx.graphics.getDeltaTime();
            }

            //bg moving
            bg_x1 -= bg_speed;
            if (bg_x1<-1280) bg_x1 = 1280;
            bg_x2 -= bg_speed;
            if (bg_x2<-1280) bg_x2 = 1280;

            //leasers
            for (int i = 0; i < 4; i++) {
                xL[i] -= (MainGameScreen.speed + score * 10) * Gdx.graphics.getDeltaTime() * 2;
                if (xL[i] < -1280) {
                    //BgAssets.point.play();
                    score++;
                    xL[i] = MyGame.WIDTH;
                    yL[i] = random.nextInt(440) - 10;
                }
            }

            coin_x -= (MainGameScreen.speed + score * 10) * Gdx.graphics.getDeltaTime() * 2;
            if(coin_x < -60){
                coin_x = 2560;
                coin_y =  random.nextInt(440) - 10;
            }
        }

        game.batch.begin();
        //bg render
        game.batch.draw(BgAssets.bgLvl1_1,bg_x1,0);
        game.batch.draw(BgAssets.bgLvl1_2,bg_x2,0);

        //asteroids
        for (int i=0;i<4;i++){
            game.batch.draw(BgAssets.asteroids[i],xL[i],yL[i]);
        }
        //ship
        game.batch.draw(ship,x,y);
        collsion();

        for (explosions Explosions : Explosions) {
            Explosions.render(game.batch);
        }
        game.batch.end();


        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            if(notPause) {
                notPause = false;
                game.pause();
            }
            else {
                notPause = true;
                game.resume();
            }
//            try {               //delay maker
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    public void collsion(){


        if((x+150 <= xL[0]+90 && x+150 >= xL[0]+60) || (x <= xL[0]+90 && x >= xL[0])  ){
            if((y+120 <= yL[0]+332 && y+120 >= yL[0]+60) || (y <= yL[0]+272 && y >= yL[0])){
                if(!BgAssets.explosion.isPlaying()){
                    BgAssets.explosion.play();
                }
                Explosions.add(new explosions(x+125,y+25));

//                notPause = false;
//                game.pause();

            }
        }




        if((x+150 <= xL[2]+90 && x+150 >= xL[2]+60) || (x <= xL[2]+90 && x >= xL[2])  ){
            if((y+120 <= yL[2]+332 && y+120 >= yL[2]+60) || (y <= yL[2]+272 && y >= yL[2])){
                if(!BgAssets.explosion.isPlaying()){
                    BgAssets.explosion.play();
                }
                Explosions.add(new explosions(x+125,y+25));
//                notPause = false;
//                game.pause();


            }
        }
        if((x+150 <= xL[1]+209 && x+150 >= xL[1]+80) || (x <= xL[2]+209 && x >= xL[2])  ){
            if((y+120 <= yL[2]+250 && y+120 >= yL[2]+80) || (y <= yL[2]+170 && y >= yL[2]+10)){
                if(!BgAssets.explosion.isPlaying()){
                    BgAssets.explosion.play();
                }
                Explosions.add(new explosions(x+125,y+25));
//                notPause = false;
//                game.pause();

            }
        }

        //Update explosions
        ArrayList<explosions> explosionsToRemove = new ArrayList<explosions>();
        for (explosions  Explosions: Explosions) {
            Explosions.update(Gdx.graphics.getDeltaTime());
            if (Explosions.remove)
                explosionsToRemove.add(Explosions);
        }
        Explosions.removeAll(explosionsToRemove);

    }
}
