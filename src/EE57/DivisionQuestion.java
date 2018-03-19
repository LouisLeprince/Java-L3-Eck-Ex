package EE57;

public class DivisionQuestion implements IntQuestion {
	
	private int a, b, r;
	
	public DivisionQuestion() {
		r = (int) (Math.random()*10 + 1);
		b = (int) (Math.random()*10 + 1);
		a = r * b;
	}
	
	public String getQuestion() {
		return "What is " + a + " / " + b + " ?";
	}
	
	public void showQuestion() {
		System.out.printf("What is %2d / %2d ? ", a,b);
	}
	
	public int getCorrectAnswer() {
		return r;
	}

}
