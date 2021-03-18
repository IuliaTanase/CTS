package ro.ase.csie.cts.seminar4.banking;

//clasa singleton
//ii dam posibilitatea sa ne creeze noi conturi bancare

public class Bank {
	private static Bank INSTANCE;
	
	private NotificationService notificationService;
	
	private Bank() {
		notificationService = new EmailNotificationService();
	}
	
	public static synchronized Bank getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Bank();
		}
		return INSTANCE;
	}
	
//	public DebitBankAccount openDebitAccount(Person holder) {
//		DebitBankAccount account = new DebitBankAccount(notificationService, generateIban(), holder);
//		return account;
//	}
	
	public DebitBankAccount openDebitAccount(Person holder) {
		DebitBankAccount account;
		
		if(holder.getAge() < 18) {
			 account = new DebitBankAccount(notificationService, generateIban(), holder);
		} else {
			 account = new FeeBankAccount(notificationService, generateIban(), holder);
		}

		return account;
	}
	
	//genereaza coduri IBAN
	private String generateIban() {
		return "INGB" + System.currentTimeMillis();
	}
}
