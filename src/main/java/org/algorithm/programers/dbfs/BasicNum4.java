package org.algorithm.programers.dbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BasicNum4 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<String> queue = new LinkedList<>(); // 변환 가능한 단어들을 저장할 queue
        Set<String> set = new HashSet<>(Arrays.asList(words)); // 단어들의 집합 set

        if(!set.contains(target)){
            return 0; // 변환할 수 없는 경우
        }

        queue.offer(begin); // queue에 begin 단어 추가
        set.remove(begin); // set에서 begin 단어 제거

        while (!queue.isEmpty()){

            for (int i=0; i<queue.size(); i++){
                // queue에서 단어를 하나씩 꺼내어 current (현재단어)에 저장
                String current = queue.poll();

                if (current.equals(target)){
                    return answer; // 타겟 단어에 도달
                }

                // HashSet 타입은 for 루프를 사용할 수 없으므로 to.Array()를 사용해 배열로 변환
                for (String word : set.toArray(new String[set.size()])){
                    // 변환 가능하면 queue에 해당 단어를 추가하고 set에서 제거
                    if(canConvert(current,word)){
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }

            answer++;
        }

        return 0; // 변환할 수 없는 경우
    }

    private boolean canConvert(String word1, String word2){
        int diffCnt = 0;
        for (int i = 0; i<word1.length(); i++){
            if (word1.charAt(i) != word2.charAt(i)){
                diffCnt++;
            }
        }
        return diffCnt ==1;
    }

    public static void main(String[] args) {
        
    }
}
