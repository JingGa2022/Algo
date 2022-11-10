package problem.백준.class4;

import java.util.ArrayList;
import java.util.Scanner;

public class 트리의지름_1167 {
	static class Node{
        int top;
        int dist;

        public Node(int top, int dist){
            this.top = top;
            this.dist = dist;
        }
    }
    static ArrayList<Node>[] tree;
    static boolean[] visit;
    static int ans, v, far;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        ans = 0;

        tree = new ArrayList[v+1];

        for(int i = 0; i<v; i++){
            int top = sc.nextInt();
            tree[top] = new ArrayList<>();

            while(true){
                int node = sc.nextInt();
                if(node == -1) break;
                int dist = sc.nextInt();

                tree[top].add(new Node(node, dist));
            }
        }

        visit = new boolean[v+1];
        dfs(1, 0);

        visit = new boolean[v+1];
        dfs(far, 0);

        System.out.println(ans);
    }

    private static void dfs(int num, int len) {
        if(len > ans){
            ans = len;
            far = num;
        }

        visit[num] = true;

        for(int i = 0; i < tree[num].size(); i++){
            Node node = tree[num].get(i);
            if(!visit[node.top]){
                visit[node.top] = true;
                dfs(node.top, len + node.dist);
            }
        }
    }
}
