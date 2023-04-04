package simcity;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Accueil extends ScreenAdapter{

    public static final int WIDTH = 320*4;   // 16:9 aspect ratio 
    public static final int HEIGHT = 180*4;

    private SpriteBatch batch;
    private Texture menuTexture;
    private boolean dansecranaccueil;
    private InputHandler inputHandler;
    private OrthographicCamera camera;
    private IsometricRenderer renderer;
    private Viewport viewport;
    
    public Accueil(SpriteBatch batch, Boolean dedans) {
        this.batch = batch;
        this.dansecranaccueil = dedans;
    }
    
    @Override
    public void show() {
        camera = new OrthographicCamera(WIDTH, HEIGHT);
        camera.position.set(WIDTH/2, HEIGHT/2, 0);
        camera.zoom = 4f;

        viewport = new FitViewport(WIDTH, HEIGHT, camera);

        renderer = new IsometricRenderer();
        menuTexture = new Texture(Gdx.files.internal("image-18-1024x585.png"));
        inputHandler = new InputHandler(camera, renderer.getGrid(), true);
    }
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        batch.draw(menuTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        inputHandler.handleInput(Gdx.graphics.getDeltaTime(), this.dansecranaccueil); // bool rajouté pour écran d'accueil
        //this.dansecranaccueil = inputHandler.getBoolean();
        //inputHandler.setBoolean(true);
    }
    
    @Override
    public void dispose() {
        batch.dispose();
        menuTexture.dispose();
    }
    
    @Override
    public void resize(int width, int height) {}
    
    @Override
    public void pause() {}
    
    @Override
    public void resume() {}
    
    @Override
    public void hide() { // pour pouvoir revenir si c'est demandé
       // this.dansecranaccueil = false;
    }

    public boolean getEtat() { // recuperer dans les autres classes la valeure
        return this.dansecranaccueil;
    }

    public void setEtat(boolean etat) { // pouvoir mettre en vrai ou faux directmenet modifiabme par isomteric
            this.dansecranaccueil = etat;

    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public void setBooldeInput(InputHandler inputHandler ,boolean bool) {
        inputHandler.setBoolean(bool);
    }


    
}
    
