package ro.ase.csie.cts.seminar11.observer;

//observer B
public class ModulAutoSalvare implements InterfataStatusConexiune {

	@Override
	public void notificarePierdereConexiune() {
		System.out.println("Salvare automata joc.");
	}

}
