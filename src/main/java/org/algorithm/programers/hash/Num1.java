package org.algorithm.programers.hash;

import java.util.HashSet;


public class Num1 {
    int[] nums = {3,3,3,2,2,2};

    public int solution() {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = nums.length/2;
        int setSize = set.size();
        if (max >= setSize) {
            return setSize;
        } else {
            return max;
        }
    }

    public static void main() {

    }
}
