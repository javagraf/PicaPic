package com.ok.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by javagraf on 23.12.2016.
 */

public class Animation {

    private Array<TextureRegion> frames; //массив текстур который будет хранить кадры анимации
    private float maxFrameTime;  //максимальная длительностоь одного кадра
    private float currentFrameTime; //время отображения текущего кадра
    private int frameCount; //количество кадров анимации
    private int frame; //отдельный кадр анимации

    //float cycleTime - длительность цикла анимации

    public Animation(TextureRegion region, int frameCount, float cycleTime){

        frames = new Array<TextureRegion>(); //создаем массив текстур
        //далее задаем ширину текстуры
        //для этого делим всю ширину спрайта на количество кадров
        int frameWidth = region.getRegionWidth() / frameCount;

        //далее в цикле перебираем кадры спрайта поочереди используя их
        for (int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;

        maxFrameTime = cycleTime / frameCount; //определяем максимальную длительность 1 кадра
        frame = 0;
    }

    public void update(float dt){
        currentFrameTime  += dt;
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if(frame >= frameCount) frame = 0; //создаем некий круг

    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }

}
