package org.algorithm.programers.heap;

import java.util.PriorityQueue;

public class Num1 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }
        
        int count = 0;
        while (K > queue.peek()) {
            if (queue.size() < 2) {
                return -1;
            }
            int min1 = queue.poll();
            int min2 = queue.poll();

            count++;
            queue.offer(min1 + (min2 * 2));
        }

        return count;
    }

    public static void main(String[] argv) {

    }
}
