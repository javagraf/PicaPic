package com.ok.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by javagraf on 26.12.2016.
 */

public class Landslide {

    private static final int GRAVITY = -50;

    private Vector3 posLandslide;
    private Vector3 downMove;

    private Animation landslideAnimation;
    private Texture texture;

    private Rectangle boundLandslide;

    public Landslide(float x, float y){

        posLandslide = new Vector3(x,y,0);
        downMove = new Vector3(0,0,0);
        texture = new Texture("gappy.png");
        landslideAnimation = new Animation(new TextureRegion(texture), 4, 0.5f);
        boundLandslide = new Rectangle(posLandslide.x, posLandslide.y,
                texture.getWidth()/4, texture.getHeight());
    }

    public void update(float dt){

        landslideAnimation.update(dt);

        downMove.add(0,GRAVITY,0);
        downMove.scl(dt);
        posLandslide.add(0,downMove.y,0);
        boundLandslide.setPosition(posLandslide.x, posLandslide.y);
        downMove.scl(0);


    }

    public void reposition(float у){
        posLandslide.set(MathUtils.random(0,220), у, 0);
        boundLandslide.setPosition(posLandslide.x, posLandslide.y);
    }
    public boolean crossGap(Rectangle player){
        return boundLandslide.overlaps(player) ;
    }

    public TextureRegion getLandslide(){
        return landslideAnimation.getFrame();
    }

    public Vector3 getPosLandslide(){
        return posLandslide;
    }

    public Rectangle getBoundLandslide(){
        return boundLandslide;
    }


}