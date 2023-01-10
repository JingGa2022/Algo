package problem.백준.골드;

import java.util.Scanner;

public class 컨베이어벨트위의로봇_20055 {
	   static int n, k;
	    static int ans = 0;
	    static int[] belt, robot;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        n = sc.nextInt();
	        k = sc.nextInt();

	        belt = new int[n*2];
	        robot = new int[n];

	        for(int i = 0; i<n*2; i++) belt[i] = sc.nextInt();

	        while(goOn()){
	            conveyor();
	            if(belt[0] > 0) {
	                robot[0] = 1;
	                belt[0]--;
	            }
	        }

	        System.out.println(ans);
	    }
	    static private void conveyor(){
	        int b = belt[2*n-1];
	        ans++;

	        for(int i = 2*n-1; i>0; i--){
	            belt[i] = belt[i-1];

	            if(i >= n) continue;
	            robot[i] = robot[i-1];
	            robot[i-1] = 0;
	        }
	        robot[n-1] = 0;
	        belt[0] = b;

	        for(int i = n-1; i>0; i--){
	            if(belt[i] > 0 && robot[i] == 0 && robot[i-1] == 1){
	                robot[i] = robot[i-1];
	                robot[i-1] = 0;
	                belt[i]--;
	            }
	        }

	    }

	    static private boolean goOn(){
	        int cnt = 0;
	        for(int i = 0; i<2*n; i++){
	            if(belt[i] == 0) cnt++;
	            if(cnt >= k) return false;
	        }
	        return true;
	    }
}
