package problem.APS심화;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 보물상자비밀번호_모의SW역량테스트 {
	static int N, K;
	static LinkedList<Character> arr;
	static int max;
	static List<Integer> sArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new LinkedList<>();
			max = 0;
			sArr = new ArrayList<>();
			String tmp = sc.next();
			
			for(int i =0; i<N; i++) arr.add(tmp.charAt(i));
			
			for(int i =0; i<N; i++) {
				rotate();
				
				for(int j = 0; j<4; j++) {
					String temp = "";
					for(int h = j*(N/4); h<N/4 + j*(N/4); h++) {
						temp += arr.get(h); // N/4개씩 자르기
					}
					sArr.add(Integer.parseInt(temp, 16)); //N/4개씩 자르기
				
				}
				
			}
			Set<Integer> set = new HashSet<>(sArr);
			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list, Collections.reverseOrder());
			
			System.out.println("#"+tc+" "+list.get(K-1));
		}
	}//main
	
	static void rotate() {
		arr.addFirst(arr.getLast());
		arr.removeLast();
	}
	
}
