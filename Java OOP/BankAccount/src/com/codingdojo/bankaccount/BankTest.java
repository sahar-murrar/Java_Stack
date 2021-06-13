package com.codingdojo.bankaccount;

public class BankTest {
	public static void main(String[] args) {
		BankAccount a = new BankAccount();
		a.deposite(50, "Checking");
		a.withdraw(40, "Checking");
		System.out.println("bank of a " + a.getCheckingBalance());
		BankAccount b = new BankAccount();
		b.deposite(400000, "Saving");
		b.withdraw(45, "Saving");
		System.out.println(BankAccount.seeTotalMoney());
		

	}

}
