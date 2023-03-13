package simcity;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Textures {
    public static final int TILE_SIZE_CUBE = 256;
    public static final int TILE_SIZE_FLOOR_X = 256;
    public static final int TILE_SIZE_FLOOR_Y = 152;

    public static final int SKY_WIDTH = 576;
    public static final int SKY_HEIGHT = 324;

    public static List<TextureRegion> grasses = new ArrayList<TextureRegion>();
    public static List<TextureRegion> waters = new ArrayList<TextureRegion>();
    public static TextureRegion chemin_bois_1;
    public static List<Texture> sky = new ArrayList<Texture>();

    public static void load() {
        // Textures
        for (int i = 1; i <= 4; i++) {
            sky.add(new Texture(Gdx.files.internal(String.format("Sky/Clouds 1/%d.png",i))));
        }

        Texture spriteShTextureCubes = new Texture(Gdx.files.internal("IsometricTilesEtAutre/256x256 Cubes.png"));
        for (int i = 0; i < 10; i++) {
            grasses.add(new TextureRegion(spriteShTextureCubes, i * TILE_SIZE_CUBE, 0 * TILE_SIZE_CUBE, TILE_SIZE_CUBE, TILE_SIZE_CUBE));
        }
        for (int i = 0; i < 10; i++) {      // à changer, toutes les couleurs ne fonctionnent pas m'enfin bon
            waters.add(new TextureRegion(spriteShTextureCubes, i * TILE_SIZE_CUBE, 2 * TILE_SIZE_CUBE, TILE_SIZE_CUBE, TILE_SIZE_CUBE));
        }

        Texture spriteShTextureFloor = new Texture(Gdx.files.internal("assets/IsometricTilesEtAutre/256x152 Floorings.png"));
        chemin_bois_1 = new TextureRegion(spriteShTextureFloor, 0 * TILE_SIZE_FLOOR_X, 0 * TILE_SIZE_FLOOR_Y, TILE_SIZE_FLOOR_X, TILE_SIZE_FLOOR_Y);
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
