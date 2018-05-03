/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovidiomolina.studywithmaven;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ovidiomolina
 */
public class Permutatinos {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(nums, lists, list);
        return lists;
    }
    
    static void dfs(int[] nums, List<List<Integer>> lists, List<Integer> list){
        if(nums.length == list.size()){
            lists.add(new ArrayList<Integer>(list));
        }
        for(int i=0; i<nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                dfs(nums, lists, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public static void main(String args[]) {
        int arr[] = new int[] {1,2};
        List<List<Integer>> permutations = permute(arr);
        System.out.println(permutations.size());
    }
}
