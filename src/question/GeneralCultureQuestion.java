package question;

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
	
	public int getCorrectAnswer() {
		return answer;
	}
}
