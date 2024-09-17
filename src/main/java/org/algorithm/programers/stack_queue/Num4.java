package org.algorithm.programers.stack_queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Num4 {

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for (int priority : priorities) {
            list.add(priority);
        }

        while(location >= 0) {
            int max = Collections.max(list);
            if(list.get(0) >= max) {
                list.remove(0);
                location--;
                answer++;
            } else {
                int tmp = list.get(0);
                list.remove(0);
                list.add(tmp);
                location--;
                if(location < 0) {
                    location = list.size()-1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] argv) {

    }
}
