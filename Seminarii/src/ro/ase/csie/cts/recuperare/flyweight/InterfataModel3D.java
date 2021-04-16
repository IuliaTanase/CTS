package ro.ase.csie.cts.recuperare.flyweight;

//interfata flyweight
//modelul 3D e partea comuna

public interface InterfataModel3D {

	public void incarcaModel3D(String fisier);
	public void afisareEcran(ContextEcran context); //o metoda care va reuni partea comuna cu cea temporara
}
