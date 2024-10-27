package org.algorithm.programers.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Num1 {
    public static int solution(int N, int number) {
        List<Set<Integer>> countList = new ArrayList<>();

        if (N == number) {
            return 1;
        }

        for(int i=0; i<9; i++) {
            countList.add(new HashSet<>());
        }

        countList.get(1).add(N); // N을 1개 쓴 값은 N 혼자이다.

        for (int i = 2; i < 9; i++) {
            Set<Integer> countSet = countList.get(i);

            for (int j = 1; j <= i; j++) {
                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i - j);

                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);

                        if (preNum != 0 && postNum != 0) {
                            countSet.add(preNum / postNum);
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0 ; j < i; j++) {
                sb.append(N);
            }

            // 연산 안 된 숫자
            countSet.add(Integer.parseInt(sb.toString()));

            for (int num : countList.get(i)) {
                if (number == num) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] argv) {
//        solution();
    }
}
