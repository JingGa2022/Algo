package problem.백준.class5;

import java.util.Scanner;

public class easy2048_12100 {
	static int n, ans;
    static int arr[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        int tmp[][] = new int[n][n];

        for(int i = 0 ; i<n ;i++){
            for(int j =0; j<n; j++) {
                arr[i][j] =sc.nextInt();
                ans = Math.max(ans, arr[i][j]);
            }
        }

        move(0);

        System.out.println(ans);
    }
    private static void move(int cnt){
        if(cnt == 5) {
            for(int i = 0 ; i<n; i++){
                for(int j = 0 ; j<n; j++) ans = Math.max(arr[i][j], ans);
            }

            return;
        }
        int[][] tmp = new int[n][n];

        //복사
        for(int i = 0; i<n; i++) {
                tmp[i] = arr[i].clone();

        }

        for(int k = 0; k<4; k++){

            switch (k){
                //위
                case 0:
                    for(int i = 0 ;i<n; i++){
                        int idx = 0;
                        int block = 0;
                        for(int j = 0; j<n; j++){
                            if(arr[j][i] != 0) {
                                if (block == arr[j][i]) {
                                    arr[idx - 1][i] = block * 2;
                                    block = 0;
                                    arr[j][i] = 0;
                                } else {
                                    block = arr[j][i];
                                    arr[j][i] = 0;
                                    arr[idx][i] = block;
                                    idx++;
                                }
                            }
                        }
                    }
                    break;
                case 1:
                    //하
                    for(int i = 0 ;i<n; i++){
                        int idx = n-1;
                        int block = 0;
                        for(int j = n-1; j>=0; j--){
                            if(arr[j][i] != 0) {
                                if (block == arr[j][i]) {
                                    arr[idx + 1][i] = block * 2;
                                    block = 0;
                                    arr[j][i] = 0;
                                } else {
                                    block = arr[j][i];
                                    arr[j][i] = 0;
                                    arr[idx][i] = block;
                                    idx--;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    //좌
                    for(int i = 0 ;i<n; i++){
                        int idx = 0;
                        int block = 0;
                        for(int j = 0; j<n; j++){
                            if(arr[i][j] != 0) {
                                if (block == arr[i][j]) {
                                    arr[i][idx - 1] = block * 2;
                                    block = 0;
                                    arr[i][j] = 0;
                                } else {
                                    block = arr[i][j];
                                    arr[i][j] = 0;
                                    arr[i][idx] = block;
                                    idx++;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    //우
                    for(int i = 0 ;i<n; i++){
                        int idx = n-1;
                        int block = 0;
                        for(int j = n-1; j>=0; j--){
                            if(arr[i][j] != 0) {
                                if (block == arr[i][j]) {
                                    arr[i][idx + 1] = block * 2;
                                    block = 0;
                                    arr[i][j] = 0;
                                } else {
                                    block = arr[i][j];
                                    arr[i][j] = 0;
                                    arr[i][idx] = block;
                                    idx--;
                                }
                            }
                        }
                    }
                    break;
            }
            move(cnt+1);
            for(int i = 0; i<n; i++) {
                    arr[i] = tmp[i].clone();
            }
        }
    }
}