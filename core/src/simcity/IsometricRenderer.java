package simcity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class IsometricRenderer {
    public static final int TILE_WIDTH = 256;
    public static final int TILE_HEIGHT = 256;

    private Texture grass;
    private Texture sky;
    
    public IsometricRenderer() {
        Texture spriteShTexture = new Texture(Gdx.files.internal("assets/IsometricTilesEtAutre/256x256 Cubes.png"));
        grass = new TextureRegion(spriteShTexture, 0, 0, 256, 256).getTexture();
        sky = new Texture(Gdx.files.internal("assets/Sky/Clouds 1/1.png"));
    }

    public void drawGround(SpriteBatch batch) {
        for (int row = 15; row >= 0; row--) {          // à changer en 2D array avec enum, là c'est juste pour le test
            for (int col = 15; col >= 0; col--) {
                float x = (col - row) * (TILE_WIDTH/2);    // Permet d'afficher une grille de manière isométrique
                float y = (col + row) * (TILE_HEIGHT/2);
                batch.draw(grass, x, y, TILE_WIDTH, TILE_HEIGHT);
            }
        }
    }
}
