package com.neuli.boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  3020 개똥벌레
 *  누적합
 */

public class boj_3020 {

    static int N, H, min, cnt, sum;
    static int[] bottom, top;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        H = sc.nextInt();
        bottom = new int[H + 1];
        top = new int[H + 1];

        for (int i=0; i<N/2; i++) {
            bottom[sc.nextInt()]++;
            top[sc.nextInt()]++;
        }

        for (int i=1; i<=H; i++) {
            bottom[i] += bottom[i-1];
            top[i] += top[i-1];
        }

        min = N;
        cnt = 0;

        for (int i=1; i<=H; i++) {
            sum = 0;

            sum += bottom[H] - bottom[i - 1];
            sum += top[H] - top[H - i];

            if (sum < min) {
                min = sum;
                cnt = 1;
            }
            else if (min == sum) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
}
