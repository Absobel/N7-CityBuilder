package simcity;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Textures {
    public static final int TILE_SIZE = 256;

    public static List<TextureRegion> grasses = new ArrayList<TextureRegion>();
    public static List<TextureRegion> waters = new ArrayList<TextureRegion>();
    public static Texture sky;

    public static void load() {
        // Textures
        sky = new Texture(Gdx.files.internal("assets/Sky/Clouds 1/1.png"));

        Texture spriteShTexture = new Texture(Gdx.files.internal("assets/IsometricTilesEtAutre/256x256 Cubes.png"));
        for (int i = 0; i < 10; i++) {
            grasses.add(new TextureRegion(spriteShTexture, i * TILE_SIZE, 0 * TILE_SIZE, TILE_SIZE, TILE_SIZE));
        }
        for (int i = 0; i < 10; i++) {      // à changer, toutes les couleurs ne fonctionnent pas m'enfin bon
            waters.add(new TextureRegion(spriteShTexture, i * TILE_SIZE, 2 * TILE_SIZE, TILE_SIZE, TILE_SIZE));
        }
    }

    public static void dispose() {
        sky.dispose();
        for (TextureRegion grass : grasses) {
            grass.getTexture().dispose();
        }
        for (TextureRegion water : waters) {
            water.getTexture().dispose();
        }
    }
}
