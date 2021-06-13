package com.codingdojo.phoneassignment;

public class PhoneTester {

	public static void main(String[] args) {
		Galaxy S9= new Galaxy("S9", 99, "Version", "Ring Ring Ring!");
		IPhone iphoneTen= new IPhone("X", 100, "AT&T", "Zing");
		
		S9.displayInfo();
		System.out.println(S9.ring());
		System.out.println(S9.unlock());
		
		iphoneTen.displayInfo();
		System.out.println(iphoneTen.ring());
		System.out.println(iphoneTen.unlock());
		
		
		
		

	}

}
