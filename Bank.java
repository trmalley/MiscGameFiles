package gameTest;

public class Bank {
	
	int bankTotal;

	public Bank() {
		bankTotal = 1000;
	}
	
	public int getBank() {
		return this.bankTotal;
	}
	
	public String bet(int bet) {
		if(bet <= bankTotal) {
			this.bankTotal = this.bankTotal - bet;
		}else {
			return "Unable to Complete Bet";
		}
		return "Bet is set";
	}
	
	public void deposit(int deposit) {
		this.bankTotal = this.bankTotal + deposit;
	}
	
}
