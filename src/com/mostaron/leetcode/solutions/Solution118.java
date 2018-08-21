package com.mostaron.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = null;
        for(int i = 1; i<= numRows; i++){
            row = generateRow(row, i);
            result.add(row);
        }
        return result;
    }

    public List<Integer> generateRow(List<Integer> lastRow, int rowNumber){

        return IntStream.range(0, rowNumber)
                .boxed()
                .parallel()
                .map(i->{
                    if(lastRow == null){
                        return 1;
                    }
                    Integer left = 1;
                    Integer right = 1;
                    if (i != 0){
                        left = lastRow.get(i-1);
                    }else{
                        return 1;
                    }
                    if(i != lastRow.size()){
                        right = lastRow.get(i);
                    }else{
                        return 1;
                    }
                    return (Integer)(left + right);
                }).collect(Collectors.toList());

    }

    public static void main(String...args){

        new Solution118().generate(9).stream()
                .forEach(l -> {
                    l.stream()
                            .forEach(i -> System.out.print(i + " "));
                    System.out.println();
                });

    }
}
