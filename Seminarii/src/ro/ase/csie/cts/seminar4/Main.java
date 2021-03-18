package ro.ase.csie.cts.seminar4;

import ro.ase.csie.cts.seminar4.banking.EmailNotificationService;
import ro.ase.csie.cts.seminar4.banking.NotificationService;
import ro.ase.csie.cts.seminar4.banking.Person;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import ro.ase.csie.cts.seminar4.banking.BankAccount;
import ro.ase.csie.cts.seminar4.banking.CreditBankAccount;

public class Main {

	public static void main(String[] args) {
		NotificationService emailService = new EmailNotificationService();
		
		Person p3 = new Person("Van Damme");
		p3.setEmail("vandamme@vandamme.com");
		p3.setMobile("+2345677");
		
		//CreditBankAccount b = new CreditBankAccount(emailService, "BT123123123", p3, 100);
		
		//static factory methods
		CreditBankAccount b = CreditBankAccount.createCreditBankAccountWithBalance(emailService, "BT123123123", p3, 100);
		CreditBankAccount b1 = CreditBankAccount.createCreditBankAccount(emailService, "RFZ15R3E76T3267", p3); 
		b.deposit(50);
		System.out.println(b.toString());
		
		BigInteger bi = new BigInteger(24, 11, new Random());	//construieste un intreg pozitiv prim cu acele specificatii
		BigInteger bi2 = BigInteger.probablePrime(12, new Random());	//la fel, dar mai sugestiv fata de constructorul anterior
		
		Boolean value = Boolean.valueOf(false);	//tot o metoda static factory care ne da un obiect inapoi, dar nu creeaza o clasa noua => refoloseste instantele pe care le are deja implementate
		
	}

}
