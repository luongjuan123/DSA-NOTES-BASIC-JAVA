package permutation_generation;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int[] a = new int[100];
    static int n, k;
    static boolean check = true;

    static void firstPermutation() {
        for (int i = 1; i <= k; i ++) {
            a[i] = i;
        }

    }
    static void nextPermutation() {
        int i = n - 1;
        while ( i >= 1 && a[i] > a[i + 1]) {
            i --;
        }
        if (i == 0) {
            check = false;
        }
        else {
            int j = n;
            while (a[j] < a[i]) {
                j --;
            }
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        firstPermutation();
        while (check) {
            for (int i = 1; i <= k; i ++) {
                System.out.print(a[i]);
            }
            nextPermutation();
            System.out.println();
        }
    }
}
