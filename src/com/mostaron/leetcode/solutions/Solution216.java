package com.mostaron.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {

    private List<Integer> stack = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int k, int n) {
//        List<List<Integer>> result = new ArrayList<>();

        for(int i=1; i<=9; i++){
            f(i, k, n);
        }

        return result;
    }


    public void f(int start, int num, int target){

        stack.add(start);
        if(num == 1){
            int sum = stack.parallelStream().mapToInt(i -> i).sum();
            if(sum == target) result.add(new ArrayList<>(stack));
        }
        for(int i=1; start + i <= 9; i++){
            f(start + i, num - 1, target);
        }
        stack.remove(Integer.valueOf(start));
}
    public static void main(String...args){
        List<List<Integer>>result = new Solution216().combinationSum(3,15);
        result.stream().forEach(e -> {
            e.stream().forEach(System.out::print);
            System.out.println();
        });
    }
}
