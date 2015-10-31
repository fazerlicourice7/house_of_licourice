package com.fazerlicourice.flappybirdclone;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.fazerlicourice.flappybirdclone.com.flappbirdclone.Screens.GameScreen;

/**
 * Created by fazer on 10/25/15.
 */
public class FlappyBirdGame extends Game {

    @Override
    public void create() {
        Gdx.app.log("FlappyBird", "Created");
        setScreen(new GameScreen());
    }
}
