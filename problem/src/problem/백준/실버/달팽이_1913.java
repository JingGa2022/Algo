package problem.백준.실버;

import java.util.Scanner;

public class 달팽이_1913 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int goal = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        int x = n/2+1; int y = n/2+1;
        int num = 1; int d = 0; int cnt = 1;
        arr[x][y] = num;

        while(x >= 1 && y >= 1){

            switch (d){
                case 0 :
                    if(x-1 >= n/2 +1 - cnt){
                        x--;
                    }else {
                        d++;
                        continue;
                    }
                    break;
                case 1:
                    if(y+1 <= n/2 +1 + cnt){
                        y++;
                    }else {
                        d++;
                        continue;
                    }
                    break;
                case 2:
                    if(x+1 <= n/2 +1 + cnt){
                        x++;
                    }else {
                        d++;
                        continue;
                    }
                    break;
                case 3:
                    if(y-1 >= n/2 +1 - cnt){
                        y--;
                    }else {
                        cnt++;
                        d = 0;
                        continue;
                    }
                    break;
            }
            arr[x][y] = ++num;
        }
        StringBuilder sb2 = new StringBuilder();
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n ;j++){
                sb2.append(arr[i][j] + " ");
                if(arr[i][j] == goal){
                    sb.append(i + " " + j);
                }
            }
            sb2.append("\n");
        }
        sb2.append(sb);

        System.out.println(sb2);
    }
}
