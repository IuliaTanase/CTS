package ro.ase.csie.cts.seminar9.proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyLogin implements InterfataModulLogin {

	InterfataModulLogin modulLogin = null;

	public static final int NR_MAX_INCERCARI = 3;

	// pt fiecare username stocam nr de incercari nereusite
	public Map<String, Integer> nrIncercari = new HashMap<>();

	public ProxyLogin(InterfataModulLogin modulLogin) {
		super();
		this.modulLogin = modulLogin;
	}

	@Override
	public boolean login(String username, String pass) {
		Integer nrIncercariNereusite = nrIncercari.get(username);
		if (nrIncercariNereusite == null) { // e prima data cand cineva se conecteaza pe acest username
			nrIncercari.put(username, 0);
			nrIncercariNereusite = 0;
		}

		if (modulLogin != null) {
			if (nrIncercariNereusite < NR_MAX_INCERCARI) {
				if (modulLogin.login(username, pass) == true) {
					nrIncercariNereusite = 0;
					nrIncercari.put(username, nrIncercariNereusite);
					return true; // autentificare cu succes
				} else {
					nrIncercariNereusite += 1;
					nrIncercari.put(username, nrIncercariNereusite);
					return false;
				}
			} else {
				return false; //contul a fost "blocat"
			}
		} else {
			throw new UnsupportedOperationException(); //nu exista modulul
		}
	}

	@Override
	public boolean verificaStatusServer() {
		if (modulLogin != null) {
			return modulLogin.verificaStatusServer();
		} else {
			throw new UnsupportedOperationException();
		}
	}

}
