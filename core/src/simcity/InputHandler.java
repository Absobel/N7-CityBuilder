package simcity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class InputHandler {
    public static final float CAMERA_SPEED = 10f;
    public static final float CAMERA_ZOOM_SPEED = 0.02f;

    private OrthographicCamera camera;
    private Grid grid;

    public InputHandler(OrthographicCamera camera, Grid grid) {
        this.camera = camera;
        this.grid = grid;
    }

    public void handleInput() {
        // Camera movement
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            camera.translate(0, CAMERA_SPEED);
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            camera.translate(0, -CAMERA_SPEED);
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            camera.translate(-CAMERA_SPEED, 0);
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            camera.translate(CAMERA_SPEED, 0);
        }
        
        // Camera zoom
        if (Gdx.input.isKeyPressed(Keys.Q)) {  // Zoom in
            camera.zoom -= CAMERA_ZOOM_SPEED;               //La vraie touche c'est A parce que QWERTY
        }
        if (Gdx.input.isKeyPressed(Keys.E)) {  // Zoom out
            camera.zoom += CAMERA_ZOOM_SPEED;               //La vraie touche c'est Z parce que QWERTY
        }

        // place tiles
        if (Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            grid.placeTile(new Tile(Textures.waters.get(0)), x, y);        // Pour tester mais à terme on placera d'autres trucs
        }
    }
}
