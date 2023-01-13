package problem.프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
	public static void main(String[] args) {
		  Map<Character, Integer> map = new HashMap<>();
		  map.put('d', 123);
	       System.out.println(map.get('d'));
	       String answer = "";
	       
	       answer += "sd";
	       answer += " sd";
	       String[] arr = answer.split(" ");
	       System.out.println(arr[0]);
	}
}
