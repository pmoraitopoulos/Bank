package bank;

public abstract class  BankAccount {
	
	private String ownerName;
	private String IBAN;
	private double balance;
	
	protected BankAccount(String ownerName, String IBAN) {
		this.ownerName = ownerName;
		this.IBAN = IBAN;
		this.balance = 0;
	}
	
	protected BankAccount(String ownerName, String IBAN, double initialBalance) {
		this.ownerName = ownerName;
		this.IBAN = IBAN;
		this.balance = initialBalance;
	}
	
	protected abstract void endMonthCalculation();
	
	public void deposit(double ammount) {
		this.printDetails();
		balance += ammount;
		System.out.println("Κάνατε κατάθεση " + ammount + " euro. Το νέο υπόλοιπό σας είναι: "+ balance + " euro.");
	}
	
	protected void withdraw(double ammount) {
		this.printDetails();
		balance -= ammount;
		System.out.println("Κάνατε ανάληψη " + ammount + " euro. Το νέο υπόλοιπό σας είναι: "+ balance + " euro.");
	}
	
	protected void printDetails() {
		System.out.println("Ιδιοκτήτης λογαριασμου: " + ownerName);
		System.out.println("Αριθμός λογαριασμού: " + IBAN);
		System.out.println("Υπόλοιπο: "+ balance);
	}
	
	protected String getOwnerName() {
		return ownerName;
	}

	protected String getIBAN() {
		return IBAN;
	}

	protected double getBalance() {
		return balance;
	}
	
	protected void increaseBalanceBy(double ammount) {
		balance += ammount;
	}
	

}
