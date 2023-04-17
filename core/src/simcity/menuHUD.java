package simcity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

public class menuHUD extends Stage{

    private Stage sousmenu;
    private TextButton menu;
    private Table table;
    private Label titleLabel;
    private BitmapFont font;
    private Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

    public menuHUD(Viewport viewport, SpriteBatch batch) {
        Gdx.input.setInputProcessor(this);  // Active la scène pour récupérer les événements d'entrée

        // Création de la table qui contiendra les boutons
        table = new Table();
        table.setFillParent(true);
        table.bottom();
        table.right();
        this.addActor(table);

        // Ajout du titre
        menu = new TextButton("Menu", skin);
        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                show();
            }
        });

        // Création d'une nouvelle instance de BitmapFont avec une taille de police plus petite
        BitmapFont smallFont = new BitmapFont(Gdx.files.internal("font/font.fnt"));
        smallFont.getData().setScale(0.5f);

        // Ajout des boutons
        TextButton resumeButton = new TextButton("Resume", new TextButton.TextButtonStyle(skin.getDrawable("button-up"), skin.getDrawable("button-down"), skin.getDrawable("button-down"), smallFont));
        TextButton restartButton = new TextButton("Restart", new TextButton.TextButtonStyle(skin.getDrawable("button-up"), skin.getDrawable("button-down"), skin.getDrawable("button-down"), smallFont));
        TextButton quitButton = new TextButton("Quit", new TextButton.TextButtonStyle(skin.getDrawable("button-up"), skin.getDrawable("button-down"), skin.getDrawable("button-down"), smallFont));

        // Ajout d'un listener pour chaque bouton
        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Code pour reprendre le jeu
            }
        });

        restartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Code pour redémarrer le jeu
            }
        });

        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Code pour quitter le jeu
            }
        });

        // Ajout des boutons à la table
        table.add(menu).padTop(20f).row();
        table.add(resumeButton).height(20f).padTop(50f).row();
        table.add(restartButton).height(20f).padTop(20f).row();
        table.add(quitButton).height(20f).padTop(20f).row();
    }

    public void show() {
        Gdx.input.setInputProcessor(this);  // Active la scène pour récupérer les événements d'entrée
    }

    public void hide() {
        Gdx.input.setInputProcessor(null);  // Désactive la scène pour ne plus récupérer les événements d'entrée
    }

    public void render() {
        this.act();
        this.draw();
    }

    public void dispose() {
        this.dispose();
    }
}
