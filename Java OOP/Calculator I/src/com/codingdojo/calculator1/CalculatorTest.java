package com.codingdojo.calculator1;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator c= new Calculator();
		c.setOperandOne(10.5);
		c.setOperandTwo(5.2);
		c.setOperation("-");
		double res= c.performOperation();
		if (res != -1) {
			System.out.println("The Final Result is: "+c.getResult());
		}
		
		

	}

}
