package problem.백준.class5;

import java.util.Scanner;

public class 부분합_1806 {
	static int n, s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();
        int ans = Integer.MAX_VALUE;
        int[] arr = new int[n+1];
        for(int i = 0 ; i<n; i++) arr[i] = sc.nextInt();

        int pl = 0; int pr = 0;
        int sum = 0;

        while(true){
            if(pl > n || pr > n) break;
            if(sum >= s && ans > pr - pl) ans = pr - pl;

            if(sum > s){
                sum -= arr[pl];
                pl++;
            }else {
                sum += arr[pr];
                pr++;
            }
        }

        if(ans == Integer.MAX_VALUE) ans = 0;

        System.out.println(ans);
    }
}