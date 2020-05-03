package gameTest;

public class Hand {
	
	private Card[] hand;
	private int count = 0;
	
	public Hand(int size) {
		this.hand = new Card[size];
		//System.out.println("SIZE: " + size);
	}
	
	public void pickUp(Card card) throws Exception{
		//breaks connection from deck
		card.setNext(null);
		
		for(int i=0; i<hand.length; i++) {
			//System.out.println("Loop: " + i);
			if(this.hand[i] == null) {
				//System.out.println("Added: " + card);
				this.hand[i] = card;
				increaseCount();
				break;
			}
			else if(i == (hand.length - 1) && this.hand[i] != null) {
				//System.out.println("Not enough room in Hand!");
				throw  new Exception("Not enough room in Hand!");
			}
		}
	}
	
	public void increaseCount() {
		this.count = count + 1;
	}
	
	public void decreaseCount() {
		this.count ++;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public Card playCard(int index) {
		//TODO check to see that the hand is not empty
		Card toPlay;
		toPlay = hand[index];
		hand[index] = null;
		decreaseCount();
		return toPlay;
	}
	
	public String toString() {
		String s = "Hand: ";
		Card card;
		for(int i = 0; i < this.hand.length; i++) {
			card = this.hand[i];
			if(card != null) {
				s = s + card.toString();
			}
		}
		return s;
	}
}
