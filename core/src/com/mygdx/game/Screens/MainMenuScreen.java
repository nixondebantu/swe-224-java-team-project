package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Assets.BgAssets;
import com.mygdx.game.MyGame;

public class MainMenuScreen implements Screen {

    MyGame game;
    Texture actPlayBtn = new Texture("menuBtn/activePlayBtn.png");
    Texture inactPlayBtn = new Texture("menuBtn/inactivePlayBtn.png");
    Texture actInsBtn = new Texture("menuBtn/activeInsBtn.png");
    Texture inactInsBtn = new Texture("menuBtn/inactiveInsBtn.png");
    Texture actStoryBtn = new Texture("menuBtn/activeStoryBtn.png");
    Texture inactStoryBtn = new Texture("menuBtn/inactiveStoryBtn.png");
    Texture actAboutBtn = new Texture("menuBtn/activeAboutBtn.png");
    Texture inactAboutBtn = new Texture("menuBtn/inactiveAboutBtn.png");
    Texture actExitBtn = new Texture("menuBtn/activeExitBtn.png");
    Texture inactExitBtn = new Texture("menuBtn/inactiveExitBtn.png");
    public MainMenuScreen(MyGame game){
        this.game = game;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);

        game.batch.begin();

        game.batch.draw(BgAssets.bgMenu,0,0);

        //play
        if( Gdx.input.getX() >= 33 && Gdx.input.getX() <= 428 && (MyGame.HEIGHT - Gdx.input.getY()) >=435 && (MyGame.HEIGHT - Gdx.input.getY()) <=493  ){
            game.batch.draw(actPlayBtn,33,435);
            if (Gdx.input.isTouched()){
                BgAssets.clickSound.play();
                this.dispose();
//                game.setScreen(new Level1(game));
                game.setScreen(new LoadingScreen(game));
            }
        }
        else{
            game.batch.draw(inactPlayBtn,33,435);
        }

        //instruction
        if( Gdx.input.getX() >= 33 && Gdx.input.getX() <= 428 && (MyGame.HEIGHT - Gdx.input.getY()) >=347 && (MyGame.HEIGHT - Gdx.input.getY()) <=405  ){
            game.batch.draw(actInsBtn,33,347);
            if (Gdx.input.isTouched()){
                BgAssets.clickSound.play();
                this.dispose();
                game.setScreen(new Instruction(game));
            }
        }
        else{
            game.batch.draw(inactInsBtn,33,347);
        }

        //story
        if( Gdx.input.getX() >= 33 && Gdx.input.getX() <= 428 && (MyGame.HEIGHT - Gdx.input.getY()) >=260 && (MyGame.HEIGHT - Gdx.input.getY()) <=318  ){
            game.batch.draw(actStoryBtn,33,260);
            if (Gdx.input.isTouched()){
                BgAssets.clickSound.play();
                this.dispose();
                game.setScreen(new Story(game));
            }
        }
        else {
            game.batch.draw(inactStoryBtn,33,260);
        }

        //about
        if( Gdx.input.getX() >= 33 && Gdx.input.getX() <= 428 && (MyGame.HEIGHT - Gdx.input.getY()) >=173 && (MyGame.HEIGHT - Gdx.input.getY()) <=231  ){
            game.batch.draw(actAboutBtn,33,173);
            if (Gdx.input.isTouched()){
                BgAssets.clickSound.play();
                this.dispose();
                game.setScreen(new about(game));
            }
        }
        else {
            game.batch.draw(inactAboutBtn,33,173);
        }
        if( Gdx.input.getX() >= 33 && Gdx.input.getX() <= 428 && (MyGame.HEIGHT - Gdx.input.getY()) >=84 && (MyGame.HEIGHT - Gdx.input.getY()) <=141  ){
            game.batch.draw(actExitBtn,33,84);
            if (Gdx.input.isTouched()){
//                BgAssets.clickSound.play();
                Gdx.app.exit();
            }
        }
        else {
            game.batch.draw(inactExitBtn,33,84);
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
}
