import javafx.geometry.Pos;

import java.util.*;

public class A2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }

        int[][] flag = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (flag[i][j] == 0 && map[i][j] == 1) {
                    search(flag, map, n, m, i, j);
                    ans ++;
                }
                flag[i][j] = 1;
            }
        }
        System.out.println(ans);
    }

    static void search(int[][] flag, int[][] map, int n, int m, int i, int j) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(i, j));
        while( ! queue.isEmpty()) {
            Position position = queue.poll();
            flag[position.x][position.y] = 1;
            List<Position> nears = position.getNear(n, m, map, flag);
            queue.addAll(nears);
        }
    }

    static class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        List<Position> getNear(int n, int m, int[][] map, int[][] flag) {
            int[][] dir = new int[][] {
                    {1,  1,  0, 0, -1, -1, 1, -1},
                    {1, -1, -1, 1,  1, -1, 0,  0}
            };
            List<Position> positions = new ArrayList<>();
            // System.out.println("x = " + this.x + "; y = " + this.y);
            for (int i = 0; i < dir[0].length; i++) {
                int nx = this.x + dir[0][i];
                int ny = this.y + dir[1][i];

                // System.out.println("nx = " + nx + "; ny = " + ny);
                if (nx >=0 && nx < n && ny >=0 && ny < m && flag[nx][ny] == 0 && map[nx][ny] == 1) {
                    positions.add(new Position(nx, ny));
                }
            }
            return positions;
        }
    }
}
