package org.algorithm.programers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// 온전한 내 풀이가 아니므로 적어둔다.
// 1) 요청 시간이 짧은 순으로 정렬
// 2) 그 중 가장 소요 시간이 짧은 것부터 우선 실행
// 3) 요청 시간이 지난 것들이 있으면 실행 가능 리스트 소요 시간이 짧은 순으로 넣는다.
// 4) 다시 2번
// 5) 모든 프로세스를 실행했으면 종료한다.

public class Num2 {
    public static int solution(int[][] jobs) {
        int totalTime = 0;
        int currentTime = 0; // 수행되고난 직후의 시간
        int queueIndex = 0; // jobs 배열의 인덱스
        int count = 0; // 수행된 요청 갯수

        // 원본 배열 오름차순 정렬 (요청시간 오름차순)
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 처리 시간 오름차순으로 정렬되는 우선순위 큐(Heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (count < jobs.length) {
            // 요청 시간이 지난 프로세스들을 담는다.
            for (int i = queueIndex; i < jobs.length; i++) {
                int requestTime = jobs[queueIndex][0];
                if (requestTime > currentTime) {
                    break;
                }
                pq.add(jobs[i]);
                queueIndex++;
            }

            if (pq.isEmpty()) {
                currentTime = jobs[queueIndex][0];
                continue;
            }

            int[] temp = pq.poll();
            int requestTime = temp[0];
            int processingTime = temp[1];

            currentTime += processingTime;
            totalTime += currentTime - requestTime;
            count++;
        }

        return totalTime / jobs.length;
    }

    public static void main(String[] argv) {
        int[][] jobs = {
                {0, 3}, {1, 9}, {2, 6}
        };

        System.out.println(solution(jobs));
    }
}
