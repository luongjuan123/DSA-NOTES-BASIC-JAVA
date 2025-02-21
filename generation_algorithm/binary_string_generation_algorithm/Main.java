package binary_string_generation_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] a = new int[100];

    static int n;
    static boolean check = true;

    static void init() {
        int i = n;
        while (i >= 1 && a[i] == 1) {
            a[i] = 0;
            i --;
        }
        if (i == 0) {
            check = false;
        }
        else {
            a[i] = 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(a, 0);
        while (check) {
            for (int i = 1; i <= n; i ++) {
                System.out.print(a[i] + " ");
            }
            init();
            System.out.println();
        }
    }
}
