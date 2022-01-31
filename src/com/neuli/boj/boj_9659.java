package com.neuli.boj;

import java.util.Scanner;

/**
 * 9659 돌 게임 5
 *
 */

public class boj_9659 {

    static long N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();

        // 1개 1개 2
        // 1개 3개 4
        // 3개 1개 4
        // 3개 3개 6

        String res = N % 2 == 0 ? "CY" : "SK";
        System.out.println(res);
    }
}
