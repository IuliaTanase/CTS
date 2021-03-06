package ro.ase.csie.cts.seminar8.decorator;

import ro.ase.csie.cts.seminar8.adapter.ACMECaracterJoc;

public abstract class DecoratorCaracter extends ACMECaracterJoc {

	ACMECaracterJoc caracter = null; //referinta catre ob decorat

	public DecoratorCaracter(ACMECaracterJoc caracter) {
		super(caracter.getNume(), caracter.getPuncteViata());
		this.caracter = caracter;
	}

	@Override
	public void seDeplaseaza() {
		this.caracter.seDeplaseaza();		
	}

	@Override
	public void esteLovit(int puncte) {
		this.caracter.esteLovit(puncte);			
	}

	@Override
	public void seVindeca(int puncte) {
		this.caracter.seVindeca(puncte);		
	
	}
	
	@Override
	public int getPuncteViata() {
		return this.caracter.getPuncteViata();		
	}
	
}
