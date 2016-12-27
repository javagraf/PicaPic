package com.ok.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ok.game.PicaPicaMain;


/**
 * Created by javagraf on 24.12.2016.
 */

public class Stone {

    private Texture stone;
    private Vector2 posStone;

    private Rectangle boundsStone;

    public Stone(float y){

        stone = new Texture("rock.png");
        posStone = new Vector2(MathUtils.random(0, PicaPicaMain.WIDTH/2 - stone.getWidth()), y);
        //PicaPicaMain.WIDTH/2 - stone.getWidth()
        boundsStone = new Rectangle(posStone.x, posStone.y, stone.getWidth(), stone.getHeight());
    }

    public void repositon(float y){
        posStone.set(MathUtils.random(0, PicaPicaMain.WIDTH/2 - stone.getWidth()), y);
        boundsStone.setPosition(posStone.x, posStone.y);
    }

    public boolean cross(Rectangle player){
        return boundsStone.overlaps(player) ;
    }

    public Texture getStone(){
        return stone;
    }

    public Vector2 getPosStone(){
        return posStone;
    }

    public void dispose(){
        stone.dispose();
    }
}


