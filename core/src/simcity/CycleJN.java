package simcity;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class CycleJN {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private TextureRegion baseTextureRegion;
    private TextureRegion tintedTextureRegion;
    private float time;
    private float cycleDuration;
    private Color tint;
    private List<Texture> sky;

    public CycleJN(SpriteBatch batch, OrthographicCamera camera, List<Texture> skyList, float cycleDuration) {
        this.batch = batch;
        this.camera = camera;
        this.sky = skyList;
        this.cycleDuration = cycleDuration;
        this.tint = new Color(1, 1, 1, 1);
    }

    public void update(float delta) {
        time += delta;
        float progress = time / cycleDuration;

        // Calculate the hue based on the progress of the cycle (0-1)
        float hue = MathUtils.lerp(0.66f, 0, progress);

        // Set the tint color based on the hue
        tint.set(Color.WHITE);
        tint.fromHsv(hue, 0.5f, 1.0f);

        // Create a new texture region with the tint applied
        tintedTextureRegion = new TextureRegion(baseTextureRegion);
        tintedTextureRegion.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        // fais un pixmap en fonction du batch
        Pixmap pixmap = new Pixmap(baseTextureRegion.getTexture().getWidth(), baseTextureRegion.getTexture().getHeight(), Pixmap.Format.RGBA8888);
        // dessine le pixmap avec la couleur
        pixmap.setColor(tint);
        pixmap.fill();
        // applique le pixmap sur la texture
        tintedTextureRegion.getTexture().draw(pixmap, 0, 0);
        // libère la mémoire
        pixmap.dispose();
        
    }

    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(tintedTextureRegion, 0, 0);
        batch.end();
    }
}