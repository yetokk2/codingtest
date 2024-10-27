package org.algorithm.programers.dynamicprogramming;

import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Num2 {
    public static int solution(int[][] triangle) {
        int answer = triangle[0][0];

        for(int i = 1; i < triangle.length ; i++) {
            for(int j = 0; j < triangle[i].length ; j++) {

                if(j == 0) {//왼쪽 끝
                    triangle[i][j] += triangle[i-1][j];
                }
                else if(j == i) {//오른쪽 끝
                    triangle[i][j] += triangle[i-1][j-1];
                }
                else {
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }

                answer = Math.max(answer, triangle[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] argv) {

    }
}
