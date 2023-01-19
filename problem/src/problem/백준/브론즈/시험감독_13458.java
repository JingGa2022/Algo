package problem.백준.브론즈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 시험감독_13458 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());// 시험장 수
		int arr[] = new int[n];// 응시자 수

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());// 총감독관의 능력
		int c = Integer.parseInt(st.nextToken());// 부감독관의 능력

		long ans = n;

		for (int i = 0; i < n; i++) {

			arr[i] -= b;

			if (arr[i] <= 0)
				continue;

			ans += arr[i] / c;
			if (arr[i] % c != 0)
				ans++;
		}

		System.out.println(ans);
	}
}
