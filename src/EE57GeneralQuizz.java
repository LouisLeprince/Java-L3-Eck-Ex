import question.*;

public class EE57GeneralQuizz {
	
	private static IntQuestion[] quizz_questions;
	
	public static void Main() {
		System.out.printf("test");
		createQuizz();
		askQuizz();
	}

	private static void createQuizz() {
		quizz_questions = new IntQuestion[10];
		for(int i = 0; i < 7; i++){
			quizz_questions[i] = new AdditionQuestion();
		}
		quizz_questions[7] = new GeneralCultureQuestion("question",4);
		quizz_questions[8] = new GeneralCultureQuestion("question",5);
		quizz_questions[9] = new GeneralCultureQuestion("question",6);
	}
	
	private static void askQuizz() {
		for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("Question %2d:  %s ",
                                  questionNum, "ola");
        }
	}
}
