package org.algorithm.programers.stack_queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Num2 {
    public static Queue<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        int pre = 0;
        int count = 0;
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day++;
            }

            if (pre < day) {
                if (count != 0) {
                    queue.add(count);
                }
                count = 0;
                pre = day;
            }

            count++;
        }
        queue.add(count);

       return queue;
    }

    public static void main(String[] argc) {
        int[] ex1 = {93, 30, 55};
        int[] ex2 = {1, 30, 5};
        solution(ex1, ex2);
    }
}
