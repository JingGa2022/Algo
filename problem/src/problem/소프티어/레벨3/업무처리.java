package problem.소프티어.레벨3;

import java.util.Arrays;
import java.util.Scanner;

public class 업무처리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        int arr[][] = new int[4][n];
        int copy[][] = new int[4][n];
        int score[][] = new int[4][3001];

        for(int i =0; i<3; i++){
            for(int j = 0; j<n; j++) {
                arr[i][j] = sc.nextInt();
                arr[3][j] += arr[i][j];

                copy[i][j] = arr[i][j];
                copy[3][j] = arr[3][j];
            }
        }

        for(int i = 0; i<4; i++) Arrays.sort(copy[i]);

        for(int i =0; i<4; i++){
            int idx = n;
            for(int j = 0; j<n; j++) {
                int num = copy[i][j];
                score[i][num] = idx; 
                idx--;
                }
            }

        for(int i =0; i<4; i++){
            for(int j = 0; j<n; j++) {
                int num = arr[i][j];
                sb.append(score[i][num] + " ");
            }
            sb.append("\n");
        }

      System.out.println(sb);
	}
}
