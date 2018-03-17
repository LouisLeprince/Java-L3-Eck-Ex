package question;

public class DivisionQuestion implements IntQuestion {
	
	private int a, b;
	
	public DivisionQuestion() {
		a = (int) Math.random()*10;
		b = (int) Math.random()*10;
		if(a < b){
			int swipe = b;
			b = a;
			a = swipe;
		}
	}
	
	public String getQuestion() {
		return "What is " + a + " / " + b + " ? : ";
	}
	
	public int getCorrectAnswer() {
		return a / b;
	}

}
