package ro.ase.csie.cts.seminar7.factory.simplefactory;

public class TestSimpleFactory {

	public static void main(String[] args) {
		
//		SuperErouAbstract supererou = new CaracterDisney("Mickey Mouse", 100, false);
//		supererou = new CaracterMarvel("Spiderman", 150, 50);
//		supererou = new CaracterDCComics("Batman", 150);
		//daca mai adaugam un atribut in constructorul eroului, eroarea se va propaga peste tot unde cream obiectele =>
		//glass code
		
		boolean selectieTemaUniversala = true;
		SuperErouAbstract superCaracter = null;
		
		if(selectieTemaUniversala) {
			
			//daca mai adaugam un atribut in constructorul eroului, eroarea nu va aparea aici, dar va aparea in Factory
			superCaracter = FactorySuperErou.getSuperErou(TipErou.DISNEY, "Mickey Mouse");
			superCaracter = FactorySuperErou.getSuperErou(TipErou.MARVEL, "Spiderman");
			superCaracter = FactorySuperErou.getSuperErou(TipErou.DC, "Batman");		
		} else {
			//folosesti caractere din tema originala a jocului
		}
	}

}
