import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        
        
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int sc1=0,sc2=0,sc3=0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == p1[i % p1.length]) sc1++;
            if(answers[i] == p2[i % p2.length]) sc2++;
            if(answers[i] == p3[i % p3.length]) sc3++;
        }
        int max = Math.max(sc1, Math.max(sc2,sc3));
        
        List<Integer> list = new ArrayList<>();
        if(max == sc1) list.add(1);
        if(max == sc2) list.add(2);
        if(max == sc3) list.add(3);
        
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}