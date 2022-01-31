package com.neuli.boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  1058 친구
 *  플로이드 와샬
 */

public class boj_1058 {

    static int N, res;
    static int[][] isFriend;
    static int[] twoFriends;
    static boolean[] friendsCheck;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        isFriend = new int[N+1][N+1];
        twoFriends = new int[N+1];

        for (int i=1; i<=N; i++) {
            String input = sc.next();
            for (int j=1; j<=N; j++) {
                isFriend[i][j] = input.charAt(j-1) == 'Y' ? 1 : 0;
                if (isFriend[i][j] == 1) {
                   twoFriends[i]++;
                }
            }
        }

        for (int i=1; i<=N; i++) {
            friendsCheck = new boolean[N+1];
            Arrays.fill(friendsCheck, false);
            for (int j=1; j<=N; j++) {
                if (isFriend[i][j] == 1) {
                    for (int k = 1; k <= N; k++) {
                        if (i == j || j == k || i == k) {
                            continue;
                        }
                        if (isFriend[j][k] == 1 && isFriend[i][k] != 1 && !friendsCheck[k]) {
                            twoFriends[i]++;
                            friendsCheck[k] = true;
                        }
                    }
                }
            }
        }

        res = 0;
        for (int f: twoFriends) {
            res = Math.max(f, res);
        }

        System.out.println(res);
    }
}
