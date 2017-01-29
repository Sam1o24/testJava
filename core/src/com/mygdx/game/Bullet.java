package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Sam on 29.01.2017.
 */
public class Bullet {

    private Vector2 position;
    private float speed;
    private boolean active;

    public Vector2 getPosition() {
        return position;
    }
    public boolean isActive() {
        return active;
    }

    Bullet(){
        position = new Vector2(0,0);
        speed = 12.0f;
        active = false;
    }

    public void setup(float x, float y){
        position.x = x;
        position.y = y;
        active = true;
    }

    public void disable(){
        active = false;
    }

    public void update(){
        position.x += speed;
        if (position.x > 1280) {
            disable();
        }
    }
}
