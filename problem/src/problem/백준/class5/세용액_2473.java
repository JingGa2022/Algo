package problem.백준.class5;

import java.util.Arrays;
import java.util.Scanner;

public class 세용액_2473 {
	static int n;
    static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new long[n];
        long[] ans = new long[3];

        for(int i = 0 ; i<n; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        for(int i = 0 ; i<n-2; i++){
            int left = i+1;
            int right = n-1;
            while(left < right){
                long sum = arr[left] + arr[right] + arr[i];

                if(Math.abs(sum) < min){
                    min = Math.abs(sum);
                    ans[0] = arr[left];
                    ans[1] = arr[right];
                    ans[2] = arr[i];
                }
                    if(sum < 0){
                        left++;
                    }else if(sum > 0){
                        right--;
                    }else{
                        break;
                    }

            }
        }

        Arrays.sort(ans);

        System.out.printf("%d %d %d",ans[0] ,ans[1] ,ans[2]);
    }
}
