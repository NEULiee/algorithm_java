package com.neuli.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_9324 {

    static int T;
    static int[] count;
    static String M;
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {

            count = new int[26];

            M = br.readLine();
            arr = M.toCharArray();

            for (int i=0; i<M.length(); i++) {
                count[arr[i] - 'A']++;
                if (count[arr[i] - 'A'] != 0 && count[arr[i] - 'A'] % 3 == 0) {
                    if (i + 1 == M.length()) {
                        System.out.println("FAKE");
                        break;
                    }
                    if (arr[i + 1] != arr[i]) {
                        System.out.println("FAKE");
                        break;
                    }
                    i++;
                }
                if (i == M.length() - 1) {
                    System.out.println("OK");
                }
            }
        }
    }
}
