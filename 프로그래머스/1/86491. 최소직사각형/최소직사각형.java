class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int fm=0,fn=0;
        
    for(int[] s : sizes){
        int max = Math.max(s[0],s[1]);
        int min= Math.min(s[0],s[1]);
        
        fm = Math.max(fm,max);
        fn = Math.max(fn,min);
    }
        answer = fm * fn;
        return answer;
    }
}