package com.sorting;

public class RadixSort {
    public static int get_max(int a[])
    {
        int i, max;
        max = a[0];
        for (i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }
    public static int f(int p, int k, int t){
        for(int i=k; i<=t; i++) {
            if(i!=t)
            p/=10;
        }
        return p;
    }

    public static void main(String[] args) {

        //int[] array = {329, 457, 657, 839, 436, 720, 355};
        int[] array = {53, 3, 542, 748, 14, 1001, 214, 154, 63, 616};

        int max;
        max = get_max(array);
        //System.out.println(max);
        int k = 0;
        while (max > 0) {
            int r = max % 10;
            max = max / 10;
            k = k + 1;
        }
        int t = k;
        while (k > 0) {

            for (int i = 0; i < array.length; i++) {
                int min = f(array[i], k, t) % 10;
                int minIndex = i;
                for (int j = i + 1; j < array.length; j++) {
                    int g = f(array[j], k, t) % 10;
                    if (g < min) {
                        min = g;
                        minIndex = j;
                    }
                }
                if (i != minIndex) {
                    int tmp = array[i];
                    array[i] = array[minIndex];
                    array[minIndex] = tmp;
                }
            }
            k--;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        /*
        int[] array = {53, 3, 542, 748, 14, 214, 154, 63, 616};
        for(int i=0; i<array.length; i++){
            int min = array[i] % 10;
            int index = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] % 10 < min) {
                    min = array[j]% 10;
                    index = j;
                }
            }
            if (i != index) {
                int tmp = array[i];
                array[i] = array[index];
                array[index] = tmp;
            }
        }

        for(int i=0; i<array.length; i++) {
            int min = array[i] / 10 % 10;
            int min_i = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] / 10 % 10 < min) {
                    min = array[j] / 10 % 10;
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
        for(int i=0; i<array.length; i++) {
            int min = array[i] / 100 % 10;
            int min_i = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] / 100 % 10 < min) {
                    min = array[j] / 100 % 10;
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
            for(int i=0; i<array.length; i++){
                System.out.println(array[i]);
            }*/
    }

}
