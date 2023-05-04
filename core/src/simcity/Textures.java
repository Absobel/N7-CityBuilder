package simcity;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Classe qui contient toutes les textures du jeu, à améliorer pour la performance même si pour l'instant osef un peu
 */
public class Textures {
    public static final int TILE_SIZE_CUBE = 256;
    public static final int TILE_SIZE_FLOOR_X = 256;
    public static final int TILE_SIZE_FLOOR_Y = 152;

    public static final int SKY_WIDTH = 576;
    public static final int SKY_HEIGHT = 324;

    public static List<TextureRegion> grasses = new ArrayList<TextureRegion>();
    public static List<TextureRegion> waters = new ArrayList<TextureRegion>();
    public static TextureRegion chemin_bois_1;
    public static List<TextureRegion> tonneaux = new ArrayList<TextureRegion>();
    public static List<TextureRegion> a_suppr = new ArrayList<TextureRegion>();
    public static List<Texture> sky = new ArrayList<Texture>();
    public static TextureRegion road;

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

        Texture spriteShTextureFloor = new Texture(Gdx.files.internal("IsometricTilesEtAutre/256x152 Floorings.png"));
        chemin_bois_1 = new TextureRegion(spriteShTextureFloor, 0 * TILE_SIZE_FLOOR_X, 0 * TILE_SIZE_FLOOR_Y, TILE_SIZE_FLOOR_X, TILE_SIZE_FLOOR_Y);

        Texture spriteShTextureTonneaux = new Texture(Gdx.files.internal("IsometricTilesEtAutre/256x256 Objects.png"));
        for (int i = 0; i < 2; i++) {
            tonneaux.add(new TextureRegion(spriteShTextureTonneaux, i+6 * TILE_SIZE_CUBE, 0 * TILE_SIZE_CUBE, TILE_SIZE_CUBE, TILE_SIZE_CUBE));
        }

        Texture spriteShTextureASuppr = new Texture(Gdx.files.internal("IsometricTilesEtAutre/256x512 Trees.png"));
        for (int i = 0; i < 24; i++) {
            a_suppr.add(new TextureRegion(spriteShTextureASuppr, i%6 * TILE_SIZE_CUBE, ((int) i/6 )* TILE_SIZE_CUBE, TILE_SIZE_CUBE, TILE_SIZE_CUBE));
        }

        Texture spriteRoad = new Texture(Gdx.files.internal("IsometricTilesEtAutre/256x256 route.png"));
        road = new TextureRegion(spriteRoad);
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
        road.getTexture().dispose();
    }
}
