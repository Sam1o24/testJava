package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Sam on 29.01.2017.
 */
public class Hero {
    private Vector2 position;
    private float speed;
    private Texture texture;

    public Hero(){
        position = new Vector2(100,100);
        speed = 8.0f;
        texture = new Texture("ship80x60.tga");
    }

    public void render(SpriteBatch batch){
        batch.draw(texture,position.x,position.y);
    }

    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            position.y += speed;
            if (position.y > 720){
                position.y = -60;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            position.y -= speed;
            if (position.y < -60){
                position.y = 720;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            position.x -= speed;
            if (position.x < 0){
                position.x = 0;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            position.x += speed;
            if (position.x > 1200){
                position.x = 1200;
            }
        }
    }
}
