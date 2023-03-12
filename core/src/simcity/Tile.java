package simcity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile {
    private TextureRegion texture;

    public Tile(TextureRegion texture) {
        this.texture = texture;
    }

    public void draw(SpriteBatch batch, int col, int row, int height) {
        float x = (col - row) * (Textures.TILE_SIZE/2);  // Isometric projection
        float y = (col + row) * (Textures.TILE_SIZE/4) + height*Textures.TILE_SIZE/2;
        batch.draw(texture, x, y);
    }
}