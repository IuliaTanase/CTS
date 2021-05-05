package ro.ase.csie.cts.seminar10.chain;

//handlerul care gestioneaza chat privat
public class ModulChatPrivat extends NodChainAbstract {

	public static final String NUME_MODUL = "Modul Chat Privat";
	
	
	public ModulChatPrivat() {
		super(NUME_MODUL);
	}

	@Override
	public void procesareMesajChat(MesajChat mesaj) {
		
		//daca destinatarul este null sau e pt everyone, nu e privat => il trimit mai departe
		if(mesaj.getDestinatar().isEmpty() || mesaj.getDestinatar().equals("@Everyone")) {
			if(this.next != null) {
				this.next.procesareMesajChat(mesaj);
			} 
		} else {
			//procesare mesaj privat
			System.out.println(String.format("Mesaj privat pentru %s = %s", mesaj.getDestinatar(), mesaj.getContinut()));
		}
	}

}
