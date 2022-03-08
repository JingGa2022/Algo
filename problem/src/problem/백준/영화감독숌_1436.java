package problem.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.util.StringTokenizer;

public class 영화감독숌_1436 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//몇번째작은 수인지
		int num = 0; //개수저장
		int doom = 666;//종말의 수
		String str = null; //종말의 수 판별용 변수
		
		Outer : while(true) {
			str = Integer.toString(doom);
			for(int i =0; i<str.length()-2; i++) {
				if(str.charAt(i) == '6' && str.charAt(i+1)=='6' && str.charAt(i+2)=='6') {
					num++;
					if(num==N) break Outer;
					break;
				}
			}
			doom++;
		}
		System.out.println(doom);
	}//main
}
