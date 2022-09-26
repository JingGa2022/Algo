package problem.백준;

import java.util.Scanner;

public class 가장긴바이토닉부분수열_11054 {
	static int[] dpU, dpD, arr;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n+1];
		
		for(int i = 1; i<=n ;i++) arr[i] = sc.nextInt();
		
		dpU = new int[n+1];
		dpD = new int[n+1];
		
		dpU[1] = 1;
		if(arr[2] > arr[1]) dpU[2] = 2;
		else dpU[2] = 1;
		
		dpD[n] = 1;
		if(arr[n] < arr[n-1]) dpU[2] = 2;
		else dpU[2] = 1;
		
		DPU(n-2);
		DPD(1);
		
		int ans = 0;
		
		for(int i = 1 ; i<=n ;i++) {
			int sum = dpU[i] + dpD[i];
			if(sum > ans) ans = sum;
		}
		
		System.out.println(ans);
	}

	private static int DPD(int a) {
		// TODO Auto-generated method stub
		if(a < 1) return 0;
		if(arr[a] < )
		return dpD[a] = Math.max(DPD(a+1), DPD(a+2)) + 1;		
	}

	private static int DPU(int a) {
		// TODO Auto-generated method stub
		if(a < 3) return dpU[a];
		
		return dpU[a] = Math.max(DPU(a-1), DPU(a-2)) + 1;
		}
}
