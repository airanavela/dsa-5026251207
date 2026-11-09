package lw04.prelab.unguided;

public package lw04.unguided;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RakaCards {

    static void sortCards(int[] arr, int passes) {
        for (int i = 0; i < passes && i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }

    static int findCard(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("cards.txt"))) {
            int n = sc.nextInt();
            int[] cards = new int[n];
            for (int i = 0; i < n; i++) {
                cards[i] = sc.nextInt();
            }

            int m = sc.nextInt();
            int[] requests = new int[m];
            for (int i = 0; i < m; i++) {
                requests[i] = sc.nextInt();
            }

            sortCards(cards, 2);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(" ");
                sb.append(cards[i]);
            }
            System.out.println(sb);

            for (int i = 0; i < m; i++) {
                int idx = findCard(cards, requests[i]);
                if (idx >= 0) {
                    System.out.println(requests[i] + ": FOUND at index " + idx);
                } else {
                    System.out.println(requests[i] + ": NOT FOUND");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("cards.txt not found");
        }
    }
} {
    
}
