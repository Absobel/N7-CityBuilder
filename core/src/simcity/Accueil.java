package simcity;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HexFormat;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


import simcity.Isometric;

public class Accueil extends ScreenAdapter {

    public static final int WIDTH = 320*4;   // 16:9 aspect ratio 
    public static final int HEIGHT = 180*4;

    private SpriteBatch batch;
    private Texture menuTexture;
    private boolean touchejouer;
    private InputHandler inputHandler;
    private OrthographicCamera camera;
    private IsometricRenderer renderer;
    private Viewport viewport;
    private TextButton quitterButton;
    private TextButton jouerButton;
    private TextButton nouvelleButton;
    private Stage stageboutton;
    private Music musiq;
    

    private Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    
    public Accueil(SpriteBatch batch, Boolean dedans) {
        this.batch = batch;
        this.touchejouer = false; // permet de savoir si on appuie sur la touche joueur



    }
    
    @Override
    public void show() {

        Isometric essai = new Isometric();

        camera = new OrthographicCamera(WIDTH, HEIGHT);

 
        camera.zoom = 1f;

        viewport = new FitViewport(WIDTH, HEIGHT, camera);

        renderer = new IsometricRenderer();
        menuTexture = new Texture(Gdx.files.internal("image-18-1024x585.png"));
        inputHandler = new InputHandler(camera, renderer.getGrid(), true);
        stageboutton = new Stage(viewport, batch);

        quitterButton = new TextButton("Quitter", skin);
        quitterButton.setPosition(700, 100);
        quitterButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});

        stageboutton.addActor(quitterButton);

        jouerButton = new TextButton("Jouer", skin);
        jouerButton.setPosition(700, 300);
        jouerButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
                touchejouer = true; //parvient pas a mettre this.touchejouer = false;
			}
		});
        stageboutton.addActor(jouerButton);

        nouvelleButton = new TextButton("Nouvelle partie", skin);
        nouvelleButton.setPosition(700, 200);
        nouvelleButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				touchejouer = true;
			}
		});

        stageboutton.addActor(nouvelleButton);

        Gdx.input.setInputProcessor(stageboutton);   
        
        //musique
        AssetManager assetManager = new AssetManager();

        assetManager.load("Joueur du Grenier - Recette pour jeu pourri.mp3", Music.class);
        assetManager.finishLoading();
        this.musiq = assetManager.get("Joueur du Grenier - Recette pour jeu pourri.mp3", Music.class);
        this.musiq.setLooping(true);
        this.musiq.play();
    }
    
    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(viewport.getCamera().combined); // utiliser la deuxième caméra pour dessiner l'image


        batch.begin();
        

        batch.draw(menuTexture, 0 , 0, WIDTH, HEIGHT);
        batch.end();

        inputHandler.handleInput(Gdx.graphics.getDeltaTime(), this.touchejouer); // bool rajouté pour écran d'accueil
        stageboutton.act();
        stageboutton.draw();
    }
    

    @Override
    public void dispose() {
        batch.dispose();
        menuTexture.dispose();
    }
    
    @Override
    public void resize(int width, int height) {    // Called when the Application is resized.
    }
    
    @Override
    public void pause() {}
    
    @Override
    public void resume() {}
    
    @Override
    public void hide() {
        musiq.stop();
    }


    public boolean getEtat() { // recuperer dans les autres classes la valeure
        return touchejouer;
    }

    public void setEtat(boolean etat) { // pouvoir mettre en vrai ou faux directmenet modifiabme par isomteric
            touchejouer = etat;

    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public void setBooldeInput(InputHandler inputHandler ,boolean bool) {
        inputHandler.setBoolean(bool);
    }

    public TextButton getbutton(String nom) {
        if (nom == "quitter") {
            return quitterButton;
        }
        else if (nom == "jouer") {
            return jouerButton;
        }
        else {
            return null;
        }
    }


    
}
    
