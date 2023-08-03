package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x=0,y=0;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("8800560.jpg");
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


//		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
//			y = y - 4;
//		}
//		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
//			y = y + 4;
//		}
		//x = x+4;
		//y=y+4;

		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
