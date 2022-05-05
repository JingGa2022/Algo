package problem.프로그래머스;

import java.util.Arrays;

public class 완주하지못한선수 {
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < completion.length; i++) {
			if (!completion[i].equals(participant[i])) {
				answer = participant[i];
				break;
			}
			answer = participant[i + 1];
		}

		return answer;
	}
}
