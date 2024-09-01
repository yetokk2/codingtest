package org.algorithm.programers.hash;

import java.util.HashMap;
import java.util.Iterator;

public class Num4 {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        Iterator<Integer> iter = map.values().iterator();

        int result = 1;
        while (iter.hasNext()) {
            result *= iter.next().intValue() + 1;
        }

        return result - 1;
    }

    
    public static void main() {
        System.out.println(solution());
    }
}
