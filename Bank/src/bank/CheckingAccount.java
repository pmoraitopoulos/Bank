package bank;
import fees.*;

public class CheckingAccount extends BankAccount{
	
	private int transactionsCount;
	
	public CheckingAccount(String name, String IBAN) {
		super(name,IBAN);
		this.transactionsCount = 0;
	}

	public CheckingAccount(String name, String IBAN, double initialBalance) {
		super(name, IBAN, initialBalance);
		this.transactionsCount = 0;		
	}
	
	public void notificationChargedTransaction() {
		if(transactionsCount > fee.FREE_TRANSACTIONS) {
			System.out.println("Έχετε ξεπεράσει το όριο των "+fee.FREE_TRANSACTIONS+" δωρεάν συναλλαγών."
					+ "\n Μόλις πραγματοποιήσατε τη "+ transactionsCount + "συναλλαγής σας και θα χρεωθείτε στο κλείσιμο του μήνα"
							+ "με έξοδα συναλλαγών τα οποία ορίζονται στα "+ fee.FEE_PER_NEW_TRANSACTION +" ευρώ για κάθε επιπλέον συναλλαγή.");
		}
	}
	
	public void deposit(double ammount) {
		this.transactionsCount++;
		super.deposit(ammount);
		this.notificationChargedTransaction();
	}
	
	public void withdraw(double ammount) {
		this.transactionsCount++;
		super.withdraw(ammount);
		this.notificationChargedTransaction();
	}
	
	public void endMonthCalculation() {
		if(transactionsCount > fee.FREE_TRANSACTIONS) {
			this.notificationChargedTransaction();
			double fees = fee.FEE_PER_NEW_TRANSACTION*(transactionsCount-fee.FREE_TRANSACTIONS);
			super.withdraw(fees);
		}
			this.transactionsCount = 0;
	}
}
