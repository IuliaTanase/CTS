package ro.ase.csie.cts.seminar8.adapter;

import java.util.ArrayList;

public class TestAdapter {

	public static void main(String[] args) {
		
		CaracterFantastic dragon = new CaracterFantastic("Dragonul albastru", 1000);
		dragon.seDeplaseaza();
		dragon.esteLovit(200);
		dragon.seVindeca(100);
		
		DonaldDuck donald = new DonaldDuck();
		donald.setPower(500);
		donald.move(100, 100);
		donald.primesteLovitura(50);
		donald.reincarca(50);
		
		ArrayList<ACMECaracterJoc> caractere = new ArrayList<>();
		caractere.add(dragon);
		
		AdaptorDisneyLaACME adaptorDonald = new AdaptorDisneyLaACME(donald);	//adaptor peste donald
		caractere.add(adaptorDonald); //pot sa o pun in caractere (cutia ACME) ptc adaptorul e de tip ACME (extends)
		
		System.out.println("------------------------------");
		
		
		for(ACMECaracterJoc caracter: caractere) {
			caracter.seDeplaseaza();
			caracter.esteLovit(50);
		}
		
	}

	
}
