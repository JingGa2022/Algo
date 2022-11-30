package problem.백준.class4;

import java.util.Scanner;

public class 시그마_13172 {
	final static int MOD = 1000000007;
    static int m, n, s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        long ans = 0;

        for(int t = 0 ; t<m;t++){

            n = sc.nextInt();
            s = sc.nextInt();

            long g = gcd(n,s);
            n /= g;
            s /= g;

            ans += (s * power(n, MOD - 2)) % MOD;
        }
        System.out.println(ans % MOD);

    }

    private static long power(int n, int s) {
            if(s == 1) return n;
            if(s % 2 != 0) return n * power(n, s-1) % MOD;
            long let = power(n, s/2);
       return let * let % MOD;
    }
    private static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}