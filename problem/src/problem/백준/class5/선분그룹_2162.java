package problem.백준.class5;

import java.util.Scanner;

public class 선분그룹_2162 {
	static class Spot{
        int x; int y;
        public Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Line{
        Spot spot1;
        Spot spot2;
        public Line(Spot spot1, Spot spot2){
            this.spot1 = spot1;
            this.spot2 = spot2;
        }
    }
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Line[] line = new Line[n];
        parent = new int[n];

        for(int i = 0; i < n; i++) parent[i] = i;

        for(int i = 0; i<n; i++){
            line[i] = new Line(new Spot(sc.nextInt(), sc.nextInt()), new Spot(sc.nextInt(), sc.nextInt()));
        }
        int parent1 = 0;
        int parent2 = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j) continue;
                parent1 = find(i);
                parent2 = find(j);

                if(parent1 != parent2){
                    if(cross(line[i], line[j]))
                        union(i, j);
                }
            }
        }
        int[] cnt = new int[n];
        int num = 0;
        int size = 0;

        for(int i = 0; i<n; i++) cnt[parent[i]]++;

        for(int i = 0; i<n; i++){
            if(cnt[i] > size){
                size = cnt[i];
            }
            if(cnt[i] != 0)
                num++;
        }

        System.out.println(num + "\n" + size);
    }
    private static boolean cross(Line o1, Line o2){
        Spot s1 = o1.spot1;
        Spot s2 = o1.spot2;
        Spot s3 = o2.spot1;
        Spot s4 = o2.spot2;

        int s1s2 = ccw(s1, s2, s3) * ccw(s1, s2, s4);
        int s3s4 = ccw(s3, s4, s1) * ccw(s3, s4, s2);

        //포개진 경우
        if(s1s2 == 0 && s3s4 == 0){
            return overlap(o1, o2);
        }

        return s1s2 <= 0 && s3s4 <= 0;
    }
    private static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            parent[x] = y;
        }
    }
    private static int ccw(Spot s1, Spot s2, Spot s3){
        int s = s1.x * s2.y + s2.x * s3.y + s3.x * s1.y;
        s -= (s1.y * s2.x + s2.y * s3.x + s3.y * s1.x);

        if(s > 0) return 1;
        else if(s == 0) return 0;
        return -1;
    }
    private static boolean overlap(Line l1, Line l2){
        if(Math.max(l1.spot1.x, l1.spot2.x) < Math.min(l2.spot1.x, l2.spot2.x))
            return false;
        if(Math.min(l1.spot1.x, l1.spot2.x) > Math.max(l2.spot1.x, l2.spot2.x))
            return false;
        if(Math.max(l1.spot1.y, l1.spot2.y) < Math.min(l2.spot1.y, l2.spot2.y))
            return false;
        if(Math.min(l1.spot1.y, l1.spot2.y) > Math.max(l2.spot1.y, l2.spot2.y))
            return false;
        return true;
    }
}
