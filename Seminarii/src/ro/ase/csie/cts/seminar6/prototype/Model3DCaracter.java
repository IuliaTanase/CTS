package ro.ase.csie.cts.seminar6.prototype;

import java.util.ArrayList;
import java.util.Random;

public class Model3DCaracter implements Cloneable {
	
	String culoare;
	int inaltime;
	
	ArrayList<Integer> puncte = new ArrayList<>(); //eager - creez colectia inainte de a avea nevoie de ea
	
	public Model3DCaracter (String culoare) {
		this.culoare = culoare;
		
		System.out.println("Incarcare model 3D din fisier.....");
		try {
			Thread.sleep(2000);
			
			Random random = new Random(10); //obtinere aceeasi pseudosecventa random
			
			//simulam partea costisitoare de incarcare a obiectului
			for(int i = 0; i< 20; i++) {
				this.puncte.add(random.nextInt(1000));
			}
			
			System.out.println("Model 3D generat");
			
		} catch (InterruptedException e) {
			
		}
	}
	
	//am nevoie de constructorul default pt a crea o copie in clone (prin deep copy)
	private Model3DCaracter() {
		
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		//Model3DCaracter copie = new Model3DCaracter(this.culoare); //clone apeleaza constructorul => inutil, ptc tocmai constructorul trb evitat
		
		Model3DCaracter copie = new Model3DCaracter();
		copie.culoare = this.culoare;
		copie.inaltime = this.inaltime;
		copie.puncte = (ArrayList<Integer>) this.puncte.clone();
		
		return copie;
	}
	
	
}
