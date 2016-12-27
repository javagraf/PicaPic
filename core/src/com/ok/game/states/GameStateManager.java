package com.ok.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by javagraf on 23.12.2016.
 */

public class GameStateManager {

    public Stack<State> states;

    public GameStateManager(){ //конструктор который создает пустой стек
        states = new Stack<State>();
    }

    public void push(State state){ // ложит стек вверх :)
        states.push(state);
    }

    public void pop(State state){ //извлекает стек свверху конечно же :)
        states.pop().dispose();
    }

    public void set(State state){ //удаляет и помещает свой стек вверх
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt){   //возвращяет вверхний элемент не удаляя его из стека
        //обновляя только то состояние, которое находится только
        //на вершине стека
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){ //верхний стек отрисовывает !!!!!
        states.peek().render(sb);
    }

}
