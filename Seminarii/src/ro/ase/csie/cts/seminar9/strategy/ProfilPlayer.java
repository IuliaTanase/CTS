package ro.ase.csie.cts.seminar9.strategy;

public class ProfilPlayer {

	String username;
	double playTime;
	int nrNiveluri;
	
	InterfataBonus strategieBonus = null;
	
	public ProfilPlayer(String username, double playTime, int nrNiveluri) {
		super();
		this.username = username;
		this.playTime = playTime;
		this.nrNiveluri = nrNiveluri;
	}
	
	//obligatoriu - sa pot schimba strategia
	public void setStrategieBonus(InterfataBonus strategie ) {
		this.strategieBonus = strategie;	
	}
	
	public void getBonus() {
		if(this.strategieBonus != null) {
			int puncteBonus = this.strategieBonus.getPuncteBonus(this); //trimit profilul pt a vedea in fct de ce acord bonusul
			System.out.println("Ai primit bonus = " + puncteBonus);
		} else {
			throw new UnsupportedOperationException(); //nu e setata strageia
		}
	}
}
