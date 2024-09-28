package org.algorithm.programers.bruteforce;

public class Num1 {
    public static int solution(int[][] sizes) {
        int max = sizes[0][0];
        // 가장 긴 길이를 찾는다
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < 2; j++) {
                int value = sizes[i][j];
                if (value > max) {
                    max = value;
                }
            }
        }

        int sMax = 0;
        // 명함의 짧은 부분 중 긴 부분
        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];

            int value = w >= h ? h : w;

            if (value > sMax) {
                sMax = value;
            }
        }

        return max * sMax;
    }

    public static void main(String[] argv) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        solution(sizes);
    }
}
