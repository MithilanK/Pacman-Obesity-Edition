package com.mithilank.vibegame.gameobject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mithilank.framework.Entity;

public class PacMan extends Entity {
    public Texture img;

    public PacMan() {
        super(256, 256, 49, 46);
        this.img = new Texture("Player.png");
    }

    public void Update(float dt) {

    }

    //public void Render(SpriteBatch b) {
    //    b.draw(this.img, (this.hitbox.position.x, this.hitbox.position.y));
    //
}
