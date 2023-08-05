package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import com.mygdx.game.MyGame;

public class about implements Screen {
    MyGame game;
    Sound click_sound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.mp3"));
    Texture about_bg = new Texture("screens/about.jpg");
    public about(MyGame game){
        this.game = game;

    }


    @Override
    public void show() {

    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(about_bg,0,0);
        if( Gdx.input.getX() >= 80 && Gdx.input.getX() <= 343 && (720 - Gdx.input.getY()) >=560 && (720 - Gdx.input.getY()) <=640  ){
            if(Gdx.input.isTouched()){
                click_sound.play();
                this.dispose();
                game.setScreen(new MainMenuScreen(game));
            }
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
