package problem.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AC_5430 {
	static List<Integer> box = new ArrayList<>();
	static int[] tmp;//삭제시 잠시배열
	static String order;
	static String ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc =1; tc<=T; tc++) {
			String order = sc.next();//명령
			int n = sc.nextInt();//배열의 사이즈
			String s = sc.next();//배열 입력
			String[] tmp = s.substring(1, s.length() -1).split(",");
			
			//배열 처리
			for(int i = 0; i<n; i++)
				box.add(Integer.parseInt(tmp[i]));
			
			solve(order);
			if(box.size()>=0) {
				System.out.println(box);			
			}else
				System.out.println(ans);
		}//for
	}//main
	static void solve(String order) {
		for(int i =0; i < order.length(); i++) {
			if(order.charAt(i) == 'R') {
				reverse();
			}else if(order.charAt(i) == 'D') {
				delete();
			}
		}
	}//solve
	private static String delete() {
		int n = box.size()-1;//삭제했을 경우의 길이
		if(n<0) { 
			ans = "error";
			return ans;}
		else {
			box.remove(0);
		}
		return "";
	}
	private static void reverse() {
		int[] tmp = new int[box.size()];
		for(int i = box.size()-1, j=0 ; i >= 0; i--, j++) {
			tmp[j] = box.get(i);
		}
		for(int i = 0 ; i < box.size(); i++) {
			box.add(tmp[i]);
		}
	}//reverse
}
