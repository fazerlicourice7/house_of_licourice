package com.fazerlicourice.flappybirdclone.com.flappbirdclone.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.fazerlicourice.flappybirdclone.gameworld.GameRenderer;
import com.fazerlicourice.flappybirdclone.gameworld.GameWorld;;

/**
 * Created by fazer on 10/25/15.
 */
public class GameScreen implements Screen {

    private GameRenderer renderer;
    private GameWorld world;

    public GameScreen(){
        renderer = new GameRenderer(world);
        world = new GameWorld();
    }
    @Override
    public void show() {
        Gdx.app.log("GameScreen","show called");
    }

    @Override
    public void render(float delta) {
        Gdx.app.log("GameScreen FPS", String.valueOf((1/delta)));
        renderer.render();
        world.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen","resize called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen","pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen","resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen","hide called");
    }

    @Override
    public void dispose() {

    }
}
