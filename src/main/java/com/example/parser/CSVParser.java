package com.example.parser;


import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVParser {

    public static String invert(List<String[]> stringsList) {

        //  first we need to find the size of the longest row.
        //  This determines the number of rows in the output
        int maxLength = -1;
        for (String[] array : stringsList) {
            if (array.length > maxLength) {
                maxLength = array.length;
            }
        }

        List<List<String>> output = new ArrayList<>(maxLength);
        for (int i = 0; i < stringsList.size(); i++) {
            String[] innerList = stringsList.get(i);
            for (int j = 0; j < maxLength; j++) {
                if (output.size() <= j) {
                    output.add(new ArrayList<>());
                }
                if (j < innerList.length) {
                    output.get(j).add(innerList[j]);
                } else {
                    output.get(j).add(" ");
                }
            }
        }

        StringBuilder stringOutput = new StringBuilder();
        for (List<String> list : output) {
            stringOutput.append(String.join(",", list));
            stringOutput.append("\n");
        }

        return stringOutput.toString();
    }

    public static String flatten(List<String[]> stringsList) {
        return stringsList.stream()
                .flatMap(Stream::of)
                .collect(Collectors.joining(","));
    }

    public static Integer sum(List<String[]> stringsList) throws Exception {
        List<String> list = stringsList.stream()
                .flatMap(Stream::of)
                .collect(Collectors.toList());
        boolean containsNumber = false;
        Integer sum = 0;
        for (String s : list) {
            if (NumberUtils.isParsable(s)) {
                sum += Integer.parseInt(s);
                containsNumber = true;
            }
        }
        if (!containsNumber) {
            throw new Exception("No number found in matrix");
        }
        return sum;
    }

    public static Integer multiply(List<String[]> stringsList) throws Exception {
        List<String> list = stringsList.stream()
                .flatMap(Stream::of)
                .collect(Collectors.toList());
        boolean containsNumber = false;
        Integer product = 1;
        for (String s : list) {
            if (NumberUtils.isParsable(s)) {
                product *= Integer.parseInt(s);
                containsNumber = true;
            }
        }
        if (!containsNumber) {
            throw new Exception("No number found in matrix");
        }
        return product;
    }
}
