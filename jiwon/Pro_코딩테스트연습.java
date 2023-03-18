import java.util.*;
class Solution {
    final int MAX = Integer.MAX_VALUE;
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int max_alp=0, max_cop=0;
        
        //목표 alp, cop를 구한다. 
        for(int i=0; i<problems.length; i++){
            max_alp = Math.max(max_alp, problems[i][0]);
            max_cop = Math.max(max_cop, problems[i][1]);
        }

        if(alp > max_alp && cop > max_cop) {
            return 0;
        }else if(alp > max_alp){
            alp = max_alp;
        }else if( cop > max_cop){
            cop = max_cop;
        }
        //초기화 
        int [][] dp = new int[max_alp+1][ max_cop+1];
        for(int i=alp; i<=max_alp; i++) Arrays.fill(dp[i], MAX);
        dp[alp][cop] =0;
     
        //구현
        for(int i=alp; i<=max_alp; i++){
            for(int j=cop; j<= max_cop; j++){
                if(i+1 <=max_alp) dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1); //알고공부
                if(j+1 <=max_cop) dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1); //코딩공부

                //문제풀이
                for(int [] problem : problems){
                    //alp와 cop가 충족한다면
                    if(i < problem[0] || j < problem[1]) continue;
                    int next_alp = i + problem[2] > max_alp ? max_alp : i + problem[2];
                    int next_cop = j + problem[3] > max_cop ? max_cop : j + problem[3];
                    dp[next_alp][next_cop] = Math.min( dp[next_alp][next_cop], dp[i][j]+problem[4] );
                }
            }
        }
        
        // for(int i=alp; i<=max_alp; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // } 
        return dp[max_alp][max_cop];
    }
}