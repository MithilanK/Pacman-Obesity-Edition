package com.mithilank.vibegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mithilank.vibegame.gamestates.PlayState;

public class VibeGame extends Game {
	PlayState ps;
	
	@Override
	public void create () {
		ps = new PlayState(this);
		this.setScreen(ps);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
	}
}
