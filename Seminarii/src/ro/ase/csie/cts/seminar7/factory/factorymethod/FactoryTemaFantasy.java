package ro.ase.csie.cts.seminar7.factory.factorymethod;

import ro.ase.csie.cts.seminar7.factory.simplefactory.SuperErouAbstract;
import ro.ase.csie.cts.seminar7.factory.simplefactory.TipErou;

public class FactoryTemaFantasy extends FactoryAbstract {

	@Override
	public SuperErouAbstract getSuperErou(TipErou tip, String nume) {
		SuperErouAbstract supererou = null;
		switch(tip) {
		case DISNEY:
			supererou = new CaracterFantasyDisney(nume, 100);
			break;
		case MARVEL:
			supererou = new CaracterFantasyMarvel(nume, 500);
			break;
		case DC:
			supererou = new CaracterFantasyDC(nume, 500);
			break;
		default: 
			throw new UnsupportedOperationException();
		}
		
		return supererou;
	}

}
