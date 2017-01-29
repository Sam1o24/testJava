package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Background background;
	private Hero hero;
	private final int ASTEROIDS_COUNT = 50;
	private Asteroid[] asteroids;
	private  final  int BULLETS_COUNT = 100;
	private Texture textureBullet;
	public  static Bullet[] bullets;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Hero();
		asteroids = new Asteroid[ASTEROIDS_COUNT];
		for (int i = 0; i < asteroids.length; i++){
			asteroids[i] = new Asteroid();
		}
		bullets = new Bullet[BULLETS_COUNT];
		for (int i = 0; i < bullets.length; i++){
			bullets[i] = new Bullet();
		}
		textureBullet = new Texture("bullet32.png");
	}

	@Override
	public void render () {
	    update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		hero.render(batch);
		for (int i = 0; i < asteroids.length; i++){
			asteroids[i].render(batch);
		}
		for (int i = 0; i<bullets.length; i++){
			if (bullets[i].isActive())
			batch.draw(textureBullet,bullets[i].getPosition().x - 16,bullets[i].getPosition().y - 16);
		}
		batch.end();
	}

	public void update(){
		background.update();
		hero.update();
		for (int i = 0; i < asteroids.length; i++){
			asteroids[i].update();
		}
		for (int i = 0; i<bullets.length; i++){
			if (bullets[i].isActive()){
				bullets[i].update();
				for (int j = 0; j < asteroids.length; j++){
					if(asteroids[j].getRect().contains(bullets[i].getPosition())){
						asteroids[j].recreate();
						bullets[i].disable();
						break;
					}
				}
			}
    	}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
