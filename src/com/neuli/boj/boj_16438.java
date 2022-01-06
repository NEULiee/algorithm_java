package com.neuli.boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj_16438 {

    static char[][] team;
    static int N;

    static void setTeam(int start, int end, char cur, int day) {
        if (day == 7) {
            return;
        }
        int mid = (start + end) / 2;
        char firstTeam = cur == 'A' ? 'A' : 'B';
        char secondTeam = cur == 'A' ? 'B' : 'A';

        Arrays.fill(team[day], start, mid+1, firstTeam);
        Arrays.fill(team[day], mid + 1, end + 1, secondTeam);

        setTeam(start, mid, secondTeam,day + 1);
        setTeam(mid + 1, end, firstTeam, day + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        team = new char[7][N];
        for (int i=0; i<7; i++) {
            Arrays.fill(team[i], 'A');
        }

        setTeam(0, N-1, 'A', 0);

        for (int i=0; i<7; i++) {
            for (char cur: team[i]) {
                System.out.print(cur);
            }
            System.out.println();
        }
    }
}
