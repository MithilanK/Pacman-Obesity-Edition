package com.mithilank.vibegame.gameobject;

import com.badlogic.gdx.graphics.Texture;
import com.mithilank.framework.Entity;

public class Food extends Entity{
	public Texture img;

	public Food(float x, float y) {
		super(x, y, 32, 32);
		this.img = new Texture("Food.png");
	}

}
