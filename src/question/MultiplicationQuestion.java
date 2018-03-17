package question;

public class MultiplicationQuestion implements IntQuestion {
	
	private int a, b;
	 
	public MultiplicationQuestion(){
		a = (int) Math.random()*10;
		b = (int) Math.random()*10;
	}
	
	public String getQuestion(){
		return "What is " + a + " x " + b +" ? : ";
	}
	
	public int getCorrectAnswer(){
		return a * b;
	}
}
