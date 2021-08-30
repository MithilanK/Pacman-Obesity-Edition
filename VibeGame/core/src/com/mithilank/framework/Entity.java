package com.mithilank.framework;

import com.badlogic.gdx.math.Vector2;

public class Entity {
    public Rect hitbox;


    public Entity(float x, float y, float width, float height) {
        hitbox = new Rect(x, y, width, height);
    }

    public void move(Vector2 Movement, Entity[] rects) {
        hitbox.position.x += Movement.x;
        if (rects != null) {
	        for (Entity E : rects) {
	            Rect rect = E.hitbox;
	            if (rect.colliderect(hitbox)) {
	                if (Movement.x > 0) {
	                    hitbox.setRight(rect.getLeft());
	                }
	                if (Movement.x < 0) {
	                    hitbox.setLeft(rect.getRight());
	                }
	            }
	        }
        }
        hitbox.position.y += Movement.y;
        if (rects != null) { 
	        for (Entity E : rects) {
	            Rect rect = E.hitbox;
	            if (rect.colliderect(hitbox)) {
	                if (Movement.y > 0) {
	                    hitbox.setTop(rect.getBottom());
	                }
	                if (Movement.y < 0) {
	                    hitbox.setBottom(rect.getTop());
	                }
	            }
	        }
        }

    }


}

