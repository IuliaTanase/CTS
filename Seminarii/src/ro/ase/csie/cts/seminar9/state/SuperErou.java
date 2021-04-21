package ro.ase.csie.cts.seminar9.state;

public class SuperErou  {

	public static final int NIVEL_CRITIC = 10;
	
	int puncteViata;
	String nume;
	
	InterfataMiscare modMiscare = null;
	
	public SuperErou(String nume, int puncteViata) {
		super();
		this.puncteViata = puncteViata;
		this.nume = nume;
		this.modMiscare = new MiscareNormala();
	}

	public void seDeplaseaza() {
		this.modMiscare.seDeplaseaza();
	}
	
	public void esteAtacat(int puncte) {
		this.puncteViata -= puncte;
		if(this.puncteViata < NIVEL_CRITIC) {
			this.modMiscare = new MiscareModRanit();
		}
	}
	
	public void seVindeca(int puncte) {
		this.puncteViata += puncte;
		if(this.puncteViata >= NIVEL_CRITIC) {
			this.modMiscare = new MiscareNormala();
		}
	}
}
