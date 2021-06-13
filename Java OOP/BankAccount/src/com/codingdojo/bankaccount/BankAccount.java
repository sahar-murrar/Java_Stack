package com.codingdojo.bankaccount;
import java.util.*;
public class BankAccount {
	private String accountNumber;
	private double checkingBalance=0;
	private double savingsBalance=0;
	private static int numOfAccounts=0;
	private static int totalAmountOfMoney=0;
	
	public BankAccount() {
		this.accountNumber= randomAccountNumber();
		numOfAccounts++;
	}
	public double getCheckingBalance() {
		return checkingBalance;
	}


	
	public double getSavingsBalance() {
		return savingsBalance;
	}

	
	
	private String randomAccountNumber() {
		String accountNum="";
		for(int i=0; i<10; i++) {
			 Random r = new Random();
			 accountNum+= String.valueOf(r.nextInt(9));
		}
		return accountNum;
		 
	}
	public void deposite(double amount, String balance) {
		if (balance=="Checking") {
			this.checkingBalance+=amount;
			
		}
		else if (balance=="Saving") {
			this.savingsBalance+=amount;
			
		}
		totalAmountOfMoney+=amount;
		
	}
	public void withdraw(double amount, String balance) {
		
		if (balance=="Checking") {
			if (amount <= this.checkingBalance){
			this.checkingBalance-=amount;
			totalAmountOfMoney-=amount;
			
			}
			else {
				System.out.println("Insuffcient Funds");
			}
			
		}
		else if (balance=="Saving") {
			if (amount <= this.savingsBalance) {
			this.savingsBalance+=amount;
			totalAmountOfMoney-=amount;
			}
			else {
				System.out.println("Insuffcient Funds");
			}
		}
		
		
	}
	public static double seeTotalMoney() {
		return totalAmountOfMoney;
	}

}
