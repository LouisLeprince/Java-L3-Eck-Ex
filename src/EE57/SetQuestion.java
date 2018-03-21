package EE57;

import java.util.List;

public interface SetQuestion {
	public String getQuestion();
	public void showQuestion();
	public List<Integer> getCorrectAnswer();
	public boolean isCorrectAnswer(List<Integer> answer);
}
