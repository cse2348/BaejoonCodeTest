import java.util.*;

class Solution {
    public int solution(int[] nums) { //n마리 포켓몬 종류가 담긴 배열이 주어짐
        int answer = 0;
        HashMap <Integer,Integer> map = new HashMap<>();
        
        // 맵에 일단 다 넣음 (같은 종류는 하나로 취급)
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        // 가져갈수있는 포켓몬수
        int m = nums.length/2;
        
        //종류수랑 가져갈수있는것중 최소가 답
        if(m > map.size()){
            answer =  map.size();
        }else{
            answer = m;
        }
        return answer; //그때 포켓몬 종류번호의 개수
    }
}