package com.ok.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ok.game.PicaPicaMain;


/**
 * Created by javagraf on 26.12.2016.
 */

public class GameOverState extends State {

    private Texture bg;
    private Texture playBtn;

    public GameOverState(GameStateManager gsm) {
        super(gsm);

        camera.setToOrtho(false, PicaPicaMain.WIDTH/2, PicaPicaMain.HEIGHT/2);
        bg = new Texture("Abg.png");
        playBtn = new Texture("GO.png");


    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) gsm.set(new MenuState(gsm));
    }


    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg,0,0);
        sb.draw(playBtn, camera.position.x - playBtn.getWidth()/2,
                camera.position.y - playBtn.getHeight()/2);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
