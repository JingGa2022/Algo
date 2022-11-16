package problem.백준.class4;

import java.util.Scanner;

public class 피보나치수6_11444 {
	final static long MOD = 1000000007;
    public static long[][] origin = {{1,1}, {1,0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long[][] A = {{1,1}, {1,0}};

        System.out.println(pibo(A, n-1)[0][0]);
    }
    private static long[][] pibo(long[][] A, long n) {
        if(n == 1l || n == 0) return A;

        long[][] ret = pibo(A, n/2);

        ret = multiply(ret, ret);

        if(n%2 != 0) ret = multiply(ret, origin);
        return ret;
    }

    private static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] ret = new long[2][2];

        for(int k = 0; k<2; k++){
            for(int i = 0; i<2; i++){
                for(int j = 0; j<2; j++){
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}