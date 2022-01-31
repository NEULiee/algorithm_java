package com.neuli.boj;

import java.util.Scanner;

/**
 *  1701 Cubeditor
 */

public class boj_1701 {

    // 어떤 문자열 내에서 부분 문자열이 두 번 이상 나오는 문자열을 찾는 기능
    // 두 부분 문자열은 겹쳐도 된다.
    // 부분 문자열 중에서 가장 길이가 긴 것

    // KMP 알고리즘
    // pi[i]는 주어진 문자열의 부분 문자열 중에서 prefix == suffix 가
    // 될 수 있는 부분 문자열 중에서 가장 긴 것의 길이
    // 출처: https://bowbowbow.tistory.com/6 [멍멍멍]

    static String str;
    static int[] pi;
    static int res;

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str = sc.next();
        res = 0;

        int loop = str.length();

        for (int cnt=0; cnt<loop; cnt++) {
            pi = new int[str.length()];
            for (int i = 1, j = 0; i < str.length(); i++) {
                while (j > 0 && str.charAt(i) != str.charAt(j)) {
                    j = pi[j - 1];
                }
                if (str.charAt(i) == str.charAt(j)) {
                    pi[i] = ++j;
                }
            }
            str = str.substring(1);
            for (int a: pi) {
                res = Math.max(a, res);
            }
        }

       System.out.println(res);
    }
}
