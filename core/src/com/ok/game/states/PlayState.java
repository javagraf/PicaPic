package com.ok.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.ok.game.PicaPicaMain;
import com.ok.game.sprites.Landslide;
import com.ok.game.sprites.Raichu;
import com.ok.game.sprites.Stone;


/**
 * Created by javagraf on 23.12.2016.
 */
public class PlayState extends State {

    private static final int STONE_COUNT = 4;
    private static final int STONE_SPACING = 130;

    private Raichu raichu;
    private Texture bg;

    private Landslide landslide;

    private Array<Stone> stones;

    public PlayState(GameStateManager gsm) {
        super(gsm);


        camera.setToOrtho(false, PicaPicaMain.WIDTH/2, PicaPicaMain.HEIGHT/2);
        raichu = new Raichu(camera.viewportWidth/2 ,
                camera.viewportHeight/2 + 200);
        //
        landslide = new Landslide(MathUtils.random(0,200), camera.viewportHeight + 1000);
        //
        bg = new Texture("Abg.png");

        ////////////////////////// камни
        stones = new Array<Stone>();
        for (int i = 1; i <= STONE_COUNT; i++){
            stones.add(new Stone( i * (STONE_SPACING+200)));
        }
        //////////////////////////
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

        raichu.update(dt, camera);
        landslide.update(dt);


        camera.position.y = raichu.getPosition().y + 130 ;


        for (int i = 1; i < stones.size; i++){

            Stone stone = stones.get(i);

            if(stone.cross(raichu.getBoundsRaichu())){
                gsm.set(new GameOverState(gsm));
            }
            if(landslide.crossGap(raichu.getBoundsRaichu())){
                gsm.set(new GameOverState(gsm));
            }

            if (camera.position.y - (camera.viewportHeight / 2) > stone.getPosStone().y
                    + stone.getStone().getHeight()){
                stone.repositon(stone.getPosStone().y + (STONE_SPACING) * STONE_COUNT);
            }


        }

        if (camera.position.y - (camera.viewportHeight / 2) > landslide.getPosLandslide().y
                + landslide.getLandslide().getRegionWidth()/4){
            landslide.reposition(camera.position.y + 500);
        }

        camera.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg,0,camera.position.y - camera.viewportHeight/2);
        sb.draw(raichu.getRaichu(), raichu.getPosition().x, raichu.getPosition().y);
        for (Stone stone : stones){
            sb.draw(stone.getStone(),stone.getPosStone().x,stone.getPosStone().y);

        }
        sb.draw(landslide.getLandslide(), landslide.getPosLandslide().x, landslide.getPosLandslide().y);
        sb.end();
    }

    @Override
    public void dispose() {

        bg.dispose();
        raichu.dispose();
        for(Stone stone : stones){
            stone.dispose();
        }

    }

}
