package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Sam on 29.01.2017.
 */
public class Asteroid {
    private Vector2 position;
    private float speed;
    private Rectangle rect;
    private static Texture texture;

    public Rectangle getRect() {
        return rect;
    }

    Asteroid(){
        position = new Vector2(1280 + (float)Math.random() * 1280 ,(float)Math.random()*720);
        speed = 2.0f + (float) Math.random()* 6.0f;
        rect = new Rectangle(position.x,position.y,64,64);
        if (texture == null) texture = new Texture("asteroid64.png");
    }

    public void recreate(){
        position.x = 1280 + (float)Math.random() * 1280;
        position.y =(float)Math.random()*(720 - 64);
        speed = 2.0f + (float) Math.random()* 6.0f;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture,position.x,position.y);
    }

    public void update(){
        position.x -= speed;
        if (position.x < -64) {
            recreate();
        }
        rect.x = position.x;
        rect.y = position.y;
    }
}
