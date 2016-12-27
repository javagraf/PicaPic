package com.ok.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

/**
 * Created by javagraf on 23.12.2016.
 */

public class Raichu {

    private static final int MOVEMENT = 140; //скорость райчу
    //private static final int FLY = 15;
    private static final int RIGHT = 300;
    private static final int LEFT = -300;


    private Vector3 position; //храним позицию
    private Vector3 velocity; //храним скорость покемона :)

    private Vector3 right;
    private Vector3 left;
    private Vector3 touchPos;


    private Animation raichuAnimation;
    //private Texture raichu;
    private Texture texture;

    private Rectangle boundsRaichu;

    public Raichu(float x, float y){

        touchPos = new Vector3(0,0,0);

        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);
        right = new Vector3(0,0,0);
        left = new Vector3(0,0,0);

        texture = new Texture("picaR.png");
        raichuAnimation = new Animation(new TextureRegion(texture), 8, 0.5f);

        boundsRaichu =  new Rectangle(position.x, position.y ,
                texture.getWidth()/10, texture.getHeight()-20);
    }

    public void update(float dt, OrthographicCamera camera){

        raichuAnimation.update(dt);

        touchPos.set(Gdx.input.getX(),0,0);
        camera.unproject(touchPos);


        //velocity.add(0, FLY, 0);
        //velocity.scl(dt);
        right.add(RIGHT,0,0);
        right.scl(dt);
        left.add(LEFT,0,0);
        left.scl(dt);
        position.add(0, MOVEMENT*dt ,0);

        boundsRaichu.setPosition(position.x, position.y);

        //мучу передвижуху
        if(touchPos.x < 120){
            position.add(left.x,0,0);
        }
        else {
            position.add(right.x,0,0);
        }
        //конец мучу передвижуху

        if(position.x < 0){
            position.x = 0;
        }
        else if(position.x > 240 - 80){
            position.x = 240 - 80;
        }

        velocity.scl(0);
        right.scl(0);
        left.scl(0);

    }

    public Vector3 getPosition(){
        return position;
    }

    public TextureRegion getRaichu(){
        return raichuAnimation.getFrame();
    }

    public Rectangle getBoundsRaichu(){
        return boundsRaichu;
    }

    public void dispose(){
        texture.dispose();
    }

}
