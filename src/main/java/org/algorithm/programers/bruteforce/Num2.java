package org.algorithm.programers.bruteforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num2 {
    public static List<Integer> solution(int[] answers) {
        int[] user1 = {1, 2, 3, 4, 5};
        int[] user2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] user3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int i = 0;
        int j = 0;
        int k = 0;
        int user1Count = 0;
        int user2Count = 0;
        int user3Count = 0;
        for (int answer : answers) {
            i = i % user1.length;
            j = j % user2.length;
            k = k % user3.length;
            if (answer == user1[i++]) {
                user1Count++;
            }

            if (answer == user2[j++]) {
                user2Count++;
            }

            if (answer == user3[k++]) {
                user3Count++;
            }
        }

        int max = 0;
        if (user1Count >= user2Count) {
            max = user1Count;
        } else {
            max = user2Count;
        }

        if (max <= user3Count) {
            max = user3Count;
        }

        List<Integer> list = new ArrayList<>();
        if (user1Count == max) {
            list.add(1);
        }

        if (user2Count == max) {
            list.add(2);
        }

        if (user3Count == max) {
            list.add(3);
        }

        Collections.sort(list);
        return list;
    }

    public static void main(String[] argv) {

    }
}
