package com.ok.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ok.game.PicaPicaMain;

/**
 * Created by javagraf on 23.12.2016.
 */

public class MenuState extends State {

    private Texture bg;
    private Texture playBtn;


    public MenuState(final GameStateManager gsm) {
        super(gsm);


        camera.setToOrtho(false, PicaPicaMain.WIDTH/2, PicaPicaMain.HEIGHT/2);
        bg = new Texture("Abg.png");
        playBtn =  new Texture("playbtn.png");


    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) gsm.set(new PlayState(gsm));
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

/*
public class MenuState extends State {

    private Texture bg;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, PicaPicaMain.WIDTH/2, PicaPicaMain.HEIGHT/2);
        bg = new Texture("bg.png");
        playBtn =  new Texture("playbtn.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) gsm.set(new PlayState(gsm));
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

     /////////////////////// делаю кнопку
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        image = new Image(new Texture(Gdx.files.internal("playbtn.png")));
        image.setPosition(camera.viewportWidth/2 - image.getWidth()/2, camera.viewportHeight/2 - image.getHeight()/2);


        stage.addActor(image);

        image.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set(new PlayState(gsm));
            }
        });
        /////////////////////// конец делания кнопки

}*/


