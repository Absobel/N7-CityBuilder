package simcity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
    private Table service;
    private Gestion gestion;

    public menuHUD(final Viewport viewport, final SpriteBatch batch) {

        gestion = new Gestion(); 
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
         this.addActor(menubat);

        // Création de la table qui contiendra les boutons du sous-menu batiments
        service = new Table();
        service.setFillParent(true);
        service.left();  // Alignement des boutons au centre de l'écran
        service.bottom();
        service.setVisible(false);  // Les boutons ne sont pas visibles au début
        service.setName("service");
        this.addActor(service);

        // Ajout du titre
        menu = new TextButton("Menu", skin);
        menu.getLabel().setFontScale(0.5f);
        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showmenu();  // Afficher les boutons du sous-menu
            }
        });

        // Ajout des boutons du sous-menu
        TextButton batimentsButton = new TextButton("batiments", skin);
        batimentsButton.getLabel().setFontScale(0.5f);
        
        TextButton decora = new TextButton("decoration", skin);

        decora.getLabel().setFontScale(0.5f);
        TextButton sauvegarde = new TextButton("sauvegarde", skin);

        sauvegarde.getLabel().setFontScale(0.5f);
        TextButton accueil = new TextButton("accueil", skin);

        accueil.getLabel().setFontScale(0.5f);

        TextButton backButton = new TextButton("Back", skin);

        backButton.getLabel().setFontScale(0.5f);

        // Ajout d'un listener pour chaque bouton du sous-menu
        batimentsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showbat();  // Afficher les boutons du sous-menu bat;
            }
        });

        decora.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
               TextureRegion Textures;
            //Batiment bat = new Batiment(Textures, null); 
            //showdeco();
            }
        });

        sauvegarde.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Sauvegarde");
            }
        });

        accueil.addListener(new ClickListener() {
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
        sousmenuTable.add(batimentsButton).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        sousmenuTable.add(decora).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        sousmenuTable.add(sauvegarde).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        sousmenuTable.add(accueil).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        sousmenuTable.add(backButton).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        

        // Ajout des boutons du sous-menu bat
        TextButton servpub = new TextButton("service pub", skin);
        servpub.getLabel().setFontScale(0.5f);
        TextButton habitations = new TextButton("habitations", skin);
        habitations.getLabel().setFontScale(0.5f);
        TextButton autres = new TextButton("autres", skin);
        autres.getLabel().setFontScale(0.5f);
        TextButton retour = new TextButton("retour", skin);
        retour.getLabel().setFontScale(0.5f);


        servpub.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showservice();  // Afficher les boutons du sous-menu serv;
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
        menubat.add(servpub).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        menubat.add(habitations).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        menubat.add(autres).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();

        menubat.add(retour).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();


        //////////////////////////////////

                // Ajout des boutons du sous-menu bat
                TextButton elec = new TextButton("elec", skin);
                elec.getLabel().setFontScale(0.5f);
                TextButton eau = new TextButton("eau", skin);
                eau.getLabel().setFontScale(0.5f);
                TextButton ecole = new TextButton("ecole", skin);
                ecole.getLabel().setFontScale(0.5f);
                TextButton retour2 = new TextButton("retour", skin);
                retour2.getLabel().setFontScale(0.5f);
        
                // en fonction ajoutue un string ou classe batiment pour relier puis utilsier le switch de Input handler pour la couleur
                elec.addListener(new ClickListener() { 
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if ( gestion.centraleAchetable()){
                            
                        }
                    }
                });
        
                eau.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        System.out.println("service pub");
                    }
                });
        
                ecole.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        System.out.println("habitations");
                    }
                });
        
                retour2.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        hideserv();  // Cacher les boutons du sous-menubat
                    }
                });
        
        
        
                // Ajout des boutons à la table du sous-menubat
                service.add(elec).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
                service.add(eau).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
                service.add(ecole).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        
                service.add(retour2).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();

        // Ajout du bouton menu à la table du menu principal
        table.add(menu).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
    
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
        Gdx.input.setInputProcessor(this);
    }

    public void hidebat() {
        sousmenuTable.setVisible(true);
        table.setVisible(false);
        menubat.setVisible(false);
    }

    public void showservice() {
        service.setVisible(true);  // Rendre les boutons du sous-menu visibles
        menubat.setVisible(false);  // Cacher les boutons du menu principal

    }

    public void hideserv() {
        service.setVisible(false);  // Cacher les boutons du sous-menu
        menubat.setVisible(true); 
    }

    public void dispose() {
        sousmenu.dispose();
        this.dispose();
    }

    

}
