import java.util.Scanner;

public class 커트라인_25305 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int arr[] = new int[n];
		int count[] = new int[10001];
		int rank[] = new int[n];
		int max = 0;
		
		for(int i = 0; i<n; i++) {
			int tmp = sc.nextInt();
			arr[i] = tmp;
			max = Math.max(max, tmp);
		}
		for(int i = 0; i<n; i++) {
			count[arr[i]]++;
		}
		
		for(int i = 0; i<max; i++) {
			count[i+1] += count[i];
		}
		for(int i = n-1; i>=0; i--) {
			int tmp = arr[i];
			count[tmp]--;
			rank[count[tmp]] = tmp;
		}
		System.out.println(rank[n-k]);
	}
}
