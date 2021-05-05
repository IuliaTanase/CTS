package ro.ase.csie.cts.seminar10.command;

import java.nio.channels.UnsupportedAddressTypeException;

//ce facem in plan secundar = comanda concreta
public class TaskToDo extends TaskAsincron {

	//referinta catre modulul care face acel lucru
	InterfataModulJoc modulJoc = null;
	
	String info;
	int prioritate;
	
	public TaskToDo(InterfataModulJoc modulJoc, String info, int prioritate) {
		super();
		this.modulJoc = modulJoc;
		this.info = info;
		this.prioritate = prioritate;
	}

	@Override
	public void executaTask() {
		if(this.modulJoc != null) {
			//lansam task ul in executie
			this.modulJoc.executaActiune(info);
		} else {
			//nu avem pe cineva (modulul) care sa execute task ul asincron
			throw new UnsupportedOperationException();
		}
	}

}
