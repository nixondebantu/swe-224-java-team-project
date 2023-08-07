package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Assets.BgAssets;
import com.mygdx.game.MyGame;

public class OverScreen implements Screen {
    MyGame game;
    public OverScreen(MyGame game){
        this.game = game;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        game.batch.draw(BgAssets.bgOver,0,0);

        if (Gdx.input.getX() >= 540 && Gdx.input.getX() <= 740) {
            if (Gdx.input.getY() >= 520 && Gdx.input.getY() <= 570) {   //hover restart button
                game.batch.draw(BgAssets.restartBtn,530,147,220,56);
                game.batch.draw(BgAssets.homeBtn,540,80,200,50);

                if (Gdx.input.isKeyPressed(Input.Keys.R) || Gdx.input.isTouched()) {
                    BgAssets.clickSound.play();
                    game.setScreen(new LoadingScreen(game));
                    this.dispose();
                }
            }
            else if (Gdx.input.getY() >= 590 && Gdx.input.getY() <= 640) {  //hover home button
                game.batch.draw(BgAssets.restartBtn,540,150,200,50);
                game.batch.draw(BgAssets.homeBtn,530,77,220,56);

                if (Gdx.input.isKeyPressed(Input.Keys.H) || Gdx.input.isTouched()) {
                    BgAssets.clickSound.play();
                    game.setScreen(new MainMenuScreen(game));
                    this.dispose();
                }
            }
            else {
                game.batch.draw(BgAssets.restartBtn,540,150,200,50);
                game.batch.draw(BgAssets.homeBtn,540,80,200,50);
            }
        }
        else {
            game.batch.draw(BgAssets.restartBtn,540,150,200,50);
            game.batch.draw(BgAssets.homeBtn,540,80,200,50);
        }

        game.batch.end();

        //Hot key function
        if (Gdx.input.isKeyPressed(Input.Keys.H)) {
            BgAssets.clickSound.play();
            game.setScreen(new MainMenuScreen(game));
            this.dispose();
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.R)) {
            BgAssets.clickSound.play();
            game.setScreen(new LoadingScreen(game));
            this.dispose();
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
