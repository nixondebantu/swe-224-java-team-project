package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Assets.BgAssets;
import com.mygdx.game.Screens.*;

public class MyGame extends Game {
	public SpriteBatch batch;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static int life;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new IntroScreen(this));
	}

	@Override
	public void render () {

		super.render();
		BgAssets.Bg_music.setLooping(true);
		BgAssets.Bg_music.play();
		if(!BgAssets.Bg_music.isPlaying()) BgAssets.Bg_music.play();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
