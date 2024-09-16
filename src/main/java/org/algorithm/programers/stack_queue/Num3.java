package org.algorithm.programers.stack_queue;

public class Num3 {
    public static boolean Solution(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        for (char index : arr) {
            if (index == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        if (count != 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] argv) {

    }
}
