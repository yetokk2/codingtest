package org.algorithm.programers.heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Num1 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.add(i);
        }

        int min1 = queue.poll();
        int count = 0;
        while (K > min1) {
            count++;
            int min2 = queue.poll();

            queue.offer(min1 + (min2 * 2));
            if (queue.size() < 2) {
                return -1;
            }
            min1 = queue.poll();
        }

        return count;
    }

    public static void main(String[] argv) {

    }
}
