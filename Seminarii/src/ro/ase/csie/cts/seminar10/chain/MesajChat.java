package ro.ase.csie.cts.seminar10.chain;

public class MesajChat {

	String destinatar;
	String continut;
	int prioritate;
	
	
	public MesajChat(String destinatar, String continut, int prioritate) {
		super();
		this.destinatar = destinatar;
		this.continut = continut;
		this.prioritate = prioritate;
	}


	public String getDestinatar() {
		return destinatar;
	}

	public String getContinut() {
		return continut;
	}

	public int getPrioritate() {
		return prioritate;
	}
	
	
}
