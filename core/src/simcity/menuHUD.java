package simcity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

public class menuHUD extends Stage {

    //private Boolean amodifier = false;
    private Stage sousmenu;
    private TextButton menu;
    private Table table;
    private Table sousmenuTable;  // Nouvelle table pour les boutons du sous-menu
    private Label titleLabel;
    private BitmapFont font;
    private Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    private Table menubat; 

    public menuHUD(final Viewport viewport, final SpriteBatch batch) {
        Gdx.input.setInputProcessor(this);  // Active la scène pour récupérer les événements d'entrée

        // Création de la table qui contiendra les boutons du menu principal
        table = new Table();
        table.setFillParent(true);
        table.bottom();
        table.left();
        this.addActor(table);

        // Création de la table qui contiendra les boutons du sous-menu
        sousmenuTable = new Table();
        sousmenuTable.setFillParent(true);
        sousmenuTable.left();  // Alignement des boutons au centre de l'écran
        sousmenuTable.bottom();
        sousmenuTable.setVisible(false);  // Les boutons ne sont pas visibles au début
        this.addActor(sousmenuTable);

         // Création de la table qui contiendra les boutons du sous-menu batiments
         menubat =new Table();
         menubat.setFillParent(true);
         menubat.left();  // Alignement des boutons au centre de l'écran
         menubat.bottom();
         menubat.setVisible(false);  // Les boutons ne sont pas visibles au début
         menubat.setName("menubat");
         sousmenuTable.addActor(menubat);

        // Ajout du titre
        menu = new TextButton("Menu", skin);
        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showmenu();  // Afficher les boutons du sous-menu
            }
        });

        // Ajout des boutons du sous-menu
        TextButton stage1Button = new TextButton("batiments", skin);
        TextButton stage2Button = new TextButton("decoration", skin);
        TextButton stage3Button = new TextButton("sauvegarde", skin);
        TextButton stage4Button = new TextButton("accueil", skin);

        TextButton backButton = new TextButton("Back", skin);

        // Ajout d'un listener pour chaque bouton du sous-menu
        stage1Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showbat();  // Afficher les boutons du sous-menu bat;
            }
        });

        stage2Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                
            }
        });

        stage3Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Sauvegarde");
            }
        });

        stage4Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Isometric isometric = (Isometric) Gdx.app.getApplicationListener(); // ca marche j'ai peur que si on ajout un mute qu'on le perde a chaque retour
                isometric.retourAccueil();
                
            }
        });

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hidemenu();  // Cacher les boutons du sous-menu
            }
        });



        // Ajout des boutons à la table du sous-menu
        sousmenuTable.add(stage1Button).padTop(50f).row();
        sousmenuTable.add(stage2Button).padTop(20f).row();
        sousmenuTable.add(stage3Button).padTop(20f).row();
        sousmenuTable.add(stage4Button).padTop(20f).row();
        sousmenuTable.add(backButton).padTop(20f).row();
        

        // Ajout des boutons du sous-menu
        TextButton servpub = new TextButton("service pub", skin);
        TextButton habitations = new TextButton("habitations", skin);
        TextButton autres = new TextButton("autres", skin);

        TextButton retour = new TextButton("retour", skin);

        servpub.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("service pub");
            }
        });

        servpub.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("service pub");
            }
        });

        habitations.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("habitations");
            }
        });

        autres.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("autres");
            }
        });

        retour.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hidebat();  // Cacher les boutons du sous-menubat
            }
        });



        // Ajout des boutons à la table du sous-menubat
        menubat.add(servpub).padTop(50f).row();
        menubat.add(habitations).padTop(20f).row();
        menubat.add(autres).padTop(20f).row();

        menubat.add(retour).padTop(20f).row();

        // Ajout du bouton menu à la table du menu principal
        table.add(menu).padTop(20f).row();
    
    }

    public void showmenu() {
        sousmenuTable.setVisible(true);  // Rendre les boutons du sous-menu visibles
        table.setVisible(false);  // Cacher les boutons du menu principal

    }

    public void hidemenu() {
        sousmenuTable.setVisible(false);  // Cacher les boutons du sous-menu
        table.setVisible(true); 
    }

    public void showbat() {

        sousmenuTable.setVisible(false);
        table.setVisible(false);
        System.out.println("showbat");
        menubat.setVisible(true);
        System.out.println("showbat2" + menubat);
    }

    public void hidebat() {
        sousmenuTable.setVisible(true);
        table.setVisible(false);
        menubat.setVisible(false);
    }

    public void dispose() {
        sousmenu.dispose();
        this.dispose();
    }

    

}
