package org.algorithm.programers.stack_queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Num1 {

    public static int[] solution(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int pre = stack.pop();
            stack.push(pre);

            if (arr[i] == pre) {
                continue;
            }

            stack.push(arr[i]);
        }

        int[] result = new int[stack.size()];
        int i = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            result[i++] = num;
            System.out.println(num);
        }

        return result;
    }

    public static void main(String[] argv) {
        int[] ex1 = {4,4,4,3,3};
        System.out.println(solution(ex1).length);
    }
}
