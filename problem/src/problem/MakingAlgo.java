package problem;

import java.util.Scanner;

public class MakingAlgo {

   static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

   static int N, P;
   static int X, Y;

   static int ans;

   static int[][] scoreMap;
   static int total;

   public static void main(String[] args) {
      
      Scanner input = new Scanner(System.in);
      StringBuilder sb = new StringBuilder();

      int T = input.nextInt();

      for (int tc = 1; tc <= T; tc++) {
         N = input.nextInt();

         X = input.nextInt();
         Y = input.nextInt();

         P = input.nextInt();

         int[][] map = new int[N][N];
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               map[i][j] = input.nextInt();
            }
         }

         scoreMap = new int[N][N];
         total = 0;
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

               if (map[i][j] >= 2 && map[i][j] <= 6) {
                  int temp = 1;

                  for (int[] d : drc) {
                     int ni = i + d[0];
                     int nj = j + d[1];

                     if (inBound(ni, nj) && map[ni][nj] == 1) {
                        temp += 1;
                     }
                  }

                  scoreMap[i][j] = map[i][j] / temp;
                  total += map[i][j] / temp;

               }

            }
         }
         
         DFS();

         sb.append("#").append(tc).append(" ").append(ans).append("\n");

      }
      
      System.out.print(sb);

   }

   private static void DFS() {
      ans = Integer.MIN_VALUE;

      boolean[][] check = new boolean[N][N];
      check[X][Y] = true;

      DFSUtil(X, Y, 0, scoreMap[X][Y], check);
   }

   public static void DFSUtil(int x, int y, int p, int score, boolean[][] check) {

      if (p == P || score == total) {
         if (ans < score) {
            ans = score;
   
         }
         return;
      }
      
      for (int[] d : drc) {
         int nx = x + d[0];
         int ny = y + d[1];

         if (inBound(nx, ny) && !check[nx][ny]) {
            check[nx][ny] = true;
            DFSUtil(nx, ny, p + 1, score + scoreMap[nx][ny], check);
            check[nx][ny] = false;
         }
      }

   }

   private static boolean inBound(int nx, int ny) {
      return nx >= 0 && nx < N && ny >= 0 && ny < N;
   }

}