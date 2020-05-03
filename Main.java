package gameTest;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		
		//Hand hand = new Hand(5);
		//Deck deck = new Deck();
		//Bank bank = new Bank();
		Thread thread;// = null;
		Dice die;
		
		int numDice = 5; //SET THE NUMBER OF DICE HERE
		Dice[] bag = new Dice[numDice];
		int[] arr = new int[numDice];
		int[] arrSum = new int[30];
		Arrays.fill(arrSum, 0);
		int sum = 0;
		  
		
		
		  for(int i=0; i<numDice; i++) {
			  String name = "Die " + i;
			  thread = new Thread(die = new Dice(6, name));
			  bag[i] = die;
			  thread.start();

			  
			  //arr[i] = die.getSide();
			  //System.out.println("Side: "+ die.getSide());
		  }  
		  
		  try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  System.out.println("Dice Roll Complete");
		  
		  for(int i=0; i<numDice; i++) {
			  sum = sum + bag[i].getSide();

		  }
		  System.out.println("Sum: " + sum);
		  
		  int val = arrSum[sum];
		  val ++;
		  arrSum[sum] = val;
		  
		  for(int i =0; i<arrSum.length; i++) {
			  System.out.println("SUM INDEX: "+ i + " "+ arrSum[i]);
		  }
		  
		  
		  //TODO REST OF PROGRAM
		  
		  
	}
	
	
	
	
	
	
	public static void pickCard(Hand hand, Deck deck) {
		try {
			hand.pickUp(deal(deck));
		}catch(Exception e) {
			System.out.println("No More Room in Hand");
		}
	}
	
	public static Card deal(Deck deck) {
		try {
			return deck.deal();
			
		} catch (Exception e) {
			System.out.println("No Card Left!");
			//e.printStackTrace();
		}
		return null;
	}
	
	public static void print(Object toPrint) {
		System.out.println(toPrint);
	}


}
