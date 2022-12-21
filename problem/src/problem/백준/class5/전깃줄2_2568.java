package problem.백준.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class 전깃줄2_2568 {
	static int n;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] index;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        index = new int[n];
        arr = new int[n][2];
        list.add(0);

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        sb.append(LIS() + "\n");

        int idx = list.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = n -1; i>=0; i--){
            if(index[i] == idx) idx--;
            else stack.add(arr[i][0]);
        }

        while(!stack.empty()) sb.append(stack.pop() + "\n");

        System.out.println(sb);
    }
    private static int LIS(){
        for(int i = 0; i<n; i++){
            if(list.get(list.size() - 1) < arr[i][1]){
                list.add(arr[i][1]);
                index[i] = list.size()-1;
            }else{
                int left = 1;
                int right = list.size()-1;

                while(left < right){
                    int mid = (left + right)/2;

                    if(list.get(mid) < arr[i][1]){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                list.set(right, arr[i][1]);
                index[i] = right;
            }

        }
        return n - (list.size() - 1);
    }
}