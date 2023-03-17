package simcity;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Gère les entrées de l'utilisateur
 */
public class InputHandler {
    public static final float BASE_CAMERA_SPEED = 7f;
    public static final float CAMERA_ZOOM_SPEED = 0.04f;

    private OrthographicCamera camera;
    private Grid grid;

    public InputHandler(OrthographicCamera camera, Grid grid) {
        this.camera = camera;
        this.grid = grid;
    }

    public void handleInput(float delta) {
        // Camera movement
        float actualCameraSpeed = BASE_CAMERA_SPEED * camera.zoom;  // Calcul de la vitesse de la caméra en fonction du zoom
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            camera.translate(0, actualCameraSpeed);
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            camera.translate(0, -actualCameraSpeed);
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            camera.translate(-actualCameraSpeed, 0);
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            camera.translate(actualCameraSpeed, 0);
        }
        
        // Camera zoom
        if (Gdx.input.isKeyPressed(Keys.Q)) {  // Zoom in
            camera.zoom -= CAMERA_ZOOM_SPEED;               //La vraie touche c'est A parce que QWERTY
        }
        if (Gdx.input.isKeyPressed(Keys.E)) {  // Zoom out
            camera.zoom += CAMERA_ZOOM_SPEED;
        }

        // place tiles
        if (Gdx.input.isTouched()) {
            // Coordonnées de la souris sur l'écran
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            // Permet de passer en coordonées absolues 
            Vector3 abs = camera.unproject(new Vector3(x, y, 0));

            // Permet de passer en coordonées isométriques puis cast pour avoir les coordonnées de la case
            Vector2 iso = Grid.coordAbsToIso(new Vector2(abs.x, abs.y));
            int col = (int) iso.x;
            int row = (int) iso.y;


            // Pour l'instant c'est juste pour tester le placement de tuiles, à termes il faudra faire un système de sélection de tuiles avec un menu et tout
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                Random rand = new java.util.Random();
                grid.setTile(new Tile(Textures.waters.get(rand.nextInt(Textures.waters.size()))), col, row, 1);
            } else {
                grid.setTile(null, col, row, 1);
            }
        }
    }
}
