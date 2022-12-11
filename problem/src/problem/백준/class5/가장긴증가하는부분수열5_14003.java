package problem.백준.class5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 가장긴증가하는부분수열5_14003 {
	 static int n, ans;
	    static int[] arr, index;
	    static ArrayList<Integer> track = new ArrayList<>();
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        StringBuilder sb = new StringBuilder();

	        n = sc.nextInt();
	        arr = new int[n];
	        index = new int[n];

	        track.add(Integer.MIN_VALUE);

	        for(int i = 0; i<n; i++) {
	            arr[i] = sc.nextInt();
	        }

	       for(int i = 0; i<n; i++){
	           int num = arr[i];
	           int left = 1;
	           int right = track.size() - 1;

	           if(num > track.get(track.size()-1)){
	               track.add(num);
	               index[i] = track.size() - 1;
	           }else{
	               while(left < right){
	                   int mid = (left + right) / 2;
	                   if(track.get(mid) >= num) right = mid;
	                   else left = mid + 1;
	               }
	               track.set(right, num);
	               index[i] = right;
	           }
	       }

	       sb.append(track.size()-1 + "\n");

	       int idx = track.size()-1;
	        Stack<Integer> st = new Stack<>();

	       for(int i = n-1; i>=0; i--){
	           if(idx != index[i]) continue;
	           idx --;
	           st.add(arr[i]);
	       }

	       while(!st.empty()) sb.append(st.pop() + " ");

	        System.out.println(sb);
	    }
	}