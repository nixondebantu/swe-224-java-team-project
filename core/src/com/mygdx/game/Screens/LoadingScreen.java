package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets.BgAssets;
import com.mygdx.game.MyGame;

public class LoadingScreen implements Screen {

    MyGame game;

    Animation[] loading;
    TextureRegion[] loadSheet = new TextureRegion[20];
    private float animationSpeed = 0.5f;
    float statetime;
    public LoadingScreen(MyGame game){
        this.game = game;
        loading = new Animation[20];
        TextureRegion[][] loadSprite = TextureRegion.split(new Texture("load.png"),900,90);
//        loading[20] = new Animation(animationSpeed,loadSprite[0]);
        for(int i=0;i<20;i++){
            loading[i] = new Animation(animationSpeed,loadSprite[i]);
        }
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        statetime += Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            BgAssets.clickSound.play();
            this.dispose();
            game.setScreen(new Level1(game));
//            game.setScreen(new MainGameScreen(game));
        }
        game.batch.begin();

        game.batch.draw(BgAssets.bgMenu,0,0);
//        game.batch.draw((Texture) loading[20].getKeyFrame(statetime,false),600,800);
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
