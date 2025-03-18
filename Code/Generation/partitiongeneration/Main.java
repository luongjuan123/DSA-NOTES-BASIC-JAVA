package Generation.partitiongeneration;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] a = new int[100];
    static boolean check = true;
    static int n, cnt = 1;
    static void firstPartition() {
        a[1] = n;
        for (int i = 2; i <= 99; i ++) {
            a[i] = 0;
        }
    }
    static void nextPartition() {
        int i = cnt;
        while (i >= 1 && a[i] == 1) {
            i --;
        }
        if (i == 0) {
            check = false;
        }
        else {
            a[i] --;
            int d = cnt - i + 1;
            cnt = i;
            int q = d / a[i];
            int r = d % a[i];
            if (q > 0) {
                for (int j = 1; j <= q; j ++) {
                    cnt ++;
                    a[cnt] = a[i];
                }
            }
            if (r > 0) {
                cnt ++;
                a[cnt] = r;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        firstPartition();
        while (check) {
            //System.out.println(cnt);
            for (int i = 1; i <= cnt; i ++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            nextPartition();
        }
    }
}