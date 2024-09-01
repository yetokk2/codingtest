package org.algorithm.programers.hash;

import java.util.Arrays;

public class Num2 {
    public static String solution(String[] com, String[] part) {
        Arrays.sort(com);
        Arrays.sort(part);

        for (int i = 0; i < com.length; i++) {
            if (!com[i].equals(part[i])) {
                return part[i];
            }
        }

        return part[part.length - 1];
    }

    public static void main(String[] argv) {
        String[] com = {"stanko", "ana", "mislav"};
        String[] part = {"mislav", "stanko", "mislav", "ana"};
        System.out.println(solution(com, part));
    }
}
