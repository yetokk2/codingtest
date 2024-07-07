package org.algorithm.programers.dbfs;

public class BasicNum1 {

    static int[] ex1 = {1, 1, 1, 1, 1};
    static int[] ex2 = {4, 1, 2, 1};

    static int count = 0;
    public static void solution(int[] numbers, int target) {
        int size = numbers.length;
        calculate(numbers, target, size, 1, numbers[0]);
        calculate(numbers, target, size, 1, -numbers[0]);
    }

    public static void calculate(int[] numbers, int target, int size, int i, int prev) {
        if (i == size) {
            if (prev == target) {
                count++;
            }
            return ;
        }


        int plus = prev + numbers[i];
        calculate(numbers, target, size, i + 1, plus);
        int minus = prev - numbers[i];
        calculate(numbers, target, size, i + 1, minus);
    }


    public static void main(String[] args) {
        solution(ex2, 4);
        System.out.println(count);
    }
}
