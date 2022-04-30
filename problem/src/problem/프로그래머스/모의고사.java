package problem.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;

import problem.APS심화.Solution;

public class 모의고사 {
	public static void main(String[] args) {
		int[] aaa = {1,2,3,4,5};
		System.out.println(Arrays.toString(solution(aaa)));
	}
	static public int[] solution(int[] answers) {
		int[] answer = {};
		int[] person1 = {1, 2, 3, 4, 5};
		int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int ans1 = 0; int ans2 = 0; int ans3 = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i = 0; i< answer.length; i++){
			if(person1[i%person1.length] == answer[i]) ans1++;
			else  if(person2[i%person2.length] == answer[i]) ans2++;
			else  if(person3[i%person3.length] == answer[i]) ans3++;
			
			//최대값을 구해보자
			int max = Math.max(Math.max(ans1, ans2),ans3);
			if(max == ans1)   ans.add(ans1);
			else if(max == ans2) ans.add(ans2);
			else if(max == ans3) ans.add(ans3);
		}
		
		answer = new int[ans.size()];
		
		for(int id = 0; id<ans.size(); id++) answer[id] = ans.get(id);
		
		return answer;
	}
}

