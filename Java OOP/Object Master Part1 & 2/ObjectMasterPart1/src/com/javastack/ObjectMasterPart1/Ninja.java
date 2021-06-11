package com.javastack.ObjectMasterPart1;

public class Ninja extends Human {
	public Ninja() {
		this.setStealth(10);
	}
	
	public void steal(Human h) {
		h.setHealth(h.getHealth()- this.getStealth());
		this.setHealth(this.getHealth()+this.getStealth());
	}
	public int runAway() {
		this.setHealth(this.getHealth()-10);
		return this.getHealth();
	}

}
