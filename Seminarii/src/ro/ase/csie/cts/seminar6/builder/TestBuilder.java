package ro.ase.csie.cts.seminar6.builder;


	public class TestBuilder {

		public static void main(String[] args) {
			
			//I.
			//1. construire obiect
//			SuperErou superErou = new SuperErou(); //=> supereroii nu vor avea detalii (toate sunt null sau 0)
			
			//2. trb initializate atributele obiectului
//			superErou.nume = "Superman";
			
			//II.
//			SuperErou superErou2 = new SuperErou("Batman", 100, false, false, new Arma(), null, null, null); //nu e clean
			
			//III. BUILDER
			//constructorii privati + implementare builder din SuperErou
			SuperErou superman = new SuperErou.SuperErouBuilder("Superman", 100)	//daca vreau sa fac configurari, le fac prin metodele definite, inainte de a apela build
					.setArmaDreapta(new Arma())
					.setArmaStanga(new Arma())
					.build(); //obtin supereroul
			
			SuperErou joker = new SuperErou.SuperErouBuilder("Joker", 200)
					.esteNegativ()
					.esteRanit()
					.setArmaDreapta(new Arma())
					.build();
			
			//daca vreau sa mi mai construiesc un joker, ma pot folosi de un dictionar pt a nu face copy-paste
			SuperErou joker2 = new SuperErou.SuperErouBuilder("Joker", 200)
					.esteNegativ()
					.esteRanit()
					.setArmaDreapta(new Arma())
					.build();
		}

	}

