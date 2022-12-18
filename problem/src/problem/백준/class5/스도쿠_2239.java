package problem.백준.class5;

import java.util.Scanner;

public class 스도쿠_2239 {
	 static int[][] arr = new int[9][9];
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        for(int i = 0; i<9; i++){
	            String s = sc.next();
	            for(int j = 0; j<9; j++){
	                arr[i][j] = s.charAt(j) - '0';
	            }
	        }

	        sudoku(0,0);
	    }

	    private static void sudoku(int x, int y) {
	        if(y == 9){
	            sudoku(x+1, 0);
	            return;
	        }

	        if(x == 9){
	            StringBuilder sb = new StringBuilder();

	            for(int i = 0 ; i<9; i++){
	                for(int j = 0; j<9;j++) sb.append(arr[i][j]);
	                sb.append("\n");
	            }

	            System.out.println(sb);
	            System.exit(0);
	            return;
	        }

	        if(arr[x][y] == 0){
	            for(int v = 1; v <= 9; v++){
	                if(possible(x, y, v)){
	                    arr[x][y] = v;
	                    sudoku(x, y+1);
	                }
	            }
	            arr[x][y] = 0;
	        }else{
	            sudoku(x, y+1);
	        }
	    }
	    private static boolean possible(int x, int y, int v){

	        for(int i = 0; i< 9 ; i++){
	            if(v == arr[x][i]) return false;
	        }

	        for(int i = 0; i< 9 ; i++){
	            if(v == arr[i][y]) return false;
	        }

	        int nx = (x/3) * 3;
	        int ny = (y/3) * 3;

	        for(int i = nx; i < nx+3; i++){
	            for(int j = ny; j<ny+3; j++){
	                if(arr[i][j] == v) return false;
	            }
	        }


	        return true;
	    }
	}
