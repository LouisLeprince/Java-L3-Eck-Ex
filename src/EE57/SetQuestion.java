package EE57;

import java.util.List;

public interface SetQuestion {
	public String getQuestion();
	public void showQuestion();
	public List<Integer> getCorrectAnswer();
	public void showCorrectAnswer();
	public boolean isCorrectAnswer(List<Integer> answer);
}
