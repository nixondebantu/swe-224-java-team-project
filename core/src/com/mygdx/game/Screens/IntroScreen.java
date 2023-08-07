package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets.BgAssets;
import com.mygdx.game.MyGame;

public class IntroScreen implements Screen {
    MyGame game;
    Texture introSS;
    TextureRegion[] introFrames;
     Animation<TextureRegion> animation;
     float elapsedTime;
    public IntroScreen(MyGame game) {
        this.game = game;
        introSS = new Texture("screens/introSprite.png");
        TextureRegion[][] tmpFrames = TextureRegion.split(introSS,800,450);
        introFrames = new TextureRegion[160];
        int index = 0;
        for (int i = 0 ; i < 10 ; i++) {
            for (int j = 0 ; j < 16 ; j++) {
                introFrames[index++] = tmpFrames[i][j];
            }
        }
        animation = new Animation<>(0.05f,introFrames);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
//        animationTime += delta;
        elapsedTime += Gdx.graphics.getDeltaTime();
        game.batch.begin();
        game.batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,false),0,0,1280,720);
        if (Gdx.input.getX() >= 1005 && Gdx.input.getX() <= 1260 && Gdx.input.getY() >= 10 && Gdx.input.getY() <= 63){
            if (Gdx.input.isTouched()){
                game.setScreen(new MainMenuScreen(game));
                this.dispose();
            }
        }
        if (animation.isAnimationFinished(elapsedTime)){
            if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) || Gdx.input.isTouched()){
                game.setScreen(new MainMenuScreen(game));
                this.dispose();
            }
            game.batch.draw(BgAssets.introText,140,60);
        }
        game.batch.draw(BgAssets.skipBtn,1005,659,255,52);
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
