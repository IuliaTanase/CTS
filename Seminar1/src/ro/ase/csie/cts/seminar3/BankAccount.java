package ro.ase.csie.cts.seminar3;

public class BankAccount implements Account {

	private String iban;
	private long balance;
	private Person accountHolder;
	
	public BankAccount(String iban, Person person) {
		this.iban = iban;
		this.balance = 0;
		this.accountHolder = person;
	}
	
	@Override
	public void withdraw(long amount) throws InsufficientFundsException {
		System.out.println("Withdrawing " + amount + " from " + this.iban);
		if(this.balance < amount) {
			throw new InsufficientFundsException("Insufficient funds!" + this.balance);
		}
		this.balance -= amount;
	}
	
	@Override
	public void deposit(long amount) {
		System.out.println("Depositing " + amount + " in " + this.iban);
		this.balance += amount;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public Person getAccountHolder() {
		return this.accountHolder;
	}

	
}
