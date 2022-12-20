package problem.백준.class5;

import java.util.Scanner;

public class 용액_2467 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int pl = 0;
        int pr = n-1;
        int min = Integer.MAX_VALUE;
        int ansr = 0;
        int ansl = 0;

        for(int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        while(pl < pr){
            int sum = arr[pl] + arr[pr];

            if(Math.abs(sum) <= min) {
                min = Math.abs(sum);
                ansr = pr;
                ansl = pl;
            }
            if(sum == 0){
                break;
            }else if(sum > 0){
                pr--;
            }else pl++;
        }
        System.out.println(arr[ansl] + " " + arr[ansr]);
    }
}
