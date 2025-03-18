package Generation.combination_generation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] a = new int[100];
    static int n, k;
    static boolean check = true;

    // Hàm khởi tạo tổ hợp đầu tiên {1, 2, ..., k}
    static void initFirstCombination() {
        for (int i = 1; i <= k; i++) {
            a[i] = i;
        }
    }

    // Hàm sinh tổ hợp tiếp theo
    static void nextCombination() {
        int i = k;
        while (i >= 1 && a[i] == n - k + i) {
            i--;
        }
        if (i == 0) {
            check = false;
        } else {
            a[i]++;
            for (int j = i + 1; j <= k; j++) {
                a[j] = a[j - 1] + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        // Khởi tạo tổ hợp đầu tiên
        initFirstCombination();

        while (check) {
            for (int i = 1; i <= k; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            nextCombination();
        }

        sc.close();
    }
}
