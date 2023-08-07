package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.mygdx.game.Assets.BgAssets;
import com.mygdx.game.MyGame;

import java.util.ArrayList;
import java.util.Random;

public class Level3 implements Screen {
    MyGame game;
    public static float speed = 220;
    public int score;
    private boolean gamePause;
    private boolean scrollPause;
    private int yPause;
    Random random = new Random();

    float x,y;

    //coin


    //bg
    float bg_x1=0,bg_x2=1280;
    int bg_speed = 4;


    //lasers
    float xL[] = {MyGame.WIDTH,MyGame.WIDTH*1.5f,MyGame.WIDTH*2f,MyGame.WIDTH*2.5f,MyGame.WIDTH*3f,MyGame.WIDTH*3.5f,MyGame.WIDTH*4f};
    int yL[] = new int[7];;

    //explosion
    ArrayList<explosions> Explosions;

    Texture ship = new Texture("ship.png");

    public Level3(MyGame game){
        this.game = game;
        x = 30;
        y = MyGame.HEIGHT/2f - 100f;


        BgAssets.asteroids[0] = new Texture("asteroids/ast1.png");
        BgAssets.asteroids[2] = new Texture("asteroids/ast2.png");
        BgAssets.asteroids[1] = new Texture("asteroids/1.png");

        Explosions = new ArrayList<explosions>();

        gamePause = false;
        scrollPause = false;
        yPause = 0;
        MyGame.life = 3;

    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        //bg render
        game.batch.draw(BgAssets.bgLvl3_1,bg_x1,0);
        game.batch.draw(BgAssets.bgLvl3_2,bg_x2,0);

        if (score == 30) {
            game.setScreen(new WinScreen(game));
            this.dispose();
        }

        if (!scrollPause && !gamePause) {       //play screen
            if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
                scrollPause = true;
                gamePause = true;
                BgAssets.clickSound.play();
            }
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

            //score
            GlyphLayout scoreLatout = new GlyphLayout(BgAssets.font,"Score: "+score);
            BgAssets.font.draw(game.batch,scoreLatout,MyGame.WIDTH - 300,MyGame.HEIGHT-50);

            //leasers
            for (int i = 0; i < 3; i++) {

                xL[i] -= (MainGameScreen.speed + BgAssets.score * 10) * Gdx.graphics.getDeltaTime() * 2;
                if (xL[i] < -300) {
                    if( yL[i] != 800){
                        BgAssets.point.play();
                        score++;
                    }
                    xL[i] = MyGame.WIDTH;
                    yL[i] = random.nextInt(440) - 10;
                }
            }
            //asteroids
            for (int i=0;i<3;i++){
                game.batch.draw(BgAssets.asteroids[i],xL[i],yL[i]);
            }
            //ship
            game.batch.draw(ship,x,y);
            collsion();

            for (explosions Explosions : Explosions) {
                Explosions.render(game.batch);
            }

        }
        else if (scrollPause && gamePause) {    //play-pause screen
            if (yPause < 400) {
                yPause += 10;
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
                gamePause = false;
                BgAssets.clickSound.play();
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.H)) {    //Home key
                BgAssets.clickSound.play();
                game.setScreen(new MainMenuScreen(game));
                this.dispose();
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.R)) {    //Restart key
                BgAssets.clickSound.play();
                BgAssets.score = 20;
                game.setScreen(new LoadingScreen(game));
                this.dispose();
            }
        }
        else {      //pause-play screen
            if (yPause < 840) {
                yPause += 10;
            }
            else {
                yPause = 0;
                scrollPause = false;
            }
        }

        if (gamePause || scrollPause) {             //pause display message drawing
            GlyphLayout pauseMessage = new GlyphLayout(BgAssets.font,"Level:3\nGame Paused\nPress:\nEsc - Resume\nR - Restart\nH - Home");
            BgAssets.font.draw(game.batch,pauseMessage,420,yPause);
        }
        if (MyGame.life == 0) {
            game.setScreen(new OverScreen(game));
            BgAssets.score = 20;
            this.dispose();
        }



        game.batch.end();


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


        for (int i = 0 ; i < 3 ; i++) {
            if ((x <= xL[i] && xL[i] <= x+150) || (x-150 <= xL[i] && xL[i] <= x)) {
                if ((y + 56 <= yL[i] && yL[i] + 150 <= y + 112) || (y + 56 <= yL[i] && yL[i] <= y + 112) ||
                        (yL[i] <= y + 56 && yL[i] <= y+112 && y + 56 <= yL[i] + 150 && y + 112 <= yL[i] + 150)){
                    yL[i] = 800;
                    MyGame.life--;
                    if (!BgAssets.explosion.isPlaying()){
                        BgAssets.explosion.play();
                    }
                    Explosions.add(new explosions(x+125,y+25));
                }
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
