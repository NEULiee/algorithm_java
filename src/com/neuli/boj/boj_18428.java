package com.neuli.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  18428 감시 피하기
 *  백트래킹, 브루트포스
 */
public class boj_18428 {

    static final int OBSTACLE = 3;
    static int N;
    static boolean result;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static List<pos> emptyHall, teacher, student;
    static char[][] hallway;

    static class pos {
        int r, c;

        public pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }

    static boolean canLookTeacher(int r, int c) {
        for (int i=0; i<4; i++) {
            int cr = r, cc = c;
            while (true) {
                cr += dx[i];    cc += dy[i];
                if (!isIn(cr, cc) || hallway[cr][cc] == 'O') {
                    break;
                }
                if (hallway[cr][cc] == 'T') {
                    return true;
                }
            }
        }
        return false;
    }

    static void findObstaclePos(int count) {
        if (count == OBSTACLE) {
            for (int i=0; i<student.size(); i++) {
                if (canLookTeacher(student.get(i).r, student.get(i).c)) {
                    return;
                }
            }
            result = true;
            return;
        }

        for (int i=0; i<emptyHall.size(); i++) {
            int r = emptyHall.get(i).r;
            int c = emptyHall.get(i).c;
            if (!visited[r][c]) {
                visited[r][c] = true;
                hallway[r][c] = 'O';
                findObstaclePos(count + 1);
                visited[r][c] = false;
                hallway[r][c] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        hallway = new char[N][N];
        emptyHall = new ArrayList<>();
        teacher = new ArrayList<>();
        student = new ArrayList<>();
        result = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                hallway[i][j] = sc.next().charAt(0);
                if (hallway[i][j] == 'X') {
                    emptyHall.add(new pos(i, j));
                } else if (hallway[i][j] == 'T') {
                    teacher.add(new pos(i, j));
                } else if (hallway[i][j] == 'S') {
                    student.add(new pos(i, j));
                }
            }
        }
        visited = new boolean[emptyHall.size()][emptyHall.size()];

        findObstaclePos(0);

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
