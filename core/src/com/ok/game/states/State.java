package com.ok.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by javagraf on 23.12.2016.
 */

public abstract class State {

    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager gsm; //управляет окнами или состояниями игры

    public State(GameStateManager gsm){

        this.gsm = gsm;
        camera = new OrthographicCamera();
        mouse = new Vector3();

    }

    protected abstract void handleInput(); //пользовательский ввод, были ли нажаты клавиши..
    public abstract void update(float dt); //обновляет картинку через определеный промежутки времени
    public abstract void render(SpriteBatch sb); // рисует
    public abstract void dispose(); // освобождает память


}
