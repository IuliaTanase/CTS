package ro.ase.csie.cts.seminar2;

public class BankAccount {

	//daca las campurile accountHolderName si accountHolderAddress
	//este incalcat principiul Single Responsability
	//adresa titluarului de cont nu tine de contul bancar
	//cream o clasa noua Persoana
	
	private String iban;
	private long balance;
	private Person accountHolder;
	
	public BankAccount(String iban, Person person) {
		this.iban = iban;
		this.balance = 0;
		this.accountHolder = person;
	}
	
	public void withdraw(long amount) {
		this.balance -= amount;
	}
	
	public void deposit(long amount) {
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
