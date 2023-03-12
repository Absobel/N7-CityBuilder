package simcity;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {
    public static final int WIDTH = 320*4;   // 16:9 aspect ratio 
    public static final int HEIGHT = 180*4;

    private SpriteBatch batch;
    private Viewport viewport;

    private OrthographicCamera camera;
    private IsometricRenderer renderer;
    private InputHandler inputHandler;

    public GameScreen(SpriteBatch batch) {
        this.batch = batch;
    }

    @Override
    public void show() {    // Called when this screen becomes the current screen for a Game.
        camera = new OrthographicCamera(WIDTH, HEIGHT);
        camera.position.set(WIDTH/2, HEIGHT/2, 0);
        camera.zoom = 4f;

        viewport = new FitViewport(WIDTH, HEIGHT, camera);

        renderer = new IsometricRenderer();
        inputHandler = new InputHandler(camera, renderer.getGrid());
    }

    @Override
    public void resize(int width, int height) {    // Called when the Application is resized.
        viewport.update(width, height);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);    // Set the clear color to black.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);   // Clear the screen.
        batch.setProjectionMatrix(viewport.getCamera().combined);  

        camera.update();
        inputHandler.handleInput();

        batch.begin();
        int effectiveScreenWidth = (int) Math.floor(WIDTH*camera.zoom) + 100;
        int effectiveScreenHeight = (int) Math.floor(HEIGHT*camera.zoom) + 100;
        // bug quand on bouge la camera y'a un offeset d'un pixel qui se rajoute je sais pas pourquoi
        for (Texture skyPart : Textures.sky) {
            batch.draw(skyPart, camera.position.x-effectiveScreenWidth/2, camera.position.y-effectiveScreenHeight/2, effectiveScreenWidth, effectiveScreenHeight);
        }
        renderer.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {    // Called when this screen should release all resources.
        renderer.dispose();
    }
}
