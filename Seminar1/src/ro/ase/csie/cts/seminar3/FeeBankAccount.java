package ro.ase.csie.cts.seminar3;

public class FeeBankAccount extends DebitBankAccount {

	//OPEN CLOSED PRINCIPLE 
	private long fee = 2; //comisionul
	public FeeBankAccount(String iban, Person person) {
		super(iban, person);
	}

	@Override
	public void withdraw(long amount) throws InsufficientFundsException {
		System.out.println("Adding " + this.fee + " fee to withdrawal ");
		super.withdraw(amount + fee);
	}
}
