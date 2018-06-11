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
 * @author nelly
 */
public class CountAPI {
    /*
    calls = [
        "/project1/subproject1/method1",
        "/project2/subproject1/method1",
        "/project1/subproject1/method1",
        "/project1/subproject2/method1",
        "/project1/subproject1/method2",
        "/project1/subproject2/method1",
        "/project2/subproject1/method1",
        "/project1/subproject2/method1"
       ]
    
    countAPI(calls) = [
        "--project1 (6)",
        "----subproject1 (3)",
        "------method1 (2)",
        "------method2 (1)",
        "----subproject2 (3)",
        "------method1 (3)",
        "--project2 (2)",
        "----subproject1 (2)",
        "------method1 (2)"
       ]
    */
    static class Node {
        int callCount = 0;
        String name;
        List<Node> children;
        public Node(String name) {
            this.name = name;
            children = new ArrayList<>();
        }
        
        public void addChild(Node n) {
            children.add(n);
        }
    }
    static Node findNode(Node root, String name) {
        if(root == null) {
            return null;
        }
        if(root.name.equals(name)) {
            return root;
        }
        Node found = null;
        for(Node current : root.children) {
            found = findNode(current, name);
            if(found != null) {
                return found;
            }
        }
        return found;
    }
    
    public static void main(String args[]) {
        Node root = new Node("");
        String calls[] = {
            "/project1/subproject1/method1",
            "/project2/subproject1/method1",
            "/project1/subproject1/method1",
            "/project1/subproject2/method1",
            "/project1/subproject1/method2",
            "/project1/subproject2/method1",
            "/project2/subproject1/method1",
            "/project1/subproject2/method1"
        };
        Node parent = root;
        for(String call: calls) {
            String current[] = call.split("/");
            for(String item : current) {
                if(item != null && item.length()>0) {
                    Node n = findNode(parent, item);
                    if(n == null) {
                        n = new Node(item);
                        parent.addChild(n);
                    }
                    n.callCount++;
                    parent = n;
                }
            }
            parent = root;
        }
        printCallCount(root, "--");
    }
    
    static void printCallCount(Node root, String separator) {
        if(root == null) {
            return;
        }
        for(Node n : root.children) {
            System.out.println(String.format(
                    "%s%s (%d)", separator, n.name,n.callCount));
            printCallCount(n, separator + "--");
        }
        
        
    }
    
}
