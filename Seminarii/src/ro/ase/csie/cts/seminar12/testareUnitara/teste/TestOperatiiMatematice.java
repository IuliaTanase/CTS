package ro.ase.csie.cts.seminar12.testareUnitara.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.csie.cts.seminar12.testareUnitara.exceptii.ExceptieImpartireLaZero;
import ro.ase.csie.cts.seminar12.testareUnitara.modele.OperatiiMatematice;

public class TestOperatiiMatematice {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception { //se executa mereu inaintea tuturor testelor
		System.out.println("Salut");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception { //se executa mereu dupa toate testele
		System.out.println("La revedere!");
	}

	@Before
	public void setUp() throws Exception {	//se executa inaintea fiecarui test
		System.out.println("Pregatire test");
	}

	@After
	public void tearDown() throws Exception {	//se executa dupa fiecare test
		System.out.println("Clean up resurse folosite");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAdunaValoriPozitive() {
		int a = 5;
		int b = 5;
		int rezultatAsteptat = 10;
		
		int rezultatCalculat = OperatiiMatematice.aduna(a, b);
		
		assertEquals("Suma cu numere pozitive", rezultatAsteptat, rezultatCalculat); //mesajul va fi afisat doar daca testul pica
	}
	
	@Test
	public void testImpartireValoriPozitive() throws ExceptieImpartireLaZero {
		int a = 1;
		int b = 2;
		double rezultatAsteptat = 0.5;
		
		double rezultatCalculat = OperatiiMatematice.impartire(a, b);
		
//		sau:
//		double rezultatCalculat = 0;
//		try {
//			rezultatCalculat = OperatiiMatematice.impartire(a, b);
//		} catch (ExceptieImpartireLaZero e) {
//			fail("Am primit exceptie, desi nu trebuia"); //pe catch punem fail, ptc nu ne asteptam sa primim exceptie
//		}
		
		assertEquals("Impartire cu numere pozitive", rezultatAsteptat, rezultatCalculat, 0); //delta e precizia - se fol pt valori reale -> 0 ptc 1/2 da 0.5 fix
	}

}
