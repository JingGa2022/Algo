package problem.프로그래머스;

import java.util.*;

public class 전화번호목록 {
	  static public boolean phone(String[] arr, String str){
          for(String s: arr){
              //같을 경우
              if(s.equals(str)) return false;
              
              int len = Math.min(s.length(), str.length());
              
              
              //한개씩 돌면서 
              for(int i = 0; i<len; i++){
                  //하나라도 다르다면
                  if(s.charAt(i) != str.charAt(i)) return false;
           
              }
              //한번이라도 접두사가 같다면
              return true;
          }
      return false;
  }
  
	  public static void main(String[] args) {
		  String[] phone_book = {"123", "4512", "123456", "5246"};
		  boolean answer = true;
		  Arrays.sort(phone_book);
		  for(String s : phone_book){
			  if(phone(phone_book, s)) {
				  answer = false;
				  break;
			  }
		  }
		  System.out.println(answer);
	}
  
}
