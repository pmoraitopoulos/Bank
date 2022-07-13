package main;
import bank.*;

public class Main {

	public static void main(String[] args) {
		
		Bank B1 = new Bank("Τραπεζα Πειραιώς", "00001");
		SavingAccount S1 = new SavingAccount("Moraitopoulos","abcd1234",0.4);
		CheckingAccount C1 = new CheckingAccount("Mimikou","decf4566",1000);
		
		S1.deposit(10000);
		S1.transfer(2000, C1);
		
		C1.withdraw(1500);
		C1.withdraw(80);
		C1.withdraw(400);
		
		B1.addBankAccount(C1);
		B1.addBankAccount(S1);
		
		B1.accountsMonthCalculations();
		B1.accountsPrintDetails();
		B1.accountsZeroBalance();
		B1.printBankDetails();

	}

}
