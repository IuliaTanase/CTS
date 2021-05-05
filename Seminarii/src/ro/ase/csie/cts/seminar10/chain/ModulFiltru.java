package ro.ase.csie.cts.seminar10.chain;

//handlerul care filtreaza mesajele
public class ModulFiltru extends NodChainAbstract {

	public ModulFiltru(String modul) {
		super(modul);
	}

	@Override
	public void procesareMesajChat(MesajChat mesaj) {
		String[] dictionar = new String[] {"rau", "obraznic", "violent"}; //dictionarul de cuvinte "interzise"
		boolean esteValid = true;
		
		for(String cuvant : dictionar) {
			if(mesaj.getContinut().contains(cuvant)) {
				esteValid = false;
				break;
			}
		}
		
		if(esteValid && this.next != null) {	//sa am si un succesor
			this.next.procesareMesajChat(mesaj); //trimit mai departe mesajul, dupa ce verific ca e ok
		}
	}

}
