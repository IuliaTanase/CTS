package ro.ase.csie.cts.seminar14.testareUnitara.teste;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ro.ase.csie.cts.seminar14.testareUnitara.teste.categorii.TesteImportante;

@RunWith(Categories.class)
@IncludeCategory({ TesteImportante.class }) //ce categorii sa fie folosite
@SuiteClasses({ TestStudent.class, TestStudentAlteTeste.class })
public class SuitaTesteImportante {

}
