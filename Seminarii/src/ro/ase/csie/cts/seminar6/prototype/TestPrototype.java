package ro.ase.csie.cts.seminar6.prototype;

public class TestPrototype {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Model3DCaracter superman1 = new Model3DCaracter("albastru");
		//Model3DCaracter superman2 = new Model3DCaracter("albastru");
		
		Model3DCaracter superman3 = (Model3DCaracter) superman1.clone();
		
		//PROTOTYPE
		//cand procesul de creare al obiectelor este costisitor si cream acelasi obiect de mai multe ori,
		//permitem cu ajutorul CLONE crearea mai multor obiecte, ptc se realizeaza instant (deep copy)
		// => Model3DCaracter implements Cloneable 
		
		
	}

}
