package org.algorithm.programers.greedy;

//number.length() - k 자리수만큼 구해야 한다.
//자리수가 n이라고 치면, 뒤에서 n-1개 만큼 빼고 앞에서 최댓값을 구한다.
//답에 추가하고, 그 index 기준으로 남은 자리수만큼 빼놓고 최대값을 구한다.
// + 시간때문에 StringBuilder사용하자
public class Num3 {
    public static String solution(String number, int k) {
        int len = number.length() - k - 1;
        int idx = 0;

        StringBuilder sb = new StringBuilder();

        while(len >= 0){
            char max = '0';
            for(int i = idx; i < number.length() - len; i++){
                if(number.charAt(i) > max){
                    max = number.charAt(i);
                    idx = i + 1;
                    if(number.charAt(i) == '9'){
                        break;
                    }
                }
            }
            sb.append(max);
            len--;
        }

        return sb.toString();
    }

    public static void main(String[] argv) {
        System.out.println(solution("4177252841", 4));
    }
}
