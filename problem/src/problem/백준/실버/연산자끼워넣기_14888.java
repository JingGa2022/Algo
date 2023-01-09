package problem.백준.실버;

import java.util.Scanner;

public class 연산자끼워넣기_14888 {
	static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] num, operator;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        n = sc.nextInt();
        num = new int[n];
        operator = new int[4];

        for(int i = 0; i<n; i++) num[i] = sc.nextInt();
        for(int i = 0; i<4; i++) operator[i] = sc.nextInt();

        calc(1, num[0], operator);

        System.out.println(max);
        System.out.println(min);
    }
    static private void calc(int cnt, int result, int[] arr){
        if(cnt == n){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for(int i = 0; i<4; i++){
            if(arr[i] == 0) continue;
            arr[i] --;
            if(i == 0){
                calc(cnt+1, result+num[cnt], arr);
            }else if(i == 1){
                calc(cnt+1, result-num[cnt], arr);
            }else if (i == 2) {
                calc(cnt+1, result*num[cnt], arr);
            }else{
                calc(cnt+1, result/num[cnt], arr);
            }
            arr[i]++;
        }
    }
}
