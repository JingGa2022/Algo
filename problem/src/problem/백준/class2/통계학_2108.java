package problem.백준.class2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 통계학_2108 {
	static int mean, mid, mode, range;//평균, 중간값, 최빈값, 범위
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] num = new int[8001];//4001부터 8000는 -1~ -4000
		List<Integer> list = new ArrayList<>();//중앙값 구하기용
		double sum = 0;
		
		for(int i = 0; i<N; i++) {
			int tmp = sc.nextInt();
			list.add(tmp);
			sum += tmp;
			if(tmp < 0) {
				num[-tmp+4000]++;
			}
			else {
				num[tmp]++;
			}
		}
		
		//평균
		mean = (int) Math.round(sum/N);
		
		//중앙값
		Collections.sort(list);
		mid = list.get(N/2);
		
		//최빈값
		int max = 1;
		List<Integer> list2 = new ArrayList<>();//최빈값 구하기용
		for(int i = 0; i<8001; i++) {
			if(num[i]>max) {
				list2 = new ArrayList<>();//최빈값 구하기용		
				max = num[i];
				if(i>4000)
					list2.add(-(i-4000));
				else
					list2.add(i);
			}else if(num[i] == max)
				if(i>4000)
					list2.add(-(i-4000));
				else
					list2.add(i);
		}
		Collections.sort(list2);
		if(list2.size()>1)
			mode = list2.get(1);
		else
			mode = list2.get(0);
		
		//범위
		range = list.get(N-1) - list.get(0);
		
		System.out.println(mean);
		System.out.println(mid);
		System.out.println(mode);
		System.out.println(range);
	}//main
}
