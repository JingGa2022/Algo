package problem.프로그래머스;

import java.util.Scanner;

public class 문자열압축 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		solution(s);
	}
	static private int solution(String s) {
        int answer = s.length();
        int cnt = 1;
        for(int i = 1; i<= s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i);
            for(int j = i; j <= s.length(); j+=i){
                int idx = Math.min(j + i, s.length());
                String sub = s.substring(j, idx);
                
                if(base.equals(sub)){
                    cnt++;
                }else{
                    if(cnt >= 2){
                        sb.append(cnt);
                    }
                    sb.append(base);
                    base = sub;
                    cnt = 1;
                }               
            }
            sb.append(base);
                answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
