package org.algorithm.baekjoon.dbfs;

/*
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
입력으로 주어지는 간선은 양방향이다.

이때 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
정점 번호는 1번부터 N번까지이다.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Num1260 {
    static int[][] ex1 ={
            {0, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 0}
    };

    public static int[][] drawMap(int n) {
        int[][] map = new int[n][n];


        return map;
    }
    public static void dfs(int n, int m, int v) {
        int[][] map = new int[n][n];

        v = v - 1;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        ArrayList<Integer> order = new ArrayList<>();
        visited[v] = true;
        stack.push(v);

        for (int i = 0; i < n; i++) {
            int node = stack.pop();
            order.add(node);
            for (int j = 0; j < n; j++) {
                int next = ex1[node][j];
                if (next == 0 || visited[j]) {
                    continue;
                }
                stack.push(j);
                visited[j] = true;
                break;
            }

            if (stack.isEmpty()) {
                break;
            }
        }

        order.stream().forEach(System.out::println);
    }


    public static void bfs(int n, int m, int v) {
        Queue<Integer> queue = new LinkedList<>();
        v = v - 1;
        queue.add(v);
        ArrayList<Integer> order = new ArrayList<>();
        boolean visited[] = new boolean[n];
        visited[v] = true;

        for (int i = 0; i < n; i++) {
            int node = queue.poll();
            order.add(node);
            for (int j = 0; j < n; j++) {
                int next = ex1[node][j];
                if (next == 0 || visited[j]) {
                    continue;
                }
                visited[j] = true;
                queue.add(j);
            }

            if (queue.isEmpty()) {
                break;
            }
        }

        order.stream().forEach(System.out::println);
    }


    public static void main(String[] args) {
        dfs(4, 5, 1);
        bfs(4, 5, 1);
    }
}
