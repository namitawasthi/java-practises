package com.practises.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextSmaller {

    public static void main(String[] args) {
        String num = "1432";

        String str[] = String.valueOf(num).split("");
        List<String> list = new ArrayList<>();
        getAllSequences(str.length, str, list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        int ind = list.indexOf(num);
        String nexSmall = "-1";
        if (ind > 0)
            nexSmall = list.get(ind - 1);

        System.out.println(nexSmall);
    }


    public static void getAllSequences(
            int n, String[] elements, List<String> list) {
        if (n == 1) {
            addElement(elements, list);
        } else {
            for (int i = 0; i < n - 1; i++) {
                getAllSequences(n - 1, elements, list);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            getAllSequences(n - 1, elements, list);
        }

    }

    private static void swap(String[] input, int a, int b) {
        String tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static void addElement(String[] input, List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]);
        }
        if (!sb.toString().startsWith("0"))
            list.add(sb.toString());
    }

    public static void getAllSequencesIterative(
            int n, String[] elements, char delimiter, List<String> list) {
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }

        addElement(elements, list);

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ? 0 : indexes[i], i);
                addElement(elements, list);
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }

    }
}
