package EE57;

public class SubstractionQuestion implements IntQuestion {
	private int a, b;
	 
	public SubstractionQuestion() {
		a = (int) (Math.random()*50);
		b = (int) (Math.random()*50);
		if(a < b) {
			int swipe = b;
			b = a;
			a = swipe;
		}
	}
	
	public String getQuestion() {
		return "What is " + a + " - " + b +" ?";
	}
	
	public void showQuestion() {
		System.out.printf("What is %2d - %2d ? ", a,b);
	}
	
	public int getCorrectAnswer() {
		return a - b;
	}
}
