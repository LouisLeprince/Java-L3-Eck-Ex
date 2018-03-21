package EE57;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class UnionQuestion implements SetQuestion{
	
	private List<Integer> u, v, r;
	
	public UnionQuestion(int u_length, int v_length) {
		
		List<Integer> u = new ArrayList<Integer>();
		List<Integer> v = new ArrayList<Integer>();
		List<Integer> r = new ArrayList<Integer>();

		for(int i = 0; i < u_length; i++){
			u.add((int) ((Math.random()*9)+1));
			r.add(u.get(i));
		}
		for(int i =0; i < v_length; i++){
			v.add((int) ((Math.random()*9)+1));
			r.add(v.get(i));
		}
		
		Collections.sort(r);
		
		this.u = u;
		this.v = v;
		this.r = NoDup(r);
			
	}
		
	public String getQuestion() {
		return "What is the set for " + u.toString() + " union " + v.toString() + " ?";
	}
		
	public void showQuestion() {
		System.out.print("What is " + u.toString() + " union " + v.toString() + " ? ");
	}
		
	public List<Integer> getCorrectAnswer() {
		return r;
	}
	
	public boolean isCorrectAnswer(List<Integer> answer) {
		int k = 0;
		boolean isCorrect = true;
		
		Collections.sort(answer);
		
		for(int i = 0; i < r.size(); i++){
			for(int j = 0; j < answer.size(); j++){
				if(r.get(i) == answer.get(j)){
					k += 1;
				}
			}
		}
		
		if(k != r.size()){
			isCorrect = false;
		}
		
		return isCorrect;
	}
	
	private static List<Integer> NoDup(List<Integer> r) {

		List<Integer> result = new ArrayList<Integer>();
		boolean duplicate;
		
		for(int i = 0; i < r.size(); i++){
			int val = r.get(i);
			duplicate = false;
			for(int j = 0; j < result.size(); j++){
				if(result.get(j) == val){
					duplicate = true;
				}
			}
			if(duplicate == false){
				result.add(val);
			}
		}
		
		return result;
	}
}

