package org.algorithm.programers.bruteforce;

import java.util.Arrays;

public class Num4 {
 //카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int high = 3; high < brown + yellow; high++) {
            if ((brown + yellow) % high != 0) {
                continue;
            }

            int width = (brown + yellow) / high;
            if (width >= high) {
                if ((high - 2) * (width - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = high;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] argv) {
        int[] result = solution(10, 2);
        for (int num : result) {
            System.out.println(num);
        }
    }
 }
