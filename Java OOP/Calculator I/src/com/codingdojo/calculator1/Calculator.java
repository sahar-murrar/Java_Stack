package com.codingdojo.calculator1;

//Java Beans must implement the serializable interface
public class Calculator implements java.io.Serializable {
	//Java Beans must have private variables
	private Double operandOne;
	private String operation;
	private Double operandTwo;
	private Double result=0.0;
	
	//Java Beans must have a no arguments constructor
	public Calculator() {
		
	}
	
	// Java Beans Must Have setters and getters
	public Double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	public double performOperation() {
		if(this.operation == "+") {
			if(this.operandOne != null && this.operandTwo != null) {
				this.result += this.operandOne + this.operandTwo;
			}
			else {
				System.out.println("Sorry You have to set the first operand and the second operand!!");
				return -1.0;
			}
		}
		else if(this.operation == "-") {
			if(this.operandOne != null && this.operandTwo != null) {
				this.result += this.operandOne - this.operandTwo;
			}
			else {
				System.out.println("Sorry You have to set the first operand and the second operand!!");
				return -1.0;
			}
		}
		else if(this.operation == null) {
			System.out.println("Sorry You have to set an operation first!!");
			return -1.0;
			
		}
		
		return result;
	}
	
	
	

}
