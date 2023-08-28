package problem.백준.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Line{
	int s;
	int e;
	
	Line(int s, int e){
		this.s = s;
		this.e = e;
	}
}
public class 선긋기_2170 {
	/* 1. 시작 부분 끝 부분 정렬하고
	 * 2. 모든 원소를 비교 원소의 시작 <= 마지막 끝 
	 * 3. 끝나면 다음 원소 뭉텅이 비교
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Line[] line = new Line[n];
		
		for(int i = 0 ; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			line[i] = new Line(s,e);
		}
		
		Arrays.sort(line, (l1, l2) -> l1.s == l2.s ? l1.e - l2.e : l1.s - l2.s);
		
		int idx = 0;
		int sum = 0;
		
		while(idx < n) {
			int s = line[idx].s;
			int e = line[idx].e;
			
			while(++idx < n) {
				if(line[idx].s <= e) {
					e = Integer.max(e, line[idx].e);
				}else 
						break;
			}
			sum += (e - s);
		}
		
		bw.write(sum + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
