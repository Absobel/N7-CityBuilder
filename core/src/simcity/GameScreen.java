package simcity;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


/**
 * L'écran principal du jeu.
 */
public class GameScreen extends ScreenAdapter {
    public static final int WIDTH = 320*4;   // 16:9 aspect ratio 
    public static final int HEIGHT = 180*4;

    private SpriteBatch batch;
    private Viewport viewport;
    private Stage hudStage;
    private Music musiq;
  //  private Label labell;

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
        //Nouveau stage
        hudStage = new Stage(new ScreenViewport(), batch);

        //la musique
        AssetManager assetManager = new AssetManager();

        assetManager.load("musique_chill.mp3", Music.class);
        assetManager.finishLoading();
        this.musiq = assetManager.get("musique_chill.mp3", Music.class);
        this.musiq.setLooping(true);
        this.musiq.play();
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



        batch.begin();
        int effectiveScreenWidth = (int) Math.floor(WIDTH*camera.zoom) + 100;  // Add 100 to avoid black borders
        int effectiveScreenHeight = (int) Math.floor(HEIGHT*camera.zoom) + 100;
        for (Texture skyPart : Textures.sky) {
            batch.draw(skyPart, camera.position.x-effectiveScreenWidth/2, camera.position.y-effectiveScreenHeight/2, effectiveScreenWidth, effectiveScreenHeight);
        }
        renderer.draw(batch);
        batch.end();

        inputHandler.handleInput(Gdx.graphics.getDeltaTime());
        camera.update();
        
        //MAJ du HUD
        hudStage.act(delta);
    }

    @Override
    public void dispose() {    // Called when this screen should release all resources.
        renderer.dispose();
        musiq.dispose();
//        hudStage.dispose();
    }

}
