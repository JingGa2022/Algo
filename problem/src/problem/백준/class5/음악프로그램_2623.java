package problem.백준.class5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 음악프로그램_2623 {
	static int n,m;
    static int[] degree, result;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new ArrayList[n+1];
        result = new int[n];
        degree = new int[n+1];
        for(int i = 1; i<=n; i++) arr[i] = new ArrayList<>();

        for(int i = 0; i<m; i++){
            int tmp = sc.nextInt();
            //앞자리
            int first = sc.nextInt();
            for(int j = 0; j<tmp-1; j++){
                int num = sc.nextInt();
                arr[first].add(num);
                degree[num] += 1;
                first = num;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i<=n; i++){
            if(degree[i] == 0) {
                q.add(i);
            }
        }

        for(int i = 0; i<n; i++){

            if(q.isEmpty()){
                System.out.println(0);
                return;
            }

            int x = q.poll();
            result[i] = x;

            for(int j = 0 ; j< arr[x].size(); j++){
                int y = arr[x].get(j);
                if(--degree[y] == 0) q.add(y);
            }
        }

        for(int i = 0; i<n; i++){
            sb.append(result[i] + "\n");
        }

        System.out.println(sb);
    }
}
