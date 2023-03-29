package simcity;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.actions.AddListenerAction;

import java.net.http.WebSocket.Listener;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * Classe principale du jeu
 */
public class Isometric extends Game {
	SpriteBatch batch;
	private GameScreen gameScreen;
	private Accueil accueil;

	@Override
	public void create() {   // Called when the Application is first created.
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
		batch = new SpriteBatch();
		gameScreen = new GameScreen(batch); // faire d'abord appel à écran d'accueil.
		//setScreen(gameScreen);
		accueil = new Accueil(batch, true);
		setScreen(accueil);
		if (accueil.getEtat() == false) {
			commencerJeu();
		}
	}

	public void commencerJeu() {
		accueil.hide();
		setScreen(gameScreen);
	}


	@Override
	public void render() {   // Called several times per second. Updates and renders the game.
		super.render();
	}
	
	@Override
	public void dispose() {   // Called when the Application is destroyed.
		batch.dispose();
	}
}