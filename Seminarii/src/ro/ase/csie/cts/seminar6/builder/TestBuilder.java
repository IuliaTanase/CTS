package ro.ase.csie.cts.seminar6.builder;

public class TestBuilder {

	public static void main(String[] args) {
		
		//I.
		//1. construire obiect
		SuperErou superErou = new SuperErou(); //=> supereroii nu vor avea detalii (toate sunt null sau 0)
		
		//2. trb initializate atributele obiectului
		superErou.nume = "Superman";
		
		//II.
		SuperErou superErou2 = new SuperErou("Batman", 100, false, false, new Arma(), null, null, null); //nu e clean
		
		//III. BUILDER
		
	}

}
