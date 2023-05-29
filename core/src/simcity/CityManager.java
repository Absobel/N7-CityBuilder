
package simcity;
import java.util.ArrayList;
/* Gérer le déroulement du jeu et mettre à jour son score selon ses succès
 * 
 */

class CityManager{
	
	protected int level;
	protected int score;
	protected double credits;
	protected int habitat;
	protected double happiness;
	
	private ArrayList<Sim> habitants; 
	
	final int INT_CREDITS = 1000;    //nbr de coins initial
	final int LEVEL_UP = 460;       // Cte pour passer d'un niveau à l'autre
	final int HABITANTS = 10;        // nbr d'habitants par baitiments
	//constructeur qui initialise l'état du jeu
	public CityManager() {
		this.level = 0;
		this.score = 1;
		this.credits = INT_CREDITS;
		this.habitat = 0;
		this.happiness = 0;
		this.buildingManager = new Gestion();
	}
	
	public void setScore(int newScore) {
		this.score = newScore;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public double calculatePrice(String type) {
		
		double price=0;
		switch (type) {
		case "EAU":
			price =20;
			break;
		case "ELECTRICITE":
			price =20;
			break;
		case "BONHEUR":
			price =40;
			break;
		case "ARGENT":
			price =30;
			break;
		case "HABITANT":
			price =20;
			break;
		
	}
		return price;
	}
	
	public void updateCredits(String type) {
		double price=calculatePrice(type);
		this.credits = this.credits-price;
	}
	
	public void updateLevel() {
		if(this.score % LEVEL_UP ==0 ) {
			this.level = this.level+1;
		}
	}
	
	public int calculateScore(String type) {
		
		int score=0;
		switch (type) {
		case "EAU":
			score =50;
			break;
		case "ELECTRICITE":
			score =50;
			break;
		case "BONHEUR":
			score =120;
			break;
		case "ARGENT":
			score =100;
			break;
		case "HABITANT":
			score =200;
			break;
		
		}
		return score;
	} 
	
	public void updateScore(String type) {
		int scorePlus = calculateScore(type);
		this.score = this.score + scorePlus;
		
	}
	
	public void updateHabitat(Batiment batiment) {
		this.habitat = this.habitat + HABITANTS;
		for (int i = 0; i < HABITANTS; i++) {
		    this.habitants.add(new Sim(batiment));
		}
	} 
	
	
	public void updateHapiness() {
		if(this.habitants.size()!=0) {
			int globalHapiness = 0;
			for (int i = 0; i < this.habitants.size(); i++) {
				Sim sim = this.habitants.get(i);
			    globalHapiness = globalHapiness + sim.happiness;
			}
			
			double happy = globalHapiness/this.habitants.size();
			this.happiness = happy;
		}
		
	}
	
}

