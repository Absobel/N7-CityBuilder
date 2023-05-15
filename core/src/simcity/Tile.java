package simcity;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.files.FileHandle;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Tile implements Serializable {
    private transient TextureRegion texture;  // transient means it won't be serialized
    private String textureData;

    public Tile(TextureRegion texture) {
        this.texture = texture;
    }

    public void draw(SpriteBatch batch, int col, int row, int height) {
        float x = (col - row) * (Textures.TILE_SIZE_CUBE/2);  // Isometric projection
        float y = (col + row) * (Textures.TILE_SIZE_CUBE/4) + height*Textures.TILE_SIZE_CUBE/2;
        batch.draw(texture, x, y);
    }

    @Override
    public void write(Json json) {
        Pixmap pixmap = texture.getTexture().getTextureData().consumePixmap();
        FileHandle file = new FileHandle(new File("temp.png"));
        PixmapIO.writePNG(file, pixmap);
        pixmap.dispose();

        try {
            BufferedImage bufferedImage = ImageIO.read(file.file());
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteOut);
            byteOut.flush();
            textureData = Base64.getEncoder().encodeToString(byteOut.toByteArray());
            byteOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        file.delete();
        json.writeValue("textureData", textureData);
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        textureData = jsonData.getString("textureData");
        try {
            byte[] bytes = Base64.getDecoder().decode(textureData);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
            BufferedImage bufferedImage = ImageIO.read(byteIn);
            byteIn.close();
    
            FileHandle file = new FileHandle(new File("temp.png"));
            ImageIO.write(bufferedImage, "png", file.file());
    
            Pixmap pixmap = new Pixmap(file);
            texture = new TextureRegion(new Texture(pixmap));
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
