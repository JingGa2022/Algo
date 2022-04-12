package problem.APS심화;

import java.util.Scanner;

public class 숫자를정렬하자_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			int[] box = new int[N];
			
			for(int i=0; i<N; i++) box[i] = sc.nextInt();
			
			quickSort(box, 0, N-1);
			
			System.out.print("#"+tc);
			for(int i=0; i<N; i++)
			System.out.print(" "+box[i]);
			System.out.println();
		}
	}//main
	static void quickSort(int[] A, int l, int r){
		if(l<r) {
			int pivot = partition(A, l, r);
			quickSort(A, l, pivot - 1);
			quickSort(A, pivot +1, r);;
		}
	}
	
	private static int partition(int[] a, int left, int right) {
		int pivot = a[left];
		int L = left+1;
		int R = right;
		while(L <=R) {
			while(L <= R && a[L] <= pivot) L++;
			while(a[R] > pivot) R--;
			if(L < R)
				swap(a, L, R);
		}
		swap(a, left, R);
		
		return R;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
}
