package ro.ase.csie.cts.recuperare.composite;

//nod frunza
public class CaracterNPC extends NodAbstractStructura {

	String numeCaracter;
	int putere;
	
	public CaracterNPC(String numeCaracter, int putere) {
		super();
		this.numeCaracter = numeCaracter;
		this.putere = putere;
	}

	@Override
	public void atacaJucator(String numeJucator) {
		System.out.println(String.format("%s ataca pe %s", numeCaracter, numeJucator));
	}

	@Override
	public void seRetrage() {
		System.out.println(String.format("%s se retrage", numeCaracter));
	}

	@Override
	public void seDeplaseaza() {
		System.out.println(String.format("%s se deplaseaza pe ecran", numeCaracter));		
	}

	@Override
	public void adaugaNod(NodAbstractStructura nod) {
		throw new UnsupportedOperationException();	
	}

	@Override
	public void stergeNod(NodAbstractStructura nod) {
		throw new UnsupportedOperationException();	
	}

	@Override
	public NodAbstractStructura getNod(int index) {
		throw new UnsupportedOperationException();	
	}

}
