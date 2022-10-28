package problem.백준.class4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 별찍기11_2448_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		List<String> s = new ArrayList<>(n);

		s.add("  *  ");
		s.add(" * * ");
		s.add("*****");
		
		
		for(int i = 1 ; 3 * (int)Math.pow(2, i) <= n; i++) star(s);
		
		for(String line : s) System.out.println(line);
	
	}
	// x y는 꼭대기 별의 위치 이를 기반으로 세 번을 돌림
	private static void star(List<String> p) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		int pSize = p.size();
		
		for(int i = 0; i < pSize; i++) {
			sb.delete(0, sb.length());
			
			//전단계의 그림
			sb.append(p.get(i));
			sb.append(" ");
			sb.append(p.get(i));
			
			p.add(sb.toString());
			
			sb2.delete(0, sb2.length());
			for(int j = 0; j<pSize; j++) sb2.append(" ");
			p.set(i, sb2.toString() + p.get(i) + sb2.toString());
		}
		
	}
}
