package gameTest;

import java.util.Random;

public class Deck {
	
	private Card head;
	private char[] suits = {'C','S','H','D'};
	private int[] value = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	private int count = 0;
	
	public Deck() {
		reset();
	}
	
	public Card deal() throws Exception {
		Card toDeal = this.head;
		
		toDeal = this.head;
		if(toDeal == null) {
			throw new Exception("Deck is Empty!!!");
		}	
		this.head = this.head.getNext();
		this.count --;
		return toDeal;
	}
	
	public int decklength() {
		return this.count;
	}
	
	public void reset() {
		Card tmp = null;
		Card[] arr = new Card[52];
		Random rand = new Random(); 
		int r = 0;
		for(int i = 0; i < suits.length; i++) {
			for(int j = 0; j <= 12; j++) {
				
				arr[r] = new Card(suits[i],value[j], null);
				r++;				
			}
		}
		
		//for(int i =0; i< 51; i++) {
		//	System.out.print(arr[i]);
		//}
		//System.out.println("\n"+arr.length);
		
		for(int i = 0; i< 51; i++) {
			int randomPos = rand.nextInt(arr.length);
			Card temp = arr[i];
			arr[i] = arr[randomPos];
			arr[randomPos] = temp;
		}
	
		tmp = arr[0];
		this.head = tmp;
		this.count ++;

		for(int i = 1; i < arr.length; i++) {
			
			tmp.setNext(arr[i]);
			tmp = tmp.getNext();
			this.count ++;
		}
	}
	
	public String toString() {
		String s = "Deck: ";
		Card tostring = this.head;
		while (tostring != null) {
			s  = s + tostring.toString();
			tostring = tostring.getNext();
		}
		return s;
		
	}

}
