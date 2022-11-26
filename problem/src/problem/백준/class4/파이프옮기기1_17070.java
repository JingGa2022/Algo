package problem.백준.class4;

public class 파이프옮기기1_17070 {
	static int n, ans;
    static int[][] home;
    static boolean[][] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        home = new int[n][n];
        visit = new boolean[n][n];
        ans = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++) home[i][j] = sc.nextInt();
        }

        dfs(0, 1, 1);

        System.out.println(ans);
    }
    // state가 1 : 가로, 2 : 세로, 3 : 대각선
    private static void dfs(int x, int y, int state) {
        if (x == n - 1 && y == n - 1) {
            ans++;
            return;
        }
        switch (state){
            case 1 :
                if(y + 1 < n && home[x][y + 1] == 0) dfs(x, y+1, 1);
                break;
            case 2 :
                if(x + 1 < n && home[x + 1][y] == 0) dfs(x + 1, y, 2);
                break;
            case 3 :
                if(y + 1 < n && home[x][y + 1] == 0) dfs(x, y+1, 1);
                if(x + 1 < n && home[x + 1][y] == 0) dfs(x + 1, y, 2);
                break;
        }
        if(x + 1 < n && y + 1 < n && home[x][y + 1] == 0 && home[x+1][y] == 0 && home[x + 1][y + 1] == 0) dfs(x + 1, y + 1, 3);
    }
}
// 0 : ->, 1 : \, 2 : |
    /*

        for(int i = 0; i<3; i++){
            int nx = x;
            int ny = y;
            int nstate;
            System.out.printf("진입전 : %d %d i = %d, state = %d\n", nx, ny, i, state);
            if(check(state, i, x, y)){
                if(i == 0){
                    ny += 1;
                    nstate = 1;
                } else if (i == 1) {
                    nx += 1;
                    ny += 1;
                    nstate = 3;
                }else {
                    nx += 1;
                    nstate = 2;
                }
                if(nx >= n || ny >= n || home[nx][ny] == 1) continue;
                System.out.printf("진입 : %d %d i = %d, state = %d\n", nx, ny, i, nstate);
                if(!visit[nx][ny]){
                    dfs(nx, ny, nstate);
                    visit[nx][ny] = false;
                }
            }
        }
    }

    private static boolean check(int state, int i, int x, int y) {
        if(state == 1){
        if(i == 2) return false;}
        else if(state == 2){
            if(i == 0) return false;}
        else if(i == 1){
            if (y + 1< n && home[x][y + 1] == 1) {
                return false;
            }
            if (x + 1< n && home[x+1][y] == 1) {
                return false;
            }
            if(x + 1 < n && y + 1 < n && home[x+1][y+1] == 1) return false;
        }

        return true;
    }
    */
