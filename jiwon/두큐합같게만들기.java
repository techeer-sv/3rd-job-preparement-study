import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        long sum1=0; long sum2=0;

        Queue<Integer> q1= new LinkedList<>(Arrays.stream(queue1).boxed().collect(Collectors.toList()));
        Queue<Integer> q2= new LinkedList<>(Arrays.stream(queue2).boxed().collect(Collectors.toList()));



        for( int i : queue1) sum1+= (long)i;
        for( int i : queue2) sum2+= (long)i;

        int time=0;
        while( time < 10000000){ //처음 큐 길이의 3배 정도만 되도 괜찮다고 한다.
            if(sum1==sum2) {
                answer=time;
                break;
            }
            time++;
            if(sum1 > sum2){

                int out = q1.poll();
                q2.add(out);
                sum1 -= out;
                sum2 += out;
            }else{

                int out = q2.poll();
                q1.add(out);
                sum2 -= out;
                sum1 += out;
            }
        }

        // System.out.println(Collections.unmodifiableList(q1));
        // System.out.println(sum1 + " " + sum2);
        if(answer==-2) return -1;
        else return answer;
    }
}