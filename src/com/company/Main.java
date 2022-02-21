package com.company;

import java.util.List;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        System.out.println("Введите массив целых чисел");
        Scanner sc = new Scanner(System.in);
        List<String> l = List.of(sc.nextLine().split(" "));
        int n = l.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(l.get(i));

        sort(a);

        int m = n;
        for (int i = 0; i < n; i++) {
            if (i > 0 && a[i] == a[i - 1]) {
                m--;
            }
        }

        int[][] b = new int[m][2];

        int k = -1;
        for (int i = 0; i < n; i++){
            if (i>0 && a[i] == a[i-1]){
                b[k][1] ++;
            }
            else{
                k++;
                b[k][0] = a[i];
                b[k][1] = 1;
            }
        }

        System.out.println("Частотный массив:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(b[i][j] + " ");
            System.out.println();

        }
    }
    public static void sort(int[] array) {
        boolean sorted = false;
        int x;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    x = array[i];
                    array[i] = array[i+1];
                    array[i+1] = x;
                    sorted = false;
                }
            }
        }
    }
}