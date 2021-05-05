package ro.ase.csie.cts.seminar10.chain;

//handler
public abstract class NodChainAbstract {

	//referinta catre urmatorul nod
	NodChainAbstract next = null;
	
	String numeModul;
	
	
	
	public NodChainAbstract(String modul) {
		super();
		this.numeModul = modul;
	}

	public void setNext(NodChainAbstract next) {
		this.next = next;
	}
	
	public abstract void procesareMesajChat(MesajChat mesaj);
}
