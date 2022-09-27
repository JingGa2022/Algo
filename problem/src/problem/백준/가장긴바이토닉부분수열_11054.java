package problem.백준;

import java.util.Scanner;

public class 가장긴바이토닉부분수열_11054 {
	static int[] arr;
	static Integer[] dpU, dpD;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n];
		
		for(int i = 0; i<n ;i++) arr[i] = sc.nextInt();
		
		dpU = new Integer[n];
		dpD = new Integer[n];
		
		for(int i = 0; i<n; i++) {
			DPU(i);
			DPD(i);
		}
		
		int ans = 0;
		
		for(int i = 0 ; i<n ;i++) {
			int sum = dpU[i] + dpD[i];
			if(sum > ans) ans = sum;
		}
		
		System.out.println(ans-1);
	}

	private static int DPD(int a) {
		// TODO Auto-generated method stub
		if(dpD[a]==null) {
			dpD[a] = 1;
			
			for(int i = a +1; i<n; i++) {
				if(arr[a] > arr[i])
				dpD[a] = Math.max(dpD[a], DPD(i) + 1);
			}
		}
		return dpD[a];
	}

	private static int DPU(int a) {
		// TODO Auto-generated method stub
			if(dpU[a] == null) {
				dpU[a] = 1;
				
				for(int i = a - 1; i>=0; i--) {
					if(arr[i] < arr[a])
						dpU[a] = Math.max(dpU[a], DPU(i) + 1);
				}
			}
			return dpU[a];
		}
}
