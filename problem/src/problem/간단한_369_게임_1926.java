package problem;

import java.util.Scanner;

public class 간단한_369_게임_1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String input = "";
//		숫자 입력받기
		for(int i = 1; i<=N; i++) {
			int cnt = 0;
			//숫자
			String num = Integer.toString(i);
			for(int j = 0; j<num.length(); j++) {
				if(num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
					cnt++;		
				}
			}
			if(cnt == 1) input += "- ";
			else if(cnt == 2) input +="-- ";
			else if(cnt == 3) input +="--- ";
			if(!num.contains("3") && !num.contains("6") && !num.contains("9")) 
			input += (num + " ");}
		//출력
		System.out.println(input);
	}
}
