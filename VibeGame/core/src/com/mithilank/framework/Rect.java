package com.mithilank.framework;

import com.badlogic.gdx.math.Vector2;

public class Rect {
    public Vector2 position;
    float width;
    float height;
    public Rect(float x, float y, float width, float height) {
        this.position = new Vector2(x, y);
        this.width = width;
        this.height = height;

    }

    public Rect(Vector2 xy, float width, float height) {
        this.position = xy;
        this.width = width;
        this.height = height;
    }

    public Rect copy() {
        return new Rect(this.position.x, this.position.y, this.width, this.height);
    }

    public Rect move(float x, float y) {
        return new Rect(this.position.x + x, this.position.y + y, this.width, this.height);
    }

    public void move_ip(float x, float y) {
        this.position.x += x;
        this.position.y += y;

    }

    public Rect inflate(float width, float height) {
        return new Rect(this.position.x, this.position.y, this.width + width, this.height + height);

    }

    public void inflate_ip(float width, float height) {
        this.width += width;
        this.height += height;

    }

    public boolean colliderect(Rect rect) {
        return position.x < rect.position.x + rect.width && position.y < rect.position.y + rect.height && position.x + width > rect.position.x && position.y + height > rect.position.y;

    }

    public float getTop() {
        return this.position.y + this.height;
    }

    public float getBottom() {
        return this.position.y;
    }

    public float getRight() {
        return this.position.x + width;
    }

    public float getLeft() {
        return this.position.x;
    }

    public void setRight(float x) {
        this.position.x = x - this.width;
    }

    public void setLeft(float x) {
        this.position.x = x;
    }

    public void setTop(float y) {
        this.position.y = y - this.height;
    }

    public void setBottom(float y) {
        this.position.y = y;
    }





}
