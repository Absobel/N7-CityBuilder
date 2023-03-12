package simcity;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Isometric extends Game {
	SpriteBatch batch;
	private GameScreen gameScreen;

	@Override
	public void create () {   // Called when the Application is first created.
		batch = new SpriteBatch();
		gameScreen = new GameScreen(batch);
	}


	@Override
	public void render () {   // Called several times per second. Updates and renders the game.
		super.render();
	}
	
	@Override
	public void dispose () {   // Called when the Application is destroyed.
		batch.dispose();
	}
}