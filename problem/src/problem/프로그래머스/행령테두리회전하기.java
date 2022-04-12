package problem.프로그래머스;

import java.util.Arrays;

public class 행령테두리회전하기 {
	 public static void main(String[] args) {
	        int rows = 3;
	        int columns = 3;
	        int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};

	        int[] dr = {0, -1, 0, 1}; //우하좌상
	        int[] dc = {1, 0, -1, 0}; //우하좌상
	        int[] answer = new int[queries.length];



	        int a = 1;
	        int[][] box = new int[rows][columns];
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < columns; j++) {
	                box[i][j] = a;
	                a++;
	            }
	        }


	        for (int i = 0; i < queries.length; i++) {
	            int x = queries[i][0] - 1;// 회전시작의 행좌표
	            int y = queries[i][1] - 1; // 회전시작의 열좌표
	            int xEnd = queries[i][2] - 1;// 회전시작이 끝나는 행좌표
	            int yEnd = queries[i][3] - 1;//회전 시작이 끝나는 열좌표
	            int tmp = 0;//옮길때 잠깐 저장해줄 친구분
	            int tmp2 = 0;//각이 꺽인가면 사용해야할지
	            int ans = Integer.MAX_VALUE;//
	            int tap = 0; //0이면 우 1이면 하 2면 좌 3이면 상

	            int nr = x;
	            int nc = y;

	            while (tap != 4) {
	            	System.out.println("tab" + tap);
	                switch (tap) {
	                    case 0:
	                        for (int j = 0; j < yEnd - y; j++) {
	                   
	                            if(j == 0) {
	                            	if (nc >= yEnd) {
	                                    tap++;
	                             
	                                    break;
	                                }
	                                tmp = box[nr][nc + 1];
	                                box[nr][nc + 1] = box[nr][nc];
	                                tmp2 = tmp;
	                                //최소값 구해주기
	                                if (ans > box[nr][nc]) ans = box[nr][nc];
	                                
	                                nc++;
	                                
	                                if (nc >= yEnd) {
	                                    tap++;
	                                    break;
	                                }
	                            }
	                            else {
	                                tmp = box[nr][nc+1];
	                                box[nr][nc+1] = tmp2;
	                                tmp2 = tmp;

	                                if (ans > box[nr][nc]) ans = box[nr][nc];

	                                nc++;

	                                if (nc >= yEnd) {
	                                    tap++;
	                                    break;
	                                }
	                            }
	                        }
	                        break;

	                    case 1:
	                        for (int j = 0; j < xEnd - x; j++) {
	                            if (j == 0) { //첫번째만 이렇게 할것
	                            	  if (nr >= xEnd) {
		                                    tap++;
		                                    break;
		                                }
	                            	
	                                tmp = box[nr + 1][nc];	                              
	                                box[nr + 1][nc] = tmp2;	                
	                      
	                                tmp2 = tmp;

	                                if (ans > box[nr][nc]) ans = box[nr][nc];
	                                nr++;

	                                if (nr >= xEnd) {
	                                    tap++;
	                                    break;
	                                }
	                            } else {
	                                tmp = box[nr+1][nc];
	                                box[nr+1][nc] = tmp2;
	                                tmp2 = tmp;

	                                if (ans > box[nr][nc]) ans = box[nr][nc];

	                                nr++;

	                                if (nr >= xEnd) {
	                                    tap++;
	                                    break;
	                                }
	                            }
	                        }
	                        break;
	                    //좌로가기
	                    case 2:
	                        for (int j = 0; j < yEnd - y; j++) {
	                            if (j == 0) { //첫번째만 이렇게 할것
	                            	 if (nc <= y) {
		                                    tap++;
		                                    break;

		                                }
	                            	
	                                tmp = box[nr][nc - 1];
	                                box[nr][nc-1] = tmp2;
	                                tmp2 = tmp;

	                                if (ans > box[nr][nc]) ans = box[nr][nc];
	                                nc--;

	                                if (nc <= y) {
	                                    tap++;
	                                    break;

	                                } else {
	                                    tmp = box[nr][nc-1];
	                                    box[nr][nc-1] = tmp2;
	                                    tmp2 = tmp;
	                                    if (ans > box[nr][nc]) ans = box[nr][nc];

	                                    nc--;

	                                    if (nc <= y) {
	                                        tap++;
	                                        break;
	                                    }
	                                }
	                            }
	                        }
	                        break;
	                    //올라가기
	                    case 3:
	                        for (int j = 0; j < xEnd - x; j++) {
	                            if (j == 0) { //첫번째만 이렇게 할것
	                            	if (nr <= x) {
	                                    tap++;
	                                    break;
	                                }
	                            	
	                                tmp = box[nr - 1][nc];
	                                box[nr - 1][nc] = tmp2;
	                                tmp2 = tmp;

	                                if (ans > box[nr][nc]) ans = box[nr][nc];
	                                nr--;

	                                if (nr <= x) {
	                                    tap++;
	                                    break;
	                                }
	                            } else {
	                                tmp = box[nr-1][nc];
	                                box[nr-1][nc] = tmp2;
	                                tmp2 = tmp;

	                                if (ans > box[nr][nc]) ans = box[nr][nc];

	                                nr--;

	                                if (nr <= x) {
	                                    tap++;
	                                    break;
	                                }
	                            }
	                        }
	                        break;

	                }//switch
	                if(ans == Integer.MAX_VALUE)
	                	ans = x*columns + y+1;
//	                System.out.println(ans);
//	                for(int b = 0; b < columns; b++) System.out.println(Arrays.toString(box[b]));
//	                System.out.println("-----------------");
	            }
	            answer[i] = ans;
	        }
	        System.out.println(Arrays.toString(answer));
	    }

}
