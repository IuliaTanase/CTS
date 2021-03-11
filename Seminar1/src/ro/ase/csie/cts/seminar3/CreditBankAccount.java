package ro.ase.csie.cts.seminar3;

public class CreditBankAccount extends BankAccount implements Receivable {

	public CreditBankAccount(NotificationService notif, String iban, Person accountHolder, long balance) {
		super(notif);
		this.iban = iban;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.notificationService = notif;
	}

	@Override
	public void deposit(long amount) {
		notificationService.sendNotification(accountHolder, "Adding " + amount + "to" + iban);
		this.balance += amount;

	}

}
