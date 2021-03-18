package ro.ase.csie.cts.seminar4.banking;

public class CreditBankAccount extends BankAccount implements Receivable {

	public CreditBankAccount(NotificationService notif, String iban, Person accountHolder, long balance) {
		super(notif);
		this.iban = iban;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
//daca construim a foua metoda createCredit nu mai e necesar acest constructor	
//	public CreditBankAccount(NotificationService ns, String iban, Person accountHolder) {
//		super(ns);
//		this.iban = iban;
//		this.accountHolder = accountHolder;
//	}

	@Override
	public void deposit(long amount) {
		notificationService.sendNotification(accountHolder, "Adding " + amount + "to" + iban);
		this.balance += amount;

	}

	//static factory method - va inlocui constructorul
	public static CreditBankAccount createCreditBankAccountWithBalance(NotificationService notif, String iban, Person accountHolder, long balance) {
		return new CreditBankAccount(notif, iban, accountHolder, balance);
	}
	
	public static CreditBankAccount createCreditBankAccount(NotificationService notif, String iban, Person accountHolder) {
		return new CreditBankAccount(notif, iban, accountHolder, 0);
	}
	
	
}
