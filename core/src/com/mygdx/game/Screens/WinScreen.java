package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Assets.BgAssets;
import com.mygdx.game.MyGame;

public class WinScreen implements Screen {
    MyGame game;

    public WinScreen(MyGame game) {
        this.game = game;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        game.batch.draw(BgAssets.bgWin,0,0);
        if (Gdx.input.getX() >=  540 && Gdx.input.getX() <=740 && Gdx.input.getY() >= 590 && Gdx.input.getY() <= 640) {
            game.batch.draw(BgAssets.homeBtn,530,77,220,56);
            if (Gdx.input.isTouched()) {
                BgAssets.clickSound.play();
                game.setScreen(new MainMenuScreen(game));
                this.dispose();
            }
        }
        else {
            game.batch.draw(BgAssets.homeBtn,540,80,200,50);
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
