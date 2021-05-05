package ro.ase.csie.cts.seminar10.chain;

//handlerul care gestioneaza chat public
public class ModulChatGlobal extends NodChainAbstract {

	public ModulChatGlobal() {
		super("Modul Chat Global");
	}

	@Override
	public void procesareMesajChat(MesajChat mesaj) {
		if(mesaj.getDestinatar().isEmpty() || mesaj.getDestinatar().equals("@Everyone")) {
			//mesaj public
			System.out.println("Mesaj catre toti jucatorii: " + mesaj.getContinut());
		}
		
		if(this.next != null) {
			this.next.procesareMesajChat(mesaj);
		}
	}

}
