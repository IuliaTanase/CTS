package ro.ase.csie.cts.seminar14.testareUnitara.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.csie.cts.seminar13.testareUnitara.exceptii.ExceptieVarsta;
import ro.ase.csie.cts.seminar14.testareUnitara.modele.Student;
import ro.ase.csie.cts.seminar14.testareUnitara.teste.categorii.TesteImportante;

public class TestStudentAlteTeste {
	
	//test fixture
	static Student student;
	static ArrayList<Integer> note;
	static ArrayList<Integer> noteTestPerformanta;
	static String numeInitial;
	static int varstaInitiala;
	static int nrNoteInitiale;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		note = new ArrayList<>();
		nrNoteInitiale = 3;
		Random random = new Random();
		for(int i = 0; i < nrNoteInitiale; i++) {
			note.add(random.nextInt(Student.MAX_NOTA + 1)); //generam note intre 1 si 10
		}
		numeInitial = "Gigel";
		varstaInitiala = Student.MIN_VARSTA + 1;
		
		noteTestPerformanta = new ArrayList<>();
		int nrNote = 1000000;
		for(int i = 0; i<nrNote; i++) {
			noteTestPerformanta.add(Student.MAX_NOTA);
		}
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		student = new Student(numeInitial, varstaInitiala, note);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = ExceptieVarsta.class)
	public void testSetVarstaRangeMinInt() throws ExceptieVarsta {	//este si de Error Cond, ptc nu avem cum sa acceptam Min_Int
		int varstaNoua = Integer.MIN_VALUE;
		student.setVarsta(varstaNoua);
	}
	
	@Test(expected = ExceptieVarsta.class)
	public void testSetVarstaRangeMaxInt() throws ExceptieVarsta {	
		int varstaNoua = Integer.MAX_VALUE;
		student.setVarsta(varstaNoua);
	}
	
	@Test
	public void testSetVarstaBoundaryVarstaMinimaRight() throws ExceptieVarsta  {	//e si test de Right, ptc 14 si 90 sunt valori valide
		int varstaNoua = student.MIN_VARSTA;
		student.setVarsta(varstaNoua);
		int varstaModificata = student.getVarsta();
		assertEquals("Test pentru limita inferioara varsta", varstaNoua, varstaModificata);
	}
	
	@Test
	public void testSetVarstaBoundaryVarstaMaximaRight() throws ExceptieVarsta  {	
		int varstaNoua = student.MAX_VARSTA;
		student.setVarsta(varstaNoua);
		int varstaModificata = student.getVarsta();
		assertEquals("Test pentru limita superioara varsta", varstaNoua, varstaModificata);
	}
	
	@Test
	public void testSetNoteReferenceDeepCopy() throws ro.ase.csie.cts.seminar13.testareUnitara.exceptii.ExceptieNote  {	
		ArrayList<Integer> note = new ArrayList<>();
		note.add(10);
		note.add(10);
		note.add(10);
		
		student.setNote(note);

		int[] noteStudent = new int[student.getNrNote()];
		for(int i = 0; i < student.getNrNote(); i++) {
			noteStudent[i] = student.getNota(i);
		}
		
		note.set(0, 5); //modific referinta externa

		int[] noteDupaModificare = new int[student.getNrNote()]; //copia notelor studentului dupa modificare
		for(int i=0; i<student.getNrNote(); i++) {
			noteDupaModificare[i] = student.getNota(i);
		}
		
		assertArrayEquals("Test modificare note din exterior", noteStudent, noteDupaModificare);
	}
	
	@Test //varianta Junit3
	public void testGetMediePerformance() throws ro.ase.csie.cts.seminar13.testareUnitara.exceptii.ExceptieNote {
		ArrayList<Integer> note = new ArrayList<>();
		int nrNote = 1000000;
		for(int i = 0; i<nrNote; i++) {
			note.add(Student.MAX_NOTA);
		}
		
		student.setNote(note);
		
		long tStart = System.currentTimeMillis(); //ora sistemului la nivel de milisecunde
		float medieCalculata = student.getMedie();
		long tFinal = System.currentTimeMillis();
		
		long durataMinima = 10; //10 milisecunde
		long durata = tFinal - tStart;
		if(durata <= durataMinima) {
			assertTrue(true);
		} else {
			fail("Testul a depasit durata minima");
		}
	}
	
	//timeout verifica tot testul, nu doar functia pe care o vrem
	@Test(timeout = 10) //varianta Junit4 - daca testul ruleaza sub 10 millisec, e ok
	public void testGetMediePerformanceJUnit4() throws ro.ase.csie.cts.seminar13.testareUnitara.exceptii.ExceptieNote {
		student.setNote(noteTestPerformanta);
		student.getMedie();		
	}
	
	@Test
	public void testGetNotaMinimaInverseRelation() throws ro.ase.csie.cts.seminar13.testareUnitara.exceptii.ExceptieNote {
		ArrayList<Integer> note = new ArrayList<>();
		int nrNote = 100000;
		
		Random random = new Random();
		
		for(int i = 0; i<nrNote; i++) {
			note.add(random.nextInt(Student.MAX_NOTA + 1));
		}
		student.setNote(note);
		
		int minimCalculat = student.getNotaMinima();
		
		//ptc nu putem determ valoarea estimata (nu stiu ce e in random) 
		//=> verificam relatia dintre minim si valorile initiale
		
		for(int i = 0; i < nrNote; i++) {
			if(minimCalculat > note.get(i)) {
				fail("Minimul calculat nu este corect");
			}
		}
		
		assertTrue(true);
	}
	
	@Category(TesteImportante.class)
	@Test
	public void testGetMedieCrossCheck() throws ro.ase.csie.cts.seminar13.testareUnitara.exceptii.ExceptieNote {
		ArrayList<Integer> note = new ArrayList<>();
		int nrNote = 10;
		
		Random random = new Random();
		
		for(int i = 0; i<nrNote; i++) {
			note.add(random.nextInt(Student.MAX_NOTA + 1));
		}
		student.setNote(note);
		
		float medieEstimata = getMedieVariantaInitiala(note);
		float medieCalculata = student.getMedie();
		assertEquals("Valorile calculate de cele 2 functii nu sunt identice", medieEstimata, medieCalculata, 0);
	}
	
	//functie auxiliara, nu de test
	public float getMedieVariantaInitiala(ArrayList<Integer> valori) {
		float suma = 0;
		for(int valoare : valori) {
			suma += valoare;
		}
		return suma / valori.size();
	}

}
