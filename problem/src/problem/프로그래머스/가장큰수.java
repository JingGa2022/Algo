package problem.프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
	static boolean[] visited;
	public static void main(String[] args) {
		int[] num = {3, 30, 34, 5, 9};
		
		System.out.println(solution(num));
	}//main
	
	 public static String solution(int[] numbers) {
	        String answer = "";
	       String[] str = new String[numbers.length];
	        
	        //int를 String으로 변환
	        for(int i =0; i < numbers.length; i++) {
	        	str[i] = String.valueOf(numbers[i]);
	        }
	        
	        //내림차순 정렬
	        Arrays.sort(str, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return (o2+o1).compareTo(o1+o2);
				}
			});
	        
	        if(str[0].equals("0")) return "0";
	        
	        for(String s : str) answer += s;
	        
	        return answer;
	    }//solution
	 
	
}
