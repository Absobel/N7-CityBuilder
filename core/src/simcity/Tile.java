package simcity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


/**
 * Définition et methodes d'une tuile
 */
public class Tile {
    private TextureRegion texture;

    public Tile(TextureRegion texture) {
        this.texture = texture;
    }

    public void draw(SpriteBatch batch, int col, int row, int height) {
        float x = (col - row) * (Textures.TILE_SIZE_CUBE/2);  // Isometric projection
        float y = (col + row) * (Textures.TILE_SIZE_CUBE/4) + height*Textures.TILE_SIZE_CUBE/2;
        batch.draw(texture, x, y);
    }
}