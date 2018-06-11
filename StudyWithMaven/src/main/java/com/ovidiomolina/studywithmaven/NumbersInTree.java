/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovidiomolina.studywithmaven;

import java.util.*;
/**
 *
 * @author nelly
 */
public class NumbersInTree {
    
    static class Tree {
        Tree left;
        Tree right;
        int value;
        public Tree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    
    public static void main(String args[]) {
        Tree root = new Tree(1);
        root.left = new Tree(0);
        root.left.left = new Tree(3);
        root.left.right = new Tree(1);
        root.right = new Tree(4);
        System.out.println(digitTreeSum(root));
    }
    
    static int digitTreeSum(Tree root) {
        if(root == null) {
            return 0;
        }
        List<List<Integer>> numbers = new ArrayList<>();
        List<Integer> number = new ArrayList<>();
        collectNumbers(root, numbers, number);
        return 0;
    }
    private static void collectNumbers(Tree node, List<List<Integer>> numbers, List<Integer> number) {
        if(node == null) {
            return;
        }
        number.add(node.value);
        if(node.left == null && node.right == null) {
            List<Integer> current = new ArrayList<>();
            current.addAll(number);
            numbers.add(current);
            number.remove(number.size() - 1);
            return;
        }
        collectNumbers(node.left, numbers, number);
        collectNumbers(node.right, numbers, number);
    }
}
