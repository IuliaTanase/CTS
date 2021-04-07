package ro.ase.csie.cts.seminar7.factory.factorymethod;

import ro.ase.csie.cts.seminar7.factory.simplefactory.CaracterDCComics;
import ro.ase.csie.cts.seminar7.factory.simplefactory.CaracterDisney;
import ro.ase.csie.cts.seminar7.factory.simplefactory.CaracterMarvel;
import ro.ase.csie.cts.seminar7.factory.simplefactory.SuperErouAbstract;
import ro.ase.csie.cts.seminar7.factory.simplefactory.TipErou;

public class FactoryTemaUniversala extends FactoryAbstract {

	@Override
	public SuperErouAbstract getSuperErou(TipErou tip, String nume) {
		SuperErouAbstract supererou = null;
		switch(tip) {
		case DISNEY:
			supererou = new CaracterDisney(nume, 100, false);
			break;
		case MARVEL:
			supererou = new CaracterMarvel(nume, 500, 0);
			break;
		case DC:
			supererou = new CaracterDCComics(nume, 500);
			break;
		default: 
			throw new UnsupportedOperationException();
		}
		
		return supererou;
	}

}
