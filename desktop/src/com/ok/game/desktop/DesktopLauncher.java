package com.ok.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ok.game.PicaPicaMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = PicaPicaMain.WIDTH;
		config.height = PicaPicaMain.HEIGHT;
		config.title = PicaPicaMain.TITTLE;

		new LwjglApplication(new PicaPicaMain(), config);
	}
}
