package com.neuli.boj;

import java.util.Scanner;

/**
 *  8911 거북이
 *  시뮬레이션
 *
 *  방향을 잘 생각하자!
 */

public class boj_8911 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int T;
    static String commands;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int t=0; t<T; t++) {
            int maxX = 0, minX = 0, maxY = 0, minY = 0, x = 0, y = 0, dir = 3;
            commands = sc.next();

            for (int i=0; i<commands.length(); i++) {
                char command = commands.charAt(i);

                if (command == 'F') {
                    x += dx[dir];
                    y += dy[dir];
                    maxX = Math.max(x, maxX); maxY = Math.max(y, maxY);
                    minX = Math.min(x, minX); minY = Math.min(y, minY);
                }
                if (command == 'B') {
                    x -= dx[dir];
                    y -= dy[dir];
                    maxX = Math.max(x, maxX); maxY = Math.max(y, maxY);
                    minX = Math.min(x, minX); minY = Math.min(y, minY);
                }
                if (command == 'L') {
                    dir -= 1;
                    dir = dir < 0 ? dir + 4 : dir;
                }
                if (command == 'R') {
                    dir += 1;
                    dir = dir > 3 ? dir - 4 : dir;
                }
            }

            System.out.println((maxX - minX) * (maxY - minY));
        }
    }
}
