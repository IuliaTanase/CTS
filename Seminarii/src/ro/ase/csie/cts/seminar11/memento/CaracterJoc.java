package ro.ase.csie.cts.seminar11.memento;

//starea caracterului

public class CaracterJoc {

	String denumire;
	int puncteViata;
	String abilitatiMagice;
	
	public CaracterJoc(String denumire, int puncteViata, String abilitatiMagice) {
		this.denumire = denumire;
		this.puncteViata = puncteViata;
		this.abilitatiMagice = abilitatiMagice;
	}
	
	public void ataca() {
		
	}
	
	public void seVindeca(int valoare) {
		this.puncteViata += valoare;
	}
	
	public void seDeplaseaza() {
		
	}
	
	//salvarea starii obiectului
	public MementoCaracterJoc salvare() {
		return new MementoCaracterJoc(this.denumire, this.puncteViata, this.abilitatiMagice);
	}
	
	//restaurare stare anterioara
	public void incarcaSalvare(MementoCaracterJoc salvare) {
		this.denumire = salvare.denumire;
		this.puncteViata = salvare.puncteViata;
		this.abilitatiMagice = salvare.abilitatiMagice;
	}
}
