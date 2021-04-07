package ro.ase.csie.cts.seminar7.factory.factorymethod;

import ro.ase.csie.cts.seminar7.factory.simplefactory.SuperErouAbstract;
import ro.ase.csie.cts.seminar7.factory.simplefactory.TipErou;

public abstract class FactoryAbstract {
	
	//instantiem factory ul de care avem nevoie
	//tine de instanta factoryului folosit => nu e statica
	
	public abstract SuperErouAbstract getSuperErou(TipErou tip, String nume);	//abstracta ptc va fi implem de fiecare factory in parte
}
