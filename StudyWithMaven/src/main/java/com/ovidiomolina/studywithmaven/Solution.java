package com.ovidiomolina.studywithmaven;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String dictionary[] = new String[]{"nyuqpier", "nyuzsad", "nyaxdfs", "nybxdfs", "nycxdfs"};
        List<String> ordering = relativeOrdering(dictionary);
        for(String current : ordering) {
            System.out.println(current);
        }
    }
    
    /**
     * Given a list of words in the dictionary in right order, find out the relative order of letters in the alphabet.

    Input - List("nyuqpier", "nyuzsad", "nyaxdfs", "nybxdfs", "nycxdfs")

    Output - List("u->a->b->c", "q->z")
    */
    
    public static List<String> relativeOrdering(String dictionary[]) {
        List<String> ordering = new ArrayList<>();
        for(int i=0; i<dictionary.length; i++) {
            if(i+1 < dictionary.length) {
                String first = dictionary[i];
                String second = dictionary[i+1];
                int j = 0;
                while(first.charAt(j) == second.charAt(j)){
                    j++;
                }
                ordering.add("" + first.charAt(j) + "" + second.charAt(j));
            }
        }
        return ordering;
    }
}