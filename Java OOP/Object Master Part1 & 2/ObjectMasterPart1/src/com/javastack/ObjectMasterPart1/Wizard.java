package com.javastack.ObjectMasterPart1;

public class Wizard extends Human {

	public Wizard() {
		this.setHealth(50);
		this.setIntelligence(8);
		
	}
	public int heal(Human h) {
		 h.setHealth(h.getHealth()+this.getIntelligence());
		 return h.getHealth();
	}
	public int fireball(Human h) {
		h.setHealth(h.getHealth()-(this.getIntelligence()*3));
		return h.getHealth();
	}

}
