import EE57.*;

import java.util.Scanner;
import java.util.ArrayList;

public class EE57GeneralQuizz {
	
	private static IntQuestion[] quizz_questions;
	private static SetQuestion[] bonus_question;
	private ArrayList<ArrayList<Integer>> userAnswers;
	private ArrayList<ArrayList<Integer>> bonusAnswers;
	
	public static void main(String[] args) {
		EE57GeneralQuizz Quiz = new EE57GeneralQuizz();
        Quiz.createQuiz();
		Quiz.presentationQuiz();
        Quiz.askQuiz();
        Quiz.evalQuiz();
    }
	
	private void presentationQuiz(){
        System.out.println();
        System.out.println("Welcome to the quiz");
        System.out.println();
        System.out.println("There are some math questions and a few non-math");
        System.out.println("questions, but the answer to every question is");
        System.out.println("an integer.");
        System.out.println("The quiz is grade over 120 points, each correct");
        System.out.println("answer give you 10 points (10 questions).");
        System.out.println("There is also two bonus questions on 20 points.");
        System.out.println("You have 5 second to answer a question (don't apply");
        System.out.println("for bonus question), beyond you get two malus point.");
        System.out.println();
	}

	private void createQuiz() {
		
		int operationType;
		quizz_questions = new IntQuestion[10];
		bonus_question = new SetQuestion[2];
		for(int i = 0; i < 7; i++){
			operationType = (int) (Math.random()*4);
			switch (operationType){
				case 0 : quizz_questions[i] = new AdditionQuestion();
					break;
				case 1 : quizz_questions[i] = new SubstractionQuestion();
					break;
				case 2 : quizz_questions[i] = new MultiplicationQuestion();
					break;
				case 3 : quizz_questions[i] = new DivisionQuestion();
					break;
			}
		}
		quizz_questions[7] = new GeneralCultureQuestion("How many states are there in the United States?", 50);
		quizz_questions[8] = new GeneralCultureQuestion("In what year did the First World War begin?", 1914);
		quizz_questions[9] = new GeneralCultureQuestion("What is the answer to the ultimate question " +
                										"of life, the universe, and everything?",42);
		
		bonus_question[0] = new UnionQuestion(4,5);
		bonus_question[1] = new IntersectionQuestion(3,6);
	}
	
	private void askQuiz() {
		ArrayList<ArrayList<Integer>> userAnswers = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> bonusAnswers = new ArrayList<ArrayList<Integer>>();
        
        int questionNum;
        Scanner scn = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			long debut = System.currentTimeMillis();
			ArrayList<Integer> answer = new ArrayList<Integer>();
            questionNum = i + 1;
    		System.out.printf("Question %2d: ", questionNum);
            quizz_questions[i].showQuestion();
            answer.add(scn.nextInt());
            answer.add((int) ((System.currentTimeMillis()-debut)/1000));
            userAnswers.add(i, answer);
        }
		
		int val = 0;
		for (int i = 0; i < 2; i++) {
            questionNum = i + 1;
			ArrayList<Integer> answer = new ArrayList<Integer>();
			System.out.printf("Bonus Question %2d: ", questionNum); 
	        bonus_question[i].showQuestion(); System.out.println();
			System.out.print("Enter 0 as a value when you finished."); System.out.println();
	        int k = 0;
	        do{
	        	System.out.printf("%4sUnion of the sets value n¡%2d: ","", k + 1);
	        	val = scn.nextInt();
	        	if(val !=0){
	        		answer.add(val);
	        	}
	            k += 1;
	        }while((k < 9) & (val != 0));
	        bonusAnswers.add(i, answer);
	        System.out.println();
        }
		
		this.userAnswers = userAnswers;
		this.bonusAnswers = bonusAnswers;
		
	}
	
	private void evalQuiz() {
		int userScore = 0;
		int userBonusScore = 0;
		int userTimeMalus = 0;
		System.out.println("Here are the correct answers :"); System.out.println();
		for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            
			boolean isCorrect = ((userAnswers.get(i)).get(0) == quizz_questions[i].getCorrectAnswer());
            boolean timeMalus = ((userAnswers.get(i)).get(1) > 5);
            
    		System.out.printf("Question %2d: %s", questionNum, quizz_questions[i].getQuestion()); System.out.println();
            System.out.printf("%4sCorrect answer : %d", "", quizz_questions[i].getCorrectAnswer()); System.out.println();
            
            if (isCorrect == true) {
            	userScore += 1;
            	System.out.printf("%4sYou were CORRECT.",""); System.out.println();
            }else{
            	System.out.printf("%4sYou said %d, which is INCORRECT.","",(userAnswers.get(i)).get(0)); System.out.println();
            	
            }
            
            System.out.printf("%4sYou responded in %ss.","",(userAnswers.get(i)).get(1));
        	if(timeMalus == true){ 
        		System.out.printf("Therefore, you got a malus points.","");
        		userTimeMalus += 1; 
        	}
        	System.out.println(); System.out.println();
        }
		
		for (int i = 0; i < 2; i++) {
            int bonusQuestionNum = i + 1;
			boolean isCorrect = bonus_question[i].isCorrectAnswer(bonusAnswers.get(i));
            
			System.out.printf("Bonus Question %2d: ", bonusQuestionNum); 
			System.out.println(bonus_question[i].getQuestion());
            System.out.printf("%4sCorrect answer : %s", "", bonus_question[i].getCorrectAnswer().toString()); System.out.println();
            if (isCorrect == true) {
            	userBonusScore += 1;
            	System.out.printf("%4sYou said %s, which is CORRECT.","",bonusAnswers.get(i).toString()); System.out.println();
            }else{
            	System.out.printf("%4sYou said %s, which is INCORRECT.","",bonusAnswers.get(i).toString()); System.out.println();
            }
            System.out.println();
        }
		
        System.out.println("You got " + userScore + " questions correct.");
        System.out.println("You got " + userTimeMalus + " time malus points.");
        System.out.println("You got " + userBonusScore + " bonus questions correct.");
        System.out.println("You grade on the quizz is " + (userScore * 10 + userBonusScore *10 - userTimeMalus * 2) + "/120");
	}
}
