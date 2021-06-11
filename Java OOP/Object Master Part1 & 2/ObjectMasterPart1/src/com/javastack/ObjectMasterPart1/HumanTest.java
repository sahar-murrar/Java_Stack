package com.javastack.ObjectMasterPart1;

public class HumanTest {

	public static void main(String[] args) {
		Human currentHuman= new Human();
		Human attackedHuman = new Human();
		System.out.println("the attacked human health before attack: "+attackedHuman.getHealth());
		int currentHumanHealth= currentHuman.attack(attackedHuman);
		System.out.println("the attacked human health after attack: "+currentHumanHealth);
		Wizard w = new Wizard();
		System.out.println("the wizard health is: "+w.getHealth());
		System.out.println("the attacked human health after the wizard heal is: "+ w.heal(attackedHuman));
		System.out.println("the attacked human health after the wizard fireball is: "+w.fireball(attackedHuman));
		Ninja n= new Ninja();
		n.steal(attackedHuman);
		System.out.println("the attacked human health after the ninja steal is: "+attackedHuman.getHealth());
		System.out.println("the ninja's health after the steal is: "+n.getHealth());
		System.out.println("the ninja's health after the run away is: "+n.runAway());
		Samurai s= new Samurai();
		s.deathBlow(attackedHuman);
		System.out.println("the attacked human health after the samurai death blow is: "+attackedHuman.getHealth());
		System.out.println("the samurai health after the samurai death blow is: "+s.getHealth());
		System.out.println("the samurai health after the samurai meditate is: "+s.meditate());
		Samurai s2= new Samurai();
		System.out.println("the samurai second health after the samurai meditate is: "+s2.meditate());
		System.out.println("the total number of samuraies is: "+Samurai.howMany());
		
		
		

	}

}
