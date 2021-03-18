package ro.ase.csie.cts.seminar4.banking;

public class DebitBankAccount extends BankAccount implements Payable, Receivable, Transferable {


	public DebitBankAccount(NotificationService notif, String iban, Person person) {
		super(notif);
		this.iban = iban;
		this.accountHolder = person;
		balance = 0;
	}

	@Override
	public void withdraw(long amount) throws InsufficientFundsException {
		if (amount > balance)
			throw new InsufficientFundsException("Insuficient funds " + balance);
		System.out.println("withdrawing " + amount + " from " + iban);
		balance -= amount;
	}

	@Override
	public void deposit(long amount) {
		notificationService.sendNotification(accountHolder, "depositing " + amount + " from " + iban);
		balance += amount;
	}
	
	@Override
	public void transfer(Receivable destination, long amount) throws InsufficientFundsException {
		this.withdraw(amount);
		destination.deposit(amount);
		
	}

	public String getIban() {
		return iban;
	}

	public long getBalance() {
		return balance;
	}

	public Person getAccountHolder() {
		return accountHolder;
	}

}
