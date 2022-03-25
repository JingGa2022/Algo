package problem.백준;

import java.util.Scanner;

public class 나이순정렬_10814 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] age = new int[N+1];
		String[] box = new String[N+1];
		String[] box2 = new String[N+1];
		int[] idx = new int[201];
		int[] age2 = new int[N+1];
		for(int i =1; i<=N; i++) {				
				age[i] = sc.nextInt();
				box[i] = sc.next();
		}
		for(int i = 1; i<=N; i++){
			idx[age[i]] ++;
		}
		for(int i = 1; i<201; i++) {
			idx[i] += idx[i-1];
		}
		for(int i = N; i>=1; i--) {
			int v = age[i];
			age2[idx[v]] = v;
			box2[idx[v]] = box[i];
			idx[v]--;
		}
		
		for(int i = 1; i<=N; i++) {
			sb.append(age2[i]).append(" ");
			sb.append(box2[i]).append("\n");
		}
		System.out.println(sb);
	}//main
}
