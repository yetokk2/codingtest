package org.algorithm.programers.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Num1 {
    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        List<Integer> lostList = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toList());

        Arrays.sort(reserve);
        List<Integer> reserveList = Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toList());

        for (int num : lost) {
            if (reserveList.contains(num)) {
                reserveList.remove(Integer.valueOf(num));
                lostList.remove(Integer.valueOf(num));
            }
        }

        for (int num : lost) {
            if (lostList.isEmpty()) {
                return n;
            }
            int front = num - 1;
            int back = num + 1;

            if (reserveList.contains(front)) {
                lostList.remove(Integer.valueOf(num));
                reserveList.remove(Integer.valueOf(front));
                continue;
            }

            if (reserveList.contains(back)) {
                lostList.remove(Integer.valueOf(num));
                reserveList.remove(Integer.valueOf(back));
            }
        }

        return n - lostList.size();
    }

    public static void main(String[] argv) {
        int[] lost = new int[] {2, 4};
        int[] reverse = new int[] {3, };
        System.out.println(solution(5, lost, reverse));
    }
}
