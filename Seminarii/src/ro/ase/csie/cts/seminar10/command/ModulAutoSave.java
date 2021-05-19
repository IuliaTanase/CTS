package ro.ase.csie.cts.seminar10.command;

//un executant - echivalent bucatar
public class ModulAutoSave implements InterfataModulJoc {

	@Override
	public void executaActiune(String numeActiune) {
		System.out.println("Se realizeaza auto-save pentru " + numeActiune);
	}

}
