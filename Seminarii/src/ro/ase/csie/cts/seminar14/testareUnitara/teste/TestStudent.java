package ro.ase.csie.cts.seminar14.testareUnitara.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.csie.cts.seminar13.testareUnitara.exceptii.ExceptieNote;
import ro.ase.csie.cts.seminar13.testareUnitara.exceptii.ExceptieNume;
import ro.ase.csie.cts.seminar13.testareUnitara.exceptii.ExceptieVarsta;
import ro.ase.csie.cts.seminar13.testareUnitara.modele.Student;
import ro.ase.csie.cts.seminar14.testareUnitara.teste.categorii.TesteImportante;

public class TestStudent {
	
	//test fixture = partea de date de care ma folosesc pt teste
	
	static Student student;
	static ArrayList<Integer> note;
	
	static String numeInitial = "Gigel";
	static int varstaInitiala = 21;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		note = new ArrayList<>();	//imi creez array de note o sg data, inainte de toate testele => DRY
		note.add(9);
		note.add(10);
		note.add(8);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {	//clean-up logic
		note.clear();
		note = null;
	}

	@Before
	public void setUp() throws Exception {
		student = new Student(numeInitial, varstaInitiala, note);	//imi creez un student nou inainte de fiecare test 
													//=> ma asigur ca fiecare test lucreaza independent pe un obiect diferit
													//=> toate testele pleaca cu studentul initial => altfel exista riscul ca testele sa fie gresite
	}

	@After
	public void tearDown() throws Exception {
		student = null;
	}

	@Ignore //ca sa ignore acest test
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetVarstaValoriNormaleRight() throws ExceptieVarsta {	//verific cum se comprta setVarsta() pt valori corecte (normale)
//		int varstaNoua = 22;
		int varstaNoua = Student.MIN_VARSTA + 1; //ca sa nu hardcodez varstaNoua ptc limitele de varsta din Student se pot modifica
		student.setVarsta(varstaNoua);
		assertEquals("Testare cu valori ok", varstaNoua, student.getVarsta());
	}
	
	@Test
	public void testSetNumeValoriNormaleRight() {
		String numeNou = "Ionel";
		try {
			student.setNume(numeNou);
			assertEquals("Test cu valori corecte", numeNou, student.getNume());
		} catch (ExceptieNume e) {
			fail("Am primit exceptie pentru valori normale");
		}
	}
	
	@Test
	public void testSetVarstaErrorConditionsValoriNegative() { //verific daca primesc exceptie pentru varsta in afara range-ului => am nevoie sa prind exceptia => folosesc try catch
		int varstaNoua = -100;
		try {
			student.setVarsta(varstaNoua);
			fail("Nu am primit exceptie pentru varsta cu valori negative");
		} catch (ExceptieVarsta e) {
			assertTrue(true); //evalueaza mereu true => inchide testul si il marcheaza cu succes
							  //daca intru pe catch e bine, ca testez aruncarea exceptiei
		}
		
	}
	
	//echivalent cu testul de mai sus => DRY 
	
	@Test(expected = ExceptieVarsta.class) //dau in expected numele clasei exceptie pe care o astept
	public void testSetVarstaErrorConditionsValoriMari() throws ExceptieVarsta { 
		int varstaNoua = Student.MAX_VARSTA + 100;
		student.setVarsta(varstaNoua);	
	}
	
	@Category(TesteImportante.class)
	@Test
	public void testGetNotaMinimaOrderingSortatCrescator() throws ExceptieNote {	//verificam daca ordinea influenteaza rezultatul
		int notaMinima = 4;
		ArrayList<Integer> noteSortate = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			noteSortate.add(notaMinima + i);
		}
		student.setNote(noteSortate);
		
		int notaMinimaDeterminata = student.getNotaMinima();
		assertEquals("Test cu note sortate crescator", notaMinima, notaMinimaDeterminata);
		
	}
	
	@Test
	public void testGetNotaMinimaCardinalityZero() throws ExceptieNote { //cand am 0 elemente
		ArrayList<Integer> note = new ArrayList<>();
		student.setNote(note);
		
		int notaMinimaAsteptata = 0;
		int notaMinimaCalculata = student.getNotaMinima();
		assertEquals("Test fara note", notaMinimaAsteptata, notaMinimaCalculata);
	}
	
	@Category(TesteImportante.class)
	@Test
	public void testGetNotaMinimaCardinalityUnu() throws ExceptieNote { //cand am 1 element
		ArrayList<Integer> note = new ArrayList<>();
		note.add(Student.MAX_NOTA);
		student.setNote(note);
		
		int notaMinimaAsteptata = Student.MAX_NOTA;
		int notaMinimaCalculata = student.getNotaMinima();
		assertEquals("Test cu o singura nota", notaMinimaAsteptata, notaMinimaCalculata);
	}
	
	@Test
	public void testGetNotaMinimaExistenceReferintaNull() throws ExceptieNote { //test de existence - cand notele sunt null => daca exista => right
		student.setNote(null);
		
		int notaMinimaAsteptata = 0;
		int notaMinimaCalculata = student.getNotaMinima();
		assertEquals("Test cu referinta null pt note", notaMinimaAsteptata, notaMinimaCalculata);
	}

}
