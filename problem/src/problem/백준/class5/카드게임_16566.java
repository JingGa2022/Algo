package problem.백준.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드게임_16566 {
		int m,k;
		int[] card;
		int[] magic;
		
	void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		m = Integer.parseInt(tmp[1]);
		k = Integer.parseInt(tmp[2]);
		
		card = new int[m];
		magic = new int[k];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<k; i++) {
			magic[i] = Integer.parseInt(st.nextToken());
		}
		
	}
	
	int search(int n) {
		int top = m - 1;
		int down = -1;	
		while(top > down+1) {
			int mid = (top + down)/2;
			if(card[mid] > n) top = mid;
			else down = mid;
		}
		return top;
	}
	
	int find(int n, int[] arr) {
		if(arr[n] < 0) return n;
		return arr[n] = find(arr[n], arr);
	}
	
	void union(int a, int[] arr) {
		if(a + 1 >= m) return;
		arr[a] = a + 1;
	}
	
	void solution() throws IOException {
		StringBuilder sb = new StringBuilder();
		input();
		int[] arr = new int[m];
		Arrays.fill(arr, -1);
		for(int c : magic) {
			int p = search(c);
			p = find(p, arr);
			union(p, arr);
			sb.append(card[p] + "\n");
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new 카드게임_16566().solution();
	}
}
