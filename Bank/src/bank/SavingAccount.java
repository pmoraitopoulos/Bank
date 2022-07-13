package bank;

public class SavingAccount extends BankAccount{
	
	private double interestRate;
	
	public SavingAccount(String name, String IBAN, double interestRate) {
		super(name, IBAN);
		this.interestRate = interestRate;
	}

	public SavingAccount(String name, String IBAN, double initialBalance,int interestRate) {
		super(name, IBAN,initialBalance);
		this.interestRate = interestRate;
	}
	
	public void transfer(double ammount, BankAccount other) {
		System.out.println("Μεταφορά "+ ammount +" euro από "+ this.getIBAN() + " σε "+other.getIBAN());
		this.withdraw(ammount);
		other.deposit(ammount);
	}
	
	public void endMonthCalculation() {
		this.increaseBalanceBy(interestRate*this.getBalance()/100);
	}
}
