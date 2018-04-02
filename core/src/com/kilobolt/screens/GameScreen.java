package com.kilobolt.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.kilobolt.gameworld.GameRenderer;
import com.kilobolt.gameworld.GameWorld;
import com.kilobolt.zbHelpers.InputHandler;

public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;

    private float runTime = 0;

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) (gameHeight / 2);
        world = new GameWorld(midPointY);    //inicializo world
        renderer = new GameRenderer(world, (int) gameHeight, midPointY);  //inicializo renderer

        Gdx.input.setInputProcessor(new InputHandler(world));

        /*
        //Notice that we are calling the constructor, passing in a reference to our Bird object that we retrieve from World. This is just a simplification of the following:

        Bird bird = world.getBird();
        InputHandler handler = new InputHandler(bird);
        Gdx.input.setInputProcessor(handler);

         */
    }
    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void render(float delta) {
        // Covert Frame rate to String, print it
        Gdx.app.log("GameScreen FPS", (1/delta) + "");
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
