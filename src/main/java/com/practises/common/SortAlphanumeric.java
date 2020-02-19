package com.practises.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortAlphanumeric {

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        String input = sc.nextLine();
        System.out.println(sortAlphaNumericString(input));
    }

    static String sortAlphaNumericString(String input) {
        List<String> list = new ArrayList<>();
        int intSeq = 0, charSeq = 0, prev = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) <= 59 && input.charAt(i) >= 48) {
                intSeq++;
                if (charSeq != 0) {
                    list.add(input.substring(prev, prev + charSeq));
                    charSeq = 0;
                    prev = i;
                }
            } else {
                charSeq++;
                if (intSeq != 0) {
                    list.add(input.substring(prev, prev + intSeq));
                    intSeq = 0;
                    prev = i;
                }

            }

            if (i == input.length() - 1) {
                if (intSeq != 0) {
                    list.add(input.substring(prev, prev + intSeq));
                    intSeq = 0;
                } else if (charSeq != 0) {
                    list.add(input.substring(prev, prev + charSeq));
                    charSeq = 0;
                    prev = i;
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (String st : list) {
            char ch[] = st.toCharArray();
            Arrays.sort(ch);
            sb.append(String.valueOf(ch));
        }

        return sb.toString();
    }
}
