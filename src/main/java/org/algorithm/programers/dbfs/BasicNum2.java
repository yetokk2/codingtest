package org.algorithm.programers.dbfs;

public class BasicNum2 {

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            dfs(visited, computers, i);
            count++;
        }

        return count;
    }

    public static void dfs(boolean[] visited, int[][] computers, int start) {
        visited[start] = true;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && computers[start][i] == 1) {
                dfs(visited, computers, i);
            }
        }
    }



    public static void main(String[] args) {
        
    }
}
