package problem.백준.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달_15686 {
	static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m,ans;
    static boolean[] open;
    static int[][] arr;
    static ArrayList<Spot> house = new ArrayList<>();
    static ArrayList<Spot> chicken = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 98567455;

        arr = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) house.add(new Spot(i, j));
                if(arr[i][j] == 2) chicken.add(new Spot(i, j));
            }
        }
        open = new boolean[chicken.size()];
//        if(m == chicken.size()) distance(chicken);
//        else {
//            ArrayList<Spot> temp = new ArrayList<Spot>();
//            choose(0, 0, temp);
//        }
        dfs(0, 0);

        System.out.println(ans);
    }
    static void dfs(int start, int cnt){
        if(cnt == m){
            int sum = 0;
            for(int i = 0; i<house.size(); i++){
                int min = 987654321;
                for(int j = 0; j<chicken.size(); j++){
                    if(open[j]){
                        int dist = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        min = Math.min(dist, min);
                    }
                }
                sum += min;
                if(sum >= ans) return;
            }
            ans = Math.min(sum, ans);
            return;
        }
        for(int i = start; i<chicken.size(); i++){
            open[i] = true;
            dfs(i+1, cnt + 1);
            open[i] = false;
        }
    }
    //너무 느려용
//    static void choose(int num, int start, ArrayList<Spot> arr){
//        if(num == m){
//            distance(arr);
//            return;
//        }
//        for(int i = start; i<chicken.size(); i++){
//            ArrayList<Spot> temp = new ArrayList<>();
//            for(Spot s : arr) temp.add(s);
//            temp.add(chicken.get(i));
//            choose(num+1, start+1, temp);
//        }
//    }
//    static void distance(ArrayList<Spot> arr){
//        int sum = 0;
//        for(Spot s1 : house){
//            int min = 98765423;
//            for(Spot s2 : arr){
//                int dist = Math.abs(s1.x - s2.x) + Math.abs(s1.y - s2.y);
//                if(dist < min) min = dist;
//            }
//            sum += min;
//            if(sum >= ans) return;
//        }
//        if(sum < ans) ans = sum;
//    }
}