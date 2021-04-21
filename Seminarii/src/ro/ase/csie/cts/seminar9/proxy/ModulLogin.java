package ro.ase.csie.cts.seminar9.proxy;

public class ModulLogin implements InterfataModulLogin {
	
	String ipServer;
	int port;
	
	public ModulLogin(String ip, int port) {
		this.ipServer = ip;
		this.port = port;
	}

	@Override
	public boolean login(String username, String pass) {
		if(username.equals("admin") && pass.equals("admin12")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean verificaStatusServer() {
		return true;
	}

}
