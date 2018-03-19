package EE57;

public class MultiplicationQuestion implements IntQuestion {
	
	private int a, b;
	 
	public MultiplicationQuestion(){
		a = (int) (Math.random()*10 + 1);
		b = (int) (Math.random()*10 + 1);
	}
	
	public String getQuestion(){
		return "What is " + a + " x " + b +" ? : ";
	}
	
	public void showQuestion() {
		System.out.printf("What is %2d * %2d ? ", a,b);
	}
	
	public int getCorrectAnswer(){
		return a * b;
	}
}
