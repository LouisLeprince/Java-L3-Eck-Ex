package EE57;

public class GeneralCultureQuestion implements IntQuestion {
	
	private String question;
	private int answer;
	
	public GeneralCultureQuestion(String question, int answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void showQuestion(){
		System.out.print(question);
		System.out.print(" ");
	}
	
	public int getCorrectAnswer() {
		return answer;
	}
}
