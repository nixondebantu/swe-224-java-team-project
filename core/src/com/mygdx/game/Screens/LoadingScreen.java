package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Assets.BgAssets;
import com.mygdx.game.MyGame;

public class LoadingScreen implements Screen {

    MyGame game;

    int xLoad;      //loading bar controller
    ShapeRenderer loadBar;
    GlyphLayout loadingText;
    GlyphLayout clickText;
    public LoadingScreen(MyGame game){
        this.game = game;
        loadBar = new ShapeRenderer();
        xLoad = 0;  //initial bar width 0
        loadingText = new GlyphLayout(BgAssets.font,"LOADING...");
        clickText = new GlyphLayout(BgAssets.font,"PRESS ANY KEY TO CONTINUE");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (xLoad == 800){


            if (BgAssets.score == 10 && Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
                BgAssets.clickSound.play();
                game.setScreen(new Level2(game));
                this.dispose();
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
                this.dispose();
                game.setScreen(new Level1(game));
            }
        }


        game.batch.begin();

        game.batch.draw(BgAssets.bgMenu,0,0);
        if (xLoad < 800) {
            BgAssets.font.draw(game.batch,loadingText,500,80);
        }
        else {
            BgAssets.font.draw(game.batch,clickText,200,100);
        }

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
