package ro.ase.csie.cts.seminar4.banking;

import ro.ase.csie.cts.seminar4.banking.Person.NotificationType;

//clasa singleton
//ii dam posibilitatea sa ne creeze noi conturi bancare

public class Bank {
	private static Bank INSTANCE;
	
	private NotificationService emailNotificationService;
	private NotificationService smsNotificationService;
	
	private Bank() {
		emailNotificationService = new EmailNotificationService();
		smsNotificationService = new SMSNotificationService();
	}
	
	public static synchronized Bank getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Bank();
		}
		return INSTANCE;
	}
	
// fara comision	
//	public DebitBankAccount openDebitAccount(Person holder) {
//		DebitBankAccount account = new DebitBankAccount(notificationService, generateIban(), holder);
//		return account;
//	}
	
	//comision in functie de varsta
	public DebitBankAccount openDebitAccount(Person holder) {
		DebitBankAccount account;
		
//		if(holder.getAge() < 18) {
//			 account = new DebitBankAccount(holder.getNotificationType() == Person.NotificationType.EMAIL ? emailNotificationService : smsNotificationService, 
//					 						generateIban(), 
//					 						holder);
//		} else {
//			 account = new FeeBankAccount(holder.getNotificationType() == Person.NotificationType.EMAIL.EMAIL ? emailNotificationService : smsNotificationService, 
//										  generateIban(), 
//										  holder);
//		}
		if(holder.getAge() < 18) {
			 account = new DebitBankAccount(holder.getNotificationType().getNotificationService(), 
					 						generateIban(), 
					 						holder);
		} else {
			 account = new FeeBankAccount(holder.getNotificationType().getNotificationService(), 
										  generateIban(), 
										  holder);
		}
		return account;
	}
	
	//genereaza coduri IBAN
	private String generateIban() {
		return "INGB" + System.currentTimeMillis();
	}
}
