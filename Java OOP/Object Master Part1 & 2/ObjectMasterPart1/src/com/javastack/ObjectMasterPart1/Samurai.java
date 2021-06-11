package com.javastack.ObjectMasterPart1;

public class Samurai extends Human {
	private static int numOfSamuraies=0;
	public Samurai() {
		this.setHealth(200);
		numOfSamuraies +=1;
	}

	public void deathBlow(Human h) {
		h.setHealth(0);
		this.setHealth(this.getHealth()/2);
		
	}
	public int meditate() {
		this.setHealth(this.getHealth()+ (this.getHealth()/2));
		return this.getHealth();
	}
	public static int howMany() {
		return numOfSamuraies;
	}

}
