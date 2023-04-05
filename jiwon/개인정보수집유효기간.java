import java.util.*;
import java.util.stream.Stream;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        //1. 약관일을 담을 배열 생성
        int [] termsDay = new int[26];
        for(String term : terms){
            int index = term.split(" ")[0].charAt(0) - 'A';
            int day = Integer.parseInt(term.split(" ")[1]) * 28;
            termsDay[index] = day;
        }
        // System.out.println(Arrays.toString(termsDay));

        //2. 현재 날짜일 계산

        int Today = Integer.parseInt(today.split("\\.")[0])*12*28
                + Integer.parseInt(today.split("\\.")[1])*28
                + Integer.parseInt(today.split("\\.")[2]);

        // System.out.println(Today);

        //3. for privacies 로 폐기 여부 확인
        for(int i=0; i<privacies.length; i++){
            String [] temp = privacies[i].split(" ");
            int privacyDay = Integer.parseInt(temp[0].split("\\.")[0])*12*28
                    + Integer.parseInt(temp[0].split("\\.")[1])*28
                    + Integer.parseInt(temp[0].split("\\.")[2]);
            if( privacyDay + termsDay [ temp[1].charAt(0)-'A' ] - Today <= 0){
                answer.add(i+1);
            }
        }


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}