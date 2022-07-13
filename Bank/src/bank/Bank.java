package bank;
import java.util.ArrayList;

public class Bank {
	private String bankName;
	private String branchCode;	
	private ArrayList<BankAccount> accDB;
	
	public Bank(String bankName, String branchCode) {
		this.bankName = bankName;
		this.branchCode = branchCode;
		accDB = new ArrayList<>();
	}
	
	public void addBankAccount(BankAccount acc) {
		accDB.add(acc);
	}
	
	public void accountsMonthCalculations() {
		for(BankAccount a: accDB) {
			a.endMonthCalculation();
		}
	}
	
	public void accountsPrintDetails() {
		for(BankAccount a: accDB) {
			a.printDetails();
		}
	}
	
	public void accountsZeroBalance() {
		boolean isThereZeroBalanceAccounts = false;
		for(BankAccount a : accDB) {
			if(a.getBalance()==0) {
				System.out.println("Δικαιούχος" + a.getIBAN());
				System.out.println("Δικαιούχος" + a.getOwnerName());
				isThereZeroBalanceAccounts = true;
			}
		}
		if(isThereZeroBalanceAccounts) {
			System.out.println("All accounts have positive balance");
		}	
	}

	public void printBankDetails() {
		double sum = 0;
		for(BankAccount a:accDB) {
			sum+=a.getBalance();
		}
		System.out.println("Οι λογαριασμοί της τράπεζας είναι " +accDB.size() + " και το σύνολο είναι " + sum);
	}
	
}
