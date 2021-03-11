package ro.ase.csie.cts.seminar3;

public interface Account {
	void deposit(long amount);
	void withdraw(long amount) throws InsufficientFundsException;
}