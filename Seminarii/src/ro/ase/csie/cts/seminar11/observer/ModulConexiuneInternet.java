package ro.ase.csie.cts.seminar11.observer;

import java.util.ArrayList;

//observabil
public class ModulConexiuneInternet {

	ArrayList<InterfataStatusConexiune> module = new ArrayList<>();
	
	//metoda care ne permite abonarea
	public void registerModul(InterfataStatusConexiune modul) {
		module.add(modul);
	}
	
	//metoda care ne permite dezabonarea
	public void unregisterModul(InterfataStatusConexiune modul) {
		module.remove(modul);
	}
	
	//metoda care ne permite notificarea observatorilor (celor care sunt abonati)
	public void pierdereConexiune() {
		for(InterfataStatusConexiune modul : module) {
			modul.notificarePierdereConexiune();
		}
	}
}
