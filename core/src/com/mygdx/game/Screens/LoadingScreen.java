package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Assets.BgAssets;
import com.mygdx.game.MyGame;

public class LoadingScreen implements Screen {

    MyGame game;

    int xLoad;      //loading bar controller
    ShapeRenderer loadBar;
    public LoadingScreen(MyGame game){
        this.game = game;
        loadBar = new ShapeRenderer();
        xLoad = 0;  //initial bar width 0
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            this.dispose();
            game.setScreen(new Level1(game));
        }


        if(BgAssets.score==10 && Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            BgAssets.clickSound.play();
            game.setScreen(new Level2(game));
            this.dispose();
        }


        game.batch.begin();

        game.batch.draw(BgAssets.bgMenu,0,0);

        game.batch.end();

        if (xLoad < 800){
            loadBar.begin(ShapeRenderer.ShapeType.Filled);
            loadBar.setColor(Color.WHITE);
            loadBar.rect(250, 100, 10+xLoad, 20);
            loadBar.end();
            xLoad+=5;
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
}
