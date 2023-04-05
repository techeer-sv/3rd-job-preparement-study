import java.util.*;
class Solution {
    static int[] res = { -1 };
    static int[] lion;
    static int max = 0;
    public void dfs(int [] lion, int[] info, int k, int now_arrow) {
        if(k == -1) {
            //idx == 10, 0점에 대해 처리 => 남은 과녁을 모두 넣는다.
            lion[10] = now_arrow;
            // System.out.println(Arrays.toString(lion));
            int apeach_point = 0; int lion_point = 0;
            for(int i = 10; i>=0; i--)
            {
                if(info[i] != 0 || lion[i] != 0) {
                    if(info[i] < lion[i])
                        lion_point += 10 - i;
                    else
                        apeach_point += 10 - i;
                }
            }

            if(lion_point - apeach_point > max){
                res = lion.clone();
                max = lion_point - apeach_point;
            }
            return ;
        }//if 종료조건

        if(now_arrow > info[k]){ //이번 과녁의 점수를 얻었을때
            lion[k] = info[k] + 1;
            dfs(lion, info, k-1, ( now_arrow - lion[k]) );
        }
        lion[k] = 0; //그렇지 않을 때
        dfs(lion, info, k-1,  now_arrow );
    }

    public int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(lion, info, 9, n); //가장 작은 점수의 화살 수가 우선인 조건을 위해서 거꾸로 채우기
        return res;
    }

}