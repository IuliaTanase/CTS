package ro.ase.csie.cts.seminar4.singleton;

public class Elvis {
	//nu trebuie sa permitem sa cream noi instante => constructor privat
	
	private Elvis() {
		
	}
	
	public final static Elvis theTrueElvis = new Elvis();	//trb sa nu poata fi suprascrisa de altcineva
	
	public void sing() {
		System.out.println("Elvis is singing");
	}
}
