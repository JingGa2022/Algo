package problem.프로그래머스;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //신고 받은 수 적립
        Map<String, Integer> map = new HashMap<>();
        //이용자별 신고한 사람들 적기
        Map<String, String> check = new HashMap<>();
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        for(int i = 0; i<id_list.length; i++){
            map.put(id_list[i], 0);
            check.put(id_list[i], "");
        }
        
        for(int i = 0; i<report.length; i++){
            String[] arr = report[i].split(" ");
            if(!check.get(arr[0]).contains(arr[1])){
                map.put(arr[1], map.get(arr[1]) + 1);
                check.put(arr[0], check.get(arr[0]) + " " + arr[1]);
            }
        }
       
          for(int i = 0; i<id_list.length; i++){
            if(map.get(id_list[i]) >= k){
                for(int j = 0; j<id_list.length; j++){
                    if(check.get(id_list[j]).contains(id_list[i])) answer[j] ++;
                }
            }
        }
        
        return answer;
    }
}