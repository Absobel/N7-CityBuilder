package simcity;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class IsometricRenderer {
    public static final int GRID_WIDTH = 16;
    public static final int GRID_HEIGHT = 16;
    public static final int GRID_DEPTH = 2;

    private Grid grid;

    public IsometricRenderer() {
        Textures.load();

        // Generate random ground texture grid
        grid = new Grid(GRID_WIDTH, GRID_HEIGHT, GRID_DEPTH);
        Random rand = new Random();
        for (int row = 0; row < GRID_HEIGHT; row++) {
            for (int col = 0; col < GRID_WIDTH; col++) {
                int index1 = rand.nextInt(Textures.grasses.size());
                grid.setTile(new Tile(Textures.grasses.get(index1)), col, row, 0);
            }
        }
    }

    public void draw(SpriteBatch batch) {
        grid.draw(batch);
    }

    public void dispose() {
        Textures.dispose();
    }

    // Getters
    public Grid getGrid() {
        return grid;
    }
}
