package ro.ase.csie.cts.seminar6.builder;

public class SuperErou {
	
	String nume;
	int puncteViata;
	
	boolean esteNegativ;
	boolean esteRanitGrav;
	
	InterfataArma armaStanga;
	InterfataArma armaDreapta;
	InterfataSuperPutere superPutere;
	InterfataSuperPutere superSuperPutere;
	
	//permite dezvoltatorilor sa construiasca super eroi => constructori
	public SuperErou() {
		
	}

	public SuperErou(String nume, int puncteViata, boolean esteNegativ, boolean esteRanitGrav, InterfataArma armaStanga,
			InterfataArma armaDreapta, InterfataSuperPutere superPutere, InterfataSuperPutere superSuperPutere) {
		super();
		this.nume = nume;
		this.puncteViata = puncteViata;
		this.esteNegativ = esteNegativ;
		this.esteRanitGrav = esteRanitGrav;
		this.armaStanga = armaStanga;
		this.armaDreapta = armaDreapta;
		this.superPutere = superPutere;
		this.superSuperPutere = superSuperPutere;
	}
	
	
}
