package problem.프로그래머스;

import java.util.Arrays;

public class 카펫 {
	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		
		int[] arr = solution(brown,yellow);
		
		System.out.println(Arrays.toString(arr));
	}
	static public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        //3이하는 없으므로
        for(int w=3; w<brown ; w++){
            //h는 w보다 작거나 같아야 함으로
            for(int h = 3; h<=w; h++){
                if(2*(w+h-2)==brown && (w-2)*(h-2) == yellow){
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        return answer;
    }
}
