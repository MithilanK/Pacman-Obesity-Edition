package com.mithilank.vibegame.gameobject;

import java.awt.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mithilank.framework.Entity;
import com.mithilank.framework.Rect;

public class PacMan extends Entity {
    public Texture img;
    public Vector2 vel;
    public Entity[] rects;
    public Boolean MovingRight;
    public Boolean MovingLeft;
    public float yvel = 0;
    public PacMan() {
        super(256, 256, 49, 46);
        this.img = new Texture("Player.png");
        vel = new Vector2(0f, 0f);
        MovingRight = true;
        MovingLeft = false;
        yvel = -200f;
        
    }

    public void Update(float dt) {
    	vel.x = 0;
    	
    	if (MovingRight) {
    		vel.x = 500 * dt;
    	}
    	if (MovingLeft) {
    		vel.x = -500 * dt;
    	}
    	
    	
    	
    	if (Gdx.input.isKeyPressed(Keys.A)) {
    		MovingRight = false;
    		MovingLeft = true;
    	}
    	if (Gdx.input.isKeyPressed(Keys.D)) {
    		MovingRight = true;
    		MovingLeft = false;
    	}
    	if (this.hitbox.position.x < 0) {
    		this.hitbox.position.x = 0;
    		MovingRight = true;
    		MovingLeft = false;
    		
    	}
    	if (this.hitbox.getRight() > 640) {
    		this.hitbox.setRight(640);
    		MovingLeft = true;
    		MovingRight = false;
    		
    	}
    	vel.y = yvel * dt;
    	this.move(vel, rects);
    }

    //public void Render(SpriteBatch b) {
    //    b.draw(this.img, (this.hitbox.position.x, this.hitbox.position.y));
    //
}
