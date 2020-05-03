package gameTest;

import java.util.Random;

public class Dice extends Thread{
	
	private String name;
	private int numSides;
	private int currentSide;
	
	Random rand = new Random(); 
	public Dice(int numSides, String name) {
		this.numSides = numSides;
		this.name = name;
	}
	
	public int roll() {
		int n = rand.nextInt(6);
		n ++;
		this.setSide(n);
		return n;
	}
	
	public int getSide() {
		return this.currentSide;
	}
	
	public void setSide(int n) {
		this.currentSide = n;
	}

	public void run() {
		try {
			System.out.println("Dice " + name + ": " +this.roll());
		}catch(Exception e) {
			System.out.println("Exception Caught!");
		}
	}
}
