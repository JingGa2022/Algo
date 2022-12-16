package problem.백준.class5;

import java.util.Scanner;
import java.util.Stack;

public class LCS2_ {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str1 = sc.next();
        String str2 = sc.next();

        int LCS[][] = new int[str1.length()+1][str2.length()+1];

        for(int i = 0; i<str1.length(); i++){
            for(int j = 0; j<str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    LCS[i+1][j+1] = LCS[i][j] + 1;
                }else{
                    LCS[i+1][j+1] = Integer.max(LCS[i+1][j], LCS[i][j+1]);
                }
            }
        }
        int i = str1.length();
        int j = str2.length();
        Stack<Character> st = new Stack<>();
        while(LCS[i][j] != 0){
            int tmp = LCS[i][j];
            if(LCS[i-1][j] == tmp){
                i--;
            }else if(LCS[i][j-1] == tmp){
                j--;
            }else{
                i--;
                j--;
                st.add(str1.charAt(i));
            }
        }

        sb.append(LCS[str1.length()][str2.length()] + "\n");
        while(!st.empty()) sb.append(st.pop());

        System.out.println(sb);

    }
}