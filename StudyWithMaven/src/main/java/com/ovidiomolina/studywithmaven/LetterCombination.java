/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovidiomolina.studywithmaven;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ovidiomolina
 */
public class LetterCombination {
    
    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        HashMap<Character, String> map = new HashMap();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        LinkedList<String> result = new LinkedList();
        result.add("");
        for(int i=0; i<digits.length(); i++){
            String currentLetters = map.get(digits.charAt(i));
            while(result.peek().length() == i) {
                String word = result.remove();
                for(int j=0; j<currentLetters.length(); j++){
                    StringBuilder sb = new StringBuilder(word);
                    sb.append(currentLetters.charAt(j));
                    result.add(sb.toString());
                }
            }
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        List<String> result = letterCombinations("23");
        System.out.println(result.size());
    }
}
