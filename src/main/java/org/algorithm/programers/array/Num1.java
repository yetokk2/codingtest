package org.algorithm.programers.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Num1 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int i = 0;
        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int index = command[2] - 1;

            List<Integer> list = IntStream.of(array)
                    .boxed()
                    .collect(Collectors.toList());

            List<Integer> subList = list.subList(start, end);
            Collections.sort(subList);
            result[i++] = subList.get(index);
        }

        return result;
    }

    public static void main(String[] argv) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        solution(array, commands);
    }
}
