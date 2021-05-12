package ro.ase.csie.cts.seminar11.observer;

public class TestObserver {

	public static void main(String[] args) {
		
		ModulConexiuneInternet modulConexiune = new ModulConexiuneInternet();
		
		ModulAutoSalvare modulSalvare = new ModulAutoSalvare();
		ModulNotificareJucator modulNotificari = new ModulNotificareJucator();
		
		//abonare
		modulConexiune.registerModul(modulSalvare);
		modulConexiune.registerModul(modulNotificari);
		
		//observerii vor fi notificati la pierderea conexiunii
		modulConexiune.pierdereConexiune();
		
		//dezabonare
		modulConexiune.unregisterModul(modulSalvare);
		modulConexiune.pierdereConexiune();


	}

}
