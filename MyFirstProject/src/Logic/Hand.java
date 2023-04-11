package Logic;

public class Hand {
	
	private String handSign;
	
	public Hand() {}
	
	public String getSign() {
		return handSign;
	}
	
	public void setSign(int option) {
		switch(option) {
			case 1 : handSign = "Scissors";
			break;
			case 2 : handSign = "Rock";
			break;
			case 3 : handSign = "Paper";
			break;
		}
	}

	public boolean isHandSignStronger(Hand hand) {
		if(handSign.equals("Scissors") && hand.getSign().equals("Paper"))
			return true;
		if(handSign.equals("Rock") && hand.getSign().equals("Scissors"))
			return true;
		if(handSign.equals("Paper") && hand.getSign().equals("Rock"))
			return true;
		else {
		return false;
		}
	}
	
}