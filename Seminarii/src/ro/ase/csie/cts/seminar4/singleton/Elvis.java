package ro.ase.csie.cts.seminar4.singleton;

public class Elvis {
	//varianta 1
	
//	//obiect unic => nu trebuie sa permitem sa cream noi instante => constructor privat
//	
//	private Elvis() {}
//	
//	//trb sa nu poata fi suprascrisa de altcineva => final
//	//metoda statica pt a fi accesata din main si a crea noi instante de Elvis
//	public final static Elvis theTrueElvis = new Elvis();	
//	
//	public void sing() {
//		System.out.println("Elvis is singing");
//	}
	
	
	//varianta 2
	private Elvis() {}
	
	private final static Elvis theTrueElvis = new Elvis();	
	
	public static Elvis getInstance() {
		return theTrueElvis;
	}
	
	public void sing() {
		System.out.println("Elvis is singing");
	}
	
	//varianta 3
//	private Elvis() {}
//	
//	private static Elvis theTrueElvis;	
//	
//	public static Elvis getInstance() {
//		synchronized (Elvis.class) {
//			if(theTrueElvis == null) {
//				theTrueElvis = new Elvis();
//			}
//		}	
//		return theTrueElvis;
//	}
//	
//	public void sing() {
//		System.out.println("Elvis is singing");
//	}
	
	//daca lucrez multithreading => fiecare thread va apela getInstance si va vedea ca theTrueElvis este null => ambele vor crea o instanta => synchronized
}
