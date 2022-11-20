package problem.백준.class4;

import java.util.Scanner;

public class 행렬제곱_10830 {
	static int a;
    static long b;
    static long[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        a = sc.nextInt();
        b = sc.nextLong();
       arr = new long[a][a];

       for(int i = 0; i<a; i++){
           for(int j = 0; j<a; j++) arr[i][j] = sc.nextInt();
       }

       long[][] ans = calculate(arr,b);

        for(int i = 0; i<a; i++) {
            for (int j = 0; j < a; j++) {
                sb.append(ans[i][j] % 1000 +" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static long[][] calculate(long[][] object, long square) {
        if(square == 1 || square == 0) return object;

        long[][] let = calculate(object, square/2);

        let = multiply(let, let);

        if(square % 2 != 0) let = multiply(let, arr);

        return let;
    }

    private static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] tmp = new long[a][a];

        for(int k = 0; k<a; k++){
            for(int i = 0; i<a; i++){
                for(int j = 0; j<a; j++) {
                    tmp[i][j] += o1[i][k] * o2[k][j];
                    tmp[i][j] %= 1000;
                }
            }
        }
        return tmp;
    }
}