package ro.ase.csie.cts.seminar2;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
//		CalendarUtil cu = new CalendarUtil();
//		
//		//nu e cea mai buna decizie pt precizie
//		double d1 = 1.02;
//		double d2 = 0.43;
//		System.out.println(d1 - d2);
//		
//		//alternativa
//		BigDecimal bg1 = new BigDecimal("1.02");
//		BigDecimal bg2 = new BigDecimal("0.43");
//		System.out.println(bg1.subtract(bg2));
//
//			
//		try {
//			System.out.println(cu.weekDay(3));
//			System.out.println(cu.weekDay2(3));
//			System.out.println(cu.weekDay4(3));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		Person persoana = new Person("Someone");
		BankAccount account = new BankAccount("INGB123456789", persoana);
		
	}

}
