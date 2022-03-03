package problem;

import java.util.Scanner;

//빈문자열로 뒤에서 부터 쓰기
public class 초심자의_회문_검사_1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//변수
		int T = sc.nextInt();
		//반복문으로 순서 바꾸기
		for(int tc = 1; tc <= T; tc++) {
			//뒤집은 문자열
			String letter = sc.next();
			String reverse = "";
			for(int i = letter.length()-1; i >= 0; i--) {
				reverse += letter.charAt(i);
			}
			System.out.printf("#%d %d\n", tc ,isEqual(letter, reverse));
		}
	}
	//글자가 같은지 알려주는 메서드
	public static int isEqual(String letter, String reverse) {
	if(reverse.equals(letter)) {
		return 1;
	}else return 0;}
}
