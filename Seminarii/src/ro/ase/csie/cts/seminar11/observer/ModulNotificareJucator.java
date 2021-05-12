package ro.ase.csie.cts.seminar11.observer;

//observer A
public class ModulNotificareJucator implements InterfataStatusConexiune {

	@Override
	public void notificarePierdereConexiune() {
		System.out.println("Pop-up! Conexiune internet pierduta.");
	}

}
