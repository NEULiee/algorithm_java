package com.neuli.boj;

import java.util.Scanner;

/**
 *  1687 행렬 찾기
 *
 */

public class boj_1687 {

    static int N, M, res;
    static int[][] matrix, dpX, dpY;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new int[N+1][M+1];
        dpX = new int[N+1][M+1];
        dpY = new int[N+1][M+1];

        for (int i=1; i<=N; i++) {
            String line = sc.next();
            for (int j=1; j<=M; j++) {
                matrix[i][j] = line.charAt(j-1) - '0';
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (matrix[i][j-1] == 0) {
                    dpX[i][j] = matrix[i][j] == 0 ? dpX[i][j - 1] + 1 : 0;
                }
                else {
                    dpX[i][j] = matrix[i][j] == 0 ? 1 : 0;
                }
                if (matrix[i-1][j] == 0) {
                    dpY[i][j] = matrix[i][j] == 0 ? dpY[i - 1][j] + 1 : 0;
                }
                else {
                    dpY[i][j] = matrix[i][j] == 0 ? 1 : 0;
                }
            }
        }

        res = 0;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                res = Math.max(dpX[i][j] * dpY[i][j], res);
            }
        }

        System.out.println(res);
    }
}
