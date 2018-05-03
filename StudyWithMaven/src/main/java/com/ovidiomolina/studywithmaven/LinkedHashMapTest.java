/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovidiomolina.studywithmaven;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author ovidiomolina
 */
public class LinkedHashMapTest {
    
    public static void main(String args[]) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("one", "one");
        map.put("two", "two");
        map.put("three", "three");
        map.put("four", "four");
        map.put("five", "five");
        for(String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
