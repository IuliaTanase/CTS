package ro.ase.csie.cts.seminar6.builder;

public class SuperErou {
	private String nume;
	private int puncteViata;
	
	private boolean esteNegativ;
	private boolean esteRanitGrav;
	
	InterfataArma armaStanga;
	InterfataArma armaDreapta;
	InterfataSuperPutere superPutere;
	InterfataSuperPutere superSuperPutere;
	
	//permite dezvoltatorilor sa construiasca super eroi => constructori
	private SuperErou() {
		
	}

	private SuperErou(String nume, int puncteViata, boolean esteNegativ, boolean esteRanitGrav, InterfataArma armaStanga,
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
	
	//definire builder
	//static pt a putea accesa builderul fara sa construiesc un obiect de tip SuperErou
	public static class SuperErouBuilder {
		SuperErou superErou;
		
		//in constructor punem atributele care sunt absolut necesare pt a crea un supererou
		public SuperErouBuilder(String nume, int puncteViata) {
			this.superErou = new SuperErou();
			this.superErou.nume = nume;
			this.superErou.puncteViata = puncteViata;
		}
		
		//definire metode care permit dezv sa schimbe celelalte atribute ale supereroului
		//intorc referinta catre BUILDER
		public SuperErouBuilder esteNegativ() {
			this.superErou.esteNegativ = true;
			return this;
		}
		
		public SuperErouBuilder esteRanit() {
			this.superErou.esteRanitGrav = true;
			return this;
		}
		
		public SuperErouBuilder setArmaStanga(InterfataArma arma) {
			this.superErou.armaStanga = arma;
			return this;
		}
		
		public SuperErouBuilder setArmaDreapta(InterfataArma arma) {
			this.superErou.armaDreapta = arma;
			return this;
		}
		
		public SuperErouBuilder setSuperPutere(InterfataSuperPutere superPutere) {
			this.superErou.superPutere = superPutere;
			return this;
		}
		
		public SuperErouBuilder setSuperSuperPutere(InterfataSuperPutere superSuperPutere) {
			this.superErou.superSuperPutere = superSuperPutere;
			return this;
		}
		
		public SuperErou build() {
			return this.superErou;
		}
	}
		
}
