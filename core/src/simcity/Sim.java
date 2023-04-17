package simcity;
/*Un sim est un habitant de simcity
 * il a  un batiment ou il habite et un numero de bonheur qui indique sa satisfaction
 */
classe Sim {

	private Batiment building;
	private int happiness; 
	
	public Sim(Batiment buil) {
		this.building= buil;
		this.happiness = 100;
	}
	
	public void updateHapiness(boolean est_satisfait) {
		if(est_satisfait) {
			if(this.happiness<100) {
				this.happiness = this.happiness + 1;
			}
		} else {
			if(0<this.happines) {
				this.happiness = this.happiness - 1;
			}
		}
	}
  
}
