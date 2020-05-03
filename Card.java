package gameTest;



public class Card{
	
	private char suit;
	private int value;
	private char color;
	public Card next;

			
	
	public Card(char suit, int value, Card next) {
		this.suit = suit;
		this.value = value;
		//this.color = c;	
	}


	public char getSuit() {
		return suit;
	}
	
	public String getValue() {
		switch(value) {
		case(1):
			return "A";
		case(11):
			return "J";
		case(12):
			return "Q";
		case(13):
			return "K";
		default:
		return String.valueOf(value);
		}
	}
	
	public char getColor() {
		return color;
	}
	
	public Card getNext() {
		return this.next;
	}
	
	
	public void setNext(Card next) {
		this.next = next;
	}
	
	public String toString() {
		return "|"+getValue()+ ":"+  getSuit()+"|";
		
	}
}
