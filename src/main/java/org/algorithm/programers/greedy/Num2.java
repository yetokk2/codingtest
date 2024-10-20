package org.algorithm.programers.greedy;

public class Num2 {

    public int solution(String name) {
        int answer = 0; // 조이스틱 조작 횟수
        int len = name.length();
        int move = len-1;   // 기본 최소 좌우이동 횟수 (좌,우,커서)

        // 해당 커서 알파벳 변경 최솟값 (위,아래,커서)
        for(int i = 0 ; i < len ; i++) {
            char ch = name.charAt(i);
            answer += Math.min(ch - 'A', 'Z' - ch + 1);

            // 연속된 'A'가 끝나는 지점 찾기
            int idx = i+1;
            while(idx < len && name.charAt(idx) == 'A') {
                idx++;
            }

            // 좌우이동 최소 횟수 구하기
            move = Math.min(move, i*2 + len - idx);     // 순서대로 가기
            move = Math.min(move, (len - idx)*2 + i);   // 뒤로 돌아가기
        }

        return answer + move;
    }

    public static void main(String[] argv) {

    }
}
