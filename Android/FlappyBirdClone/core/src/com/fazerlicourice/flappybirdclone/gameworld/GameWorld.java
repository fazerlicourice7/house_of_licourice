package com.fazerlicourice.flappybirdclone.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by fazer on 10/25/15.
 */
public class GameWorld {

    private Rectangle rect;

    public GameWorld(){
        rect = new Rectangle(0, 0, 17, 12);

    }

    public void update(float delta){
        rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }
        Gdx.app.log("GameScreen", "updated");
    }

    public Rectangle getRect(){
        return rect;
    }
}

