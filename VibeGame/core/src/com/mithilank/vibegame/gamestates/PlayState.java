package com.mithilank.vibegame.gamestates;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mithilank.framework.Entity;
import com.mithilank.vibegame.VibeGame;
import com.mithilank.vibegame.gameobject.PacMan;

public class PlayState implements Screen {
    PacMan pacman;
    VibeGame game;
    Texture bg;
    SpriteBatch bgbatch;
    SpriteBatch entitybatch;
    public PlayState(VibeGame game){
        this.game = game;
    }

    @Override
    public void show() {
        this.bg = new Texture("BG.png");
        bgbatch = new SpriteBatch();
        entitybatch = new SpriteBatch();
        pacman = new PacMan();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(new Color(1, 1, 1, 0));
        bgbatch.begin();
        bgbatch.draw(this.bg, 0, 0);
        bgbatch.end();
        entitybatch.begin();
        entitybatch.draw(pacman.img, pacman.hitbox.position.x, pacman.hitbox.position.y);
        entitybatch.end();
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
