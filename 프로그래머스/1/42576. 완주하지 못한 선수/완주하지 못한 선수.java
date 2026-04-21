import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = ""; 
    HashMap<String,Integer> map = new HashMap<>();
       for(String s: participant){
           map.put(s ,map.getOrDefault(s,0)+1 );
       }
        
        for(String n: completion){
            map.put(n, map.get(n) - 1);
        }
        
        for(String k: participant){
            if(map.get(k)!=0){
                answer = k;
                break;
            }

        }
       
        return answer;
        
        
    }
}