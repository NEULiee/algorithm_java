package com.neuli.boj;

/**
 * boj 14646 욱제는 결정장애야!!
 *
 * 구현, 시뮬레이션
 */

import java.util.Collections;
import java.util.Scanner;

public class boj_14646 {

    static int N, sum, max, cur;
    static int[] order;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        max = 0; sum = 0;
        order = new int[N+1];

        for (int i=0; i<2*N; i++) {
            cur = sc.nextInt();
            if (order[cur] == 0) {
                sum += 1;
                order[cur]++;
            } else {
                sum -= 1;
            }
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
