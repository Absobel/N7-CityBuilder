package simcity;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.AddListenerAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.net.http.WebSocket.Listener;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;

/**
 * Classe principale du jeu
 */
public class Isometric extends Game {
	private SpriteBatch batch;
	private GameScreen gameScreen;
	private Accueil accueil;

	@Override
	public void create() {   // Called when the Application is first created.
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		batch = new SpriteBatch();
		gameScreen = new GameScreen(batch, false); // faire d'abord appel à écran d'accueil.
		//setScreen(gameScreen);
		accueil = new Accueil(batch, false);
		setScreen(accueil);
	

	}
		

	public void commencerJeu() {
	    setScreen(gameScreen);
		gameScreen.setEstdansGame(true); // on est dans le jeu
	}

	public void retourAccueil() {
		setScreen(accueil);
		Accueil.MUSIQUE.changerMusique();
		gameScreen.setEstdansGame(false); // on est dans l'accueil
	}

	public void retourJeu() {
		gameScreen.show();
		gameScreen.setEstdansGame(true); // on est dans le jeu
	}
	@Override
	public void render() {   // Called several times per second. Updates and renders the game.

		super.render(); // le faire seulement ici pour pas forcer le rendu à chaque fois		
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || accueil.getEtat() == true ) {
            if (!gameScreen.getEstdansGame()) {
                setScreen(gameScreen);
                gameScreen.setEstdansGame(true);
				accueil.setEtat(false);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE) ) {

            if (gameScreen.getEstdansGame()) {
                setScreen(accueil);
                gameScreen.setEstdansGame(false); }
        }			

	}
	
	@Override
	public void dispose() {   // Called when the Application is destroyed.
		batch.dispose();
	}


}