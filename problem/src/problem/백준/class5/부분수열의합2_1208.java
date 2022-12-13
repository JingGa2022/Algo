package problem.백준.class5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 부분수열의합2_1208 {
	static int n, s;
    static long ans;
    static int [] arr;
    static ArrayList<Long> left = new ArrayList<>();
    static ArrayList<Long> right = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];

        for(int i = 0; i<n; i++) arr[i] = sc.nextInt();

        partsum(0, n/2, 0,left);
        partsum(n/2 ,n, 0, right);

        Collections.sort(left);
        Collections.sort(right);

        meetInMiddle();
        if(s == 0) ans--;

        System.out.println(ans);
    }
    private static void partsum(int s, int e, long sum, List<Long> al){
        if(s == e) {
            al.add(sum);
            return;
        }
        partsum(s+1, e, sum + arr[s], al);
        partsum(s+1, e, sum, al);
    }

    private static void meetInMiddle(){
        int idxl = 0;
        int idxr = right.size() - 1;

        while(idxl < left.size() && idxr >= 0){
            long sum = left.get(idxl) + right.get(idxr);

            if(sum > s){
                idxr--;
            }else if(sum < s){
                idxl++;
            }else{
                long tmp1 = left.get(idxl);
                long cnt1 = 0;
                while(idxl < left.size() && left.get(idxl) == tmp1){
                    cnt1++;
                    idxl++;
                }
                long tmp2 = right.get(idxr);
                long cnt2 = 0;
                while(idxr >= 0 && tmp2 == right.get(idxr)){
                    cnt2++;
                    idxr--;
                }
                ans += cnt1 * cnt2;
            }
        }

    }
}