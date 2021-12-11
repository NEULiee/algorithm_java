package com.neuli.boj;

/**
 * 1764 듣보잡
 *
 * String List 정렬해서 중복 찾음
 * 시간초과: Collection.contains() 로 하나하나 찾았을 때
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1764 {

    static int N, M, result;
    static List<String> listenAndLookNames, names;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        result = 0;

        listenAndLookNames = new ArrayList<>();
        names = new ArrayList<>();

        for (int i=0; i<N+M; i++) {
            listenAndLookNames.add(br.readLine());
        }

        Collections.sort(listenAndLookNames);

        for (int i=0; i<N+M; i++) {
            if (i == N + M - 1) {
                break;
            }
            if (listenAndLookNames.get(i).equals(listenAndLookNames.get(i+1))) {
                result++;
                names.add(listenAndLookNames.get(i));
                i += 1;
            }
        }

        System.out.println(result);
        for (String name: names) {
            System.out.println(name);
        }
    }
}
