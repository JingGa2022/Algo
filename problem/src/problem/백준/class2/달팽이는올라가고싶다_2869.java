package problem.백준.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 달팽이는올라가고싶다_2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());//올라가는 높이
		int B = Integer.parseInt(st.nextToken());//내려가는 길이
		int V = Integer.parseInt(st.nextToken());//나무의 높이
		int day = (V - B) / (A - B);

		if((V - B) % (A - B) !=0) day ++;
		
		System.out.println(day);
	}
}
