package simcity;

public class habitations extends Batiment{

    private String nom;
    private int prix;
    private int ressources;
    private int habitants;
    private int bonheur;
    private int niv;
    private int gain;
    Textures texture;
    

    public habitations(String nom) {
        this.nom = nom;
        this.texture = new Textures();
        this.niv = 1;
        switch (nom) {
            case "maison":
                maison();
                
            case "immeuble":
                immeuble();
            default:
                System.out.println("erreur");
                break;
        }
    }


    
    public String getnom() {
        return this.nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return this.prix;
    }

    public void setPrix(int Prix) {
        this.prix = Prix;
    }

    public void maison() {
        this.prix = 50;
        this.bonheur= 7;
        this.habitants = 3;
        this.ressources = 5;
        this.gain = 5;

    }

    public void immeuble() {
        this.prix = 100;
        this.bonheur= 5;
        this.habitants = 10;
        this.ressources = 10;
        this.gain = 10;



    }

    public void levelup() {
        if (this.niv <= 3) {
            this.niv += 1;
            this.prix += 100;
            this.bonheur += 2;
            this.habitants += 3;
            this.ressources += 2;
            this.gain += 11;
        }
        else {
            System.out.println("niveau max atteint");
        }


    }




}
