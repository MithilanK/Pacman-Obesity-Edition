package com.mithilank.vibegame.gamestates;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mithilank.framework.Entity;
import com.mithilank.vibegame.VibeGame;
import com.mithilank.vibegame.gameobject.Food;
import com.mithilank.vibegame.gameobject.PacMan;

public class PlayState implements Screen {
    PacMan pacman;
    VibeGame game;
    Texture bg;
    SpriteBatch bgbatch;
    SpriteBatch entitybatch;
    OrthographicCamera cam;
    float bgy;
    ArrayList<Food> foods;
    float foodcount;
    float points;
    public PlayState(VibeGame game){
        this.game = game;
    }

    public float Randomfloat(float max, float min) {
    	return (float) Math.floor(Math.random()*(max-min+1)+min);
    }
    
    public void loadfood() {
    	for (float i = 0; i < foodcount; i++) {
    		foods.add(new Food(Randomfloat(Gdx.graphics.getWidth(), 0), Randomfloat(Gdx.graphics.getHeight(), 0)));
        }
    }
    
    
    static float closestMultiple(float n, float x)
    {  
        if(x>n)
           return x;
        n = n + x/2;
        n = n - (n%x);
        return n;
    }
    
    @Override
    public void show() {
        this.bg = new Texture("BG.png");
        bgbatch = new SpriteBatch();
        entitybatch = new SpriteBatch();
        pacman = new PacMan();
        cam = new OrthographicCamera();
        cam.setToOrtho(false);
        bgy = 0;
        foodcount = 6f;
        points = 0f;
        foods = new ArrayList<Food>();
        loadfood();
        
    }

    @Override
    public void render(float delta) {
    	pacman.Update(delta);
    	bgy = closestMultiple(pacman.hitbox.position.y * -1f, (float) Gdx.graphics.getHeight() + 32);

    	for (Food food: foods) {
        	if (food.hitbox.position.y >  cam.position.y + cam.viewportHeight/ 2) {
        		food.hitbox.setLeft(Randomfloat(Gdx.graphics.getWidth() - food.hitbox.width, 0));
        		food.hitbox.setTop(Randomfloat((cam.position.y - cam.viewportHeight/ 2 - Gdx.graphics.getHeight()) * -1 ,(cam.position.y - cam.viewportHeight/ 2) * -1) * -1);
        	}
        	if (food.hitbox.colliderect(pacman.hitbox)) {
        		food.hitbox.setLeft(Randomfloat(Gdx.graphics.getWidth() - food.hitbox.width, 0));
        		food.hitbox.setTop(Randomfloat((cam.position.y - cam.viewportHeight/ 2 - Gdx.graphics.getHeight()) * -1 ,(cam.position.y - cam.viewportHeight/ 2) * -1) * -1);
        		points += 1f;
        		System.out.println(points);
        	}
        	
        }
    	
    	
    	
        ScreenUtils.clear(new Color(1, 1, 1, 0));
        cam.position.y = pacman.hitbox.position.y;
        bgbatch.setProjectionMatrix(cam.combined);
        bgbatch.begin();
        bgbatch.draw(this.bg,0, bgy * -1);
        bgbatch.draw(this.bg,0, bgy * -1 - (float) Gdx.graphics.getHeight() + 32);
        bgbatch.draw(this.bg,0, bgy * -1 + (float) Gdx.graphics.getHeight() - 32);
        bgbatch.end();
        entitybatch.setProjectionMatrix(cam.combined);
        entitybatch.begin();
        for (Food food: foods) {
        	entitybatch.draw(food.img, food.hitbox.position.x, food.hitbox.position.y);
        }
        entitybatch.draw(pacman.img, pacman.hitbox.position.x, pacman.hitbox.position.y);
        entitybatch.end();
        cam.update();
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
