package simcity;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Textures {
    public static final int TILE_SIZE = 256;

    public static final int SKY_WIDTH = 576;
    public static final int SKY_HEIGHT = 324;

    public static List<TextureRegion> grasses = new ArrayList<TextureRegion>();
    public static List<TextureRegion> waters = new ArrayList<TextureRegion>();
    public static List<Texture> sky = new ArrayList<Texture>();

    public static void load() {
        // Textures
        for (int i = 1; i <= 4; i++) {
            sky.add(new Texture(Gdx.files.internal(String.format("assets/Sky/Clouds 1/%d.png",i))));
        }

        Texture spriteShTexture = new Texture(Gdx.files.internal("assets/IsometricTilesEtAutre/256x256 Cubes.png"));
        for (int i = 0; i < 10; i++) {
            grasses.add(new TextureRegion(spriteShTexture, i * TILE_SIZE, 0 * TILE_SIZE, TILE_SIZE, TILE_SIZE));
        }
        for (int i = 0; i < 10; i++) {      // à changer, toutes les couleurs ne fonctionnent pas m'enfin bon
            waters.add(new TextureRegion(spriteShTexture, i * TILE_SIZE, 2 * TILE_SIZE, TILE_SIZE, TILE_SIZE));
        }
    }

    public static void dispose() {
        for (Texture skyPart : sky) {
            skyPart.dispose();
        }
        for (TextureRegion grass : grasses) {
            grass.getTexture().dispose();
        }
        for (TextureRegion water : waters) {
            water.getTexture().dispose();
        }
    }
}
